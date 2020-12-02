package com.tommitchelmore.adventofcode.year2020.util.day2;

public class PasswordPolicy {

  private int min;
  private int max;
  private char character;

  public PasswordPolicy(int min, int max, char character) {
    this.min = min;
    this.max = max;
    this.character = character;
  }

  public int getMin() {
    return min;
  }

  public int getMax() {
    return max;
  }

  public char getCharacter() {
    return character;
  }
}
