package day_1;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    partOne();
    partTwo();
  }

  private static void partOne() {
    try {

      BufferedReader bufferedReader = new BufferedReader(new FileReader("inputs/day_1.txt"));
      ArrayList<Integer> list = new ArrayList<>();
      String line;

      while ((line = bufferedReader.readLine()) != null) {
        list.add(parseInt(line));
      }

      list.forEach(
          i -> {
            list.stream()
                .filter(j -> 2020 - i == j)
                .findAny()
                .ifPresent(j -> System.out.println(i * j));
          });

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void partTwo() {
    try {

      BufferedReader bufferedReader = new BufferedReader(new FileReader("inputs/day_1.txt"));
      ArrayList<Integer> list = new ArrayList<>();
      String line;

      while ((line = bufferedReader.readLine()) != null) {
        list.add(parseInt(line));
      }

      list.forEach(
          i -> {
            list.forEach(
                j -> {
                  list.stream()
                      .filter(k -> (2020 - i) - j == k)
                      .findAny()
                      .ifPresent(k -> System.out.println(i * j * k));
                });
          });

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
