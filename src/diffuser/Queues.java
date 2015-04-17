/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffuser;

import generator.Information;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author dyancarra
 */
public class Queues {

  public Queue<Information> sportsQueue;
  public Queue<Information> newsQueue;
  public Queue<Information> eletronicQueue;
  public Queue<Information> policyQueue;
  public Queue<Information> businessQueue;
  public Queue<Information> travelQueue;

  public Queues() {
    sportsQueue    = new LinkedList();
    newsQueue      = new LinkedList();
    eletronicQueue = new LinkedList();
    policyQueue    = new LinkedList();
    businessQueue  = new LinkedList();
    travelQueue    = new LinkedList();
  }

}
