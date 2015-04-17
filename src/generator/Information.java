/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import java.util.Random;

/**
 *
 * @author dyancarra
 */
public class Information {

  private Integer sequence;
  private Integer type;
  private Integer value;

  public Information(){
  }
  
  public Information(Integer type, Integer minValue, Integer maxValue) {
    this.type = type;
    this.value = new Random().nextInt(maxValue - minValue) + minValue;
  }

  public String pack() {
    String typeString = String.valueOf(this.type);
    String valueString = String.valueOf(this.value);
    String packedValue = typeString + ";" + valueString;
    return packedValue;
  }

  public Information unpack(String message) {
    message = message.replaceAll("[^\\d]", ";");
    String[] numbers = message.split(";");

    int[] infos = new int[numbers.length];

    for (int x = 0; x < numbers.length; x++) {
      infos[x] = Integer.parseInt(numbers[x]);
    }

    this.type = infos[0];
    this.value = infos[1];

    return this;
  }

  public Integer getSequence() {
    return sequence;
  }

  public void setSequence(Integer sequence) {
    this.sequence = sequence;
  }

  public Integer getType() {
    return type;
  }

  public Integer getValue() {
    return value;
  }

}
