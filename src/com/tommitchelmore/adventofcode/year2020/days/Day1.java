package com.tommitchelmore.adventofcode.year2020.days;

import static java.lang.Integer.parseInt;

import com.tommitchelmore.adventofcode.common.Day;
import com.tommitchelmore.adventofcode.common.InputFileManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Day1 implements Day {

  @Override
  public AtomicInteger partOne() throws IOException {

    ArrayList<Integer> list = getList();
    AtomicInteger res = new AtomicInteger();

    list.forEach(
        i -> list
            .stream()
            .filter(j -> 2020 - i == j)
            .findAny()
            .ifPresent(j -> res.set(i * j)));

    return res;
  }

  @Override
  public AtomicInteger partTwo() throws IOException {

    ArrayList<Integer> list = getList();
    AtomicInteger res = new AtomicInteger();

    list.forEach(
        i -> {
          list.forEach(
              j -> {
                list.stream()
                    .filter(k -> (2020 - i) - j == k)
                    .findAny()
                    .ifPresent(k -> res.set(i * j * k));
              });
        });

    return res;
  }

  private ArrayList<Integer> getList() throws IOException {

    BufferedReader br = new InputFileManager().getInputFile(1);

    ArrayList<Integer> list = new ArrayList<>();
    String line;

    while ((line = br.readLine()) != null) {
      list.add(parseInt(line));
    }

    return list;
  }
}
