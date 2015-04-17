/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 *
 * @author dyancarra
 */
public class Consumer implements Runnable {

  private Integer type;
  private JTextArea textArea;
  Socket socket;

  public static void main(String args[]) {
    ConsumerView consumerView = new ConsumerView();
    consumerView.setVisible(true);
  }

  public Consumer(Integer type, JTextArea textArea) throws IOException {
    this.type = type;
    this.textArea = textArea;
    this.socket = new Socket("localhost", 6000);
  }

  @Override
  public void run() {
    try {

      // Preparing to sendo to Server
      OutputStream outToServer = socket.getOutputStream();
      DataOutputStream out = new DataOutputStream(outToServer);
      
      // Convert type to String
      String typeString = String.valueOf(this.type);
      
      // Send category to Server
      out.writeUTF(typeString);

      // Receive from server
      InputStream inFromServer = socket.getInputStream();
      DataInputStream in = new DataInputStream(inFromServer);
      
      while (true) {
        textArea.append(in.readUTF() + "\n");
      }

    } catch (Exception e) {
    }
  }

}
