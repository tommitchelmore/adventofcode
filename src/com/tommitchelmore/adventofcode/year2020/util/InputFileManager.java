package com.tommitchelmore.adventofcode.year2020.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class InputFileManager {
  public BufferedReader getInputFile(int day) throws IOException {

    String sessionId = getSessionId();
    URL url = new URL("https://adventofcode.com/2020/day/" + day + "/input");

    URLConnection connection = url.openConnection();
    connection.addRequestProperty("Cookie", "session=" + sessionId);

    return new BufferedReader(new InputStreamReader(connection.getInputStream()));

  }

  public BufferedReader getInputFile(String fileName) throws FileNotFoundException {

    return new BufferedReader(new FileReader(fileName));

  }

  private static String getSessionId() throws IOException {

    BufferedReader reader = new BufferedReader(new FileReader("session"));
    return reader.readLine();

  }
}
