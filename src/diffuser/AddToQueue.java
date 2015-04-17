/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffuser;

import comunication.UDPComunication;
import generator.Information;
import java.io.IOException;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dyancarra
 */
public class AddToQueue implements Runnable {

  Queues queue;
  
  public AddToQueue(Queues queue){
    this.queue = queue;
  }
  
  @Override
  public void run() {
    try {
      UDPComunication udp = new UDPComunication();
      
      while (true) {
        // Information
        Information information = new Information();
        
        // Receive udp datagrams and return a string
        String result = udp.receiveBytesAndReturnString();
        
        // Convert type to Integer
        Integer informationType = information.unpack(result).getType();
        
        // Adding values to the each Queue
        switch (informationType) {
          case 1:
            queue.sportsQueue.offer(information);
            break;
          case 2:
            queue.newsQueue.offer(information);
            break;
          case 3:
            queue.eletronicQueue.offer(information);
            break;
          case 4:
            queue.policyQueue.offer(information);
            break;
          case 5:
            queue.businessQueue.offer(information);
            break;
          case 6:
            queue.travelQueue.offer(information);
            break;
        }
      }
    } catch (SocketException ex) {
      Logger.getLogger(AddToQueue.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(AddToQueue.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
}
