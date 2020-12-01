package com.tommitchelmore.adventofcode.common;

import java.io.IOException;

/** The interface Day. */
public interface Day {

  /**
   * Challenge Part One
   *
   * @return the output from part one
   * @throws IOException IOException
   */
  Object partOne() throws IOException;

  /**
   * Challenge Part Two
   *
   * @return the output from part two
   * @throws IOException IOException
   */
  Object partTwo() throws IOException;

  /**
   * Print the outputs of each part
   *
   * @throws IOException IOException
   */
  default void printParts() throws IOException {
    System.out.println("Part 1: " + partOne());
    System.out.println("Part 2: " + partTwo());
  }
}
