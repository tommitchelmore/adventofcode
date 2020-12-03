package com.tommitchelmore.adventofcode.year2020.days;

import com.tommitchelmore.adventofcode.common.Day;
import com.tommitchelmore.adventofcode.common.InputFileManager;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Day3 implements Day {

  @Override
  public Integer partOne() throws IOException {
    return checkSlope(3, 1);
  }

  @Override
  public Long partTwo() throws IOException {
    int[][] slopes = {{1,1}, {3,1}, {5,1}, {7,1}, {1,2}};
    return Arrays.stream(slopes)
        .mapToLong(s -> {
          try {
            return checkSlope(s[0], s[1]);
          } catch (IOException e) {
            //Something went horribly, horribly wrong
            e.printStackTrace();
            return 0;
          }
        })
        .reduce(1, (a, b) -> a * b);
  }

  private int checkSlope(int right, int down) throws IOException {
    ArrayList<String> lines = getArray();

    int[] currentPos = {0,0};
    String currentLine;
    int trees = 0;

    for (int i = 0; i < (lines.size() / down) - 1; i++) {
      currentPos[0] = (currentPos[0] + right) % lines.get(0).length();
      currentPos[1] += down;
      currentLine = lines.get(currentPos[1]);
      if (currentLine.charAt(currentPos[0]) == '#') {
        trees += 1;
      }
    }
    return trees;
  }

  private ArrayList<String> getArray() throws IOException {
    BufferedReader br = new InputFileManager().getInputFile(3);
    ArrayList<String> lines = new ArrayList<>();
    String line;
    while ((line = br.readLine()) != null) {
      lines.add(line);
    }
    return lines;
  }
}
