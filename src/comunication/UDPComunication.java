/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunication;

import generator.Information;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dyancarra
 */
public class UDPComunication {

  private Integer port = 5000;
  private InetAddress host;
  private DatagramSocket socket;

  public UDPComunication() throws SocketException {
    try {
      this.host = InetAddress.getLocalHost();
    } catch (UnknownHostException ex) {
      Logger.getLogger(UDPComunication.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void sendBytes(Information information) throws IOException {
    byte[] informationBytes = information.pack().getBytes();
    DatagramPacket packet = new DatagramPacket(informationBytes, informationBytes.length, host, port);
    this.socket = new DatagramSocket();
    socket.send(packet);
    socket.close();
    System.out.println("Pacote enviado com informacao do tipo ~> " + information.getType());
  }

  public String receiveBytesAndReturnString() throws IOException {
    DatagramPacket packet = new DatagramPacket(new byte[100], 100);
    this.socket = new DatagramSocket(5000);
    socket.receive(packet);
    socket.close();
    return new String(packet.getData());
  }

}
