package com.tommitchelmore.adventofcode.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/** The type Input file manager. */
public class InputFileManager {

  /**
   * Gets the input text from the AdventOfCode website
   *
   * @param day the day to fetch
   * @return input.txt for the given day as a BufferedReader
   * @throws IOException IOException
   */
  public BufferedReader getInputFile(int day) throws IOException {

    String sessionId = getSessionId();
    URL url = new URL("https://adventofcode.com/2020/day/" + day + "/input");

    URLConnection connection = url.openConnection();
    connection.addRequestProperty("Cookie", "session=" + sessionId);

    return new BufferedReader(new InputStreamReader(connection.getInputStream()));

  }

  /**
   * Gets the input text from a given .txt file
   *
   * @param fileName the file name
   * @return the input file as a BufferedReader
   * @throws FileNotFoundException FileNotFoundException
   */
  public BufferedReader getInputFile(String fileName) throws FileNotFoundException {

    return new BufferedReader(new FileReader(fileName));

  }

  private static String getSessionId() throws IOException {

    BufferedReader reader = new BufferedReader(new FileReader("session"));
    return reader.readLine();

  }
}
