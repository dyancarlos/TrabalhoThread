/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffuser;

import generator.Information;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dyancarra
 */
public class SendToConsumer implements Runnable {

  Queues queue;
  Socket clientSocket;
  DataInputStream in;
  DataOutputStream out;

  public SendToConsumer(Socket clientSocket, Queues queue) throws IOException {
    this.clientSocket = clientSocket;
    this.queue = queue;
    this.in = new DataInputStream(clientSocket.getInputStream());
    this.out = new DataOutputStream(clientSocket.getOutputStream());
  }

  @Override
  public void run() {
    try {
      Queue<Information> newQueue = null;

      Integer typeInteger = Integer.parseInt(in.readUTF());

      switch (typeInteger) {
        case 1:
          newQueue = queue.sportsQueue;
          break;
        case 2:
          newQueue = queue.newsQueue;
          break;
        case 3:
          newQueue = queue.eletronicQueue;
          break;
        case 4:
          newQueue = queue.policyQueue;
          break;
        case 5:
          newQueue = queue.businessQueue;
          break;
        case 6:
          newQueue = queue.travelQueue;
          break;
      }

      for (Information q : newQueue) {
        out.writeUTF(String.valueOf(q.getValue()));
      }

      Thread.sleep(500);

    } catch (InterruptedException | IOException ex) {
      Logger.getLogger(SendToConsumer.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

}
