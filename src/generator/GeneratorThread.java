/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import comunication.UDPComunication;
import java.io.IOException;
import java.net.SocketException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dyancarra
 */
public class GeneratorThread implements Runnable {

  private Integer type;
  private Integer minValue;
  private Integer maxValue;
  private Integer sleepTime;

  public GeneratorThread(Integer type, Integer minValue, Integer maxValue, Integer minTime, Integer maxTime) {
    this.type = type;
    this.minValue = minValue;
    this.maxValue = maxValue;
    this.sleepTime = new Random().nextInt(maxTime - minTime) + minTime;
  }

  @Override
  @SuppressWarnings("SleepWhileInLoop")
  public void run() {
    while (true) {
      try {
        Information information = new Information(type, minValue, maxValue);
        System.out.println("Informacao Gerada ~> " + information.pack());
        
        UDPComunication udp = new UDPComunication();
        udp.sendBytes(information);

        Thread.sleep(sleepTime);
      } catch (InterruptedException ex) {
        Logger.getLogger(GeneratorThread.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SocketException ex) {
        Logger.getLogger(GeneratorThread.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
        Logger.getLogger(GeneratorThread.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

}
