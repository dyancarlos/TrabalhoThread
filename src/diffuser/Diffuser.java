/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffuser;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author dyancarra
 */
public class Diffuser {

  public static void main(String args[]) throws SocketException, IOException {

    // Create a List
    Queues queue = new Queues();
    
    // Add elements to the List
    AddToQueue addToQueue = new AddToQueue(queue);
    new Thread(addToQueue).start();
     
    // Server Socket
    ServerSocket serverSocket = new ServerSocket(6000);
    
    while(true){
      // Accept the Connection
      Socket clientSocket = serverSocket.accept();

      // Get the elements of list and send with TCP to consumer
      SendToConsumer sendToConsumer = new SendToConsumer(clientSocket, queue);
      new Thread(sendToConsumer).start();
    }
    
  }

}
