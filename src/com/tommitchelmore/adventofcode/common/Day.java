package com.tommitchelmore.adventofcode.common;

import java.io.IOException;

public interface Day {
  Object partOne() throws IOException;

  Object partTwo() throws IOException;

  default void printParts() throws IOException {
    System.out.println("Part 1: " + partOne());
    System.out.println("Part 2: " + partTwo());
  }
}
