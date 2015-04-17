/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

/**
 *
 * @author dyancarra
 */
public class Generator {

  public static void main(String args[]) {

    GeneratorThread generatorThread1 = new GeneratorThread(1, 1000, 1500, 1, 100);
    new Thread(generatorThread1).start();

    GeneratorThread generatorThread2 = new GeneratorThread(2, 2000, 2500, 1, 100);
    new Thread(generatorThread2).start();

    GeneratorThread generatorThread3 = new GeneratorThread(3, 3000, 3500, 1, 100);
    new Thread(generatorThread3).start();

    GeneratorThread generatorThread4 = new GeneratorThread(4, 4000, 4500, 1, 100);
    new Thread(generatorThread4).start();

    GeneratorThread generatorThread5 = new GeneratorThread(5, 5000, 5500, 1, 100);
    new Thread(generatorThread5).start();

    GeneratorThread generatorThread6 = new GeneratorThread(6, 6000, 6500, 1, 100);
    new Thread(generatorThread6).start();

  }

}
