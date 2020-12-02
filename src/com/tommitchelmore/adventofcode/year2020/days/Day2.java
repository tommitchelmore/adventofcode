package com.tommitchelmore.adventofcode.year2020.days;

import static java.lang.Integer.parseInt;

import com.tommitchelmore.adventofcode.common.Day;
import com.tommitchelmore.adventofcode.common.InputFileManager;
import com.tommitchelmore.adventofcode.year2020.util.day2.Password;
import com.tommitchelmore.adventofcode.year2020.util.day2.PasswordPolicy;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2 implements Day {

  @Override
  public Integer partOne() throws IOException {

    ArrayList<Password> passwords = getPasswords();
    Iterator<Password> iter = passwords.iterator();

    while (iter.hasNext()) {
      Password pw = iter.next();
      int occurrences = countCharInString(pw.getContent(), pw.getPolicy().getCharacter());
      if (occurrences < pw.getPolicy().getMin() || occurrences > pw.getPolicy().getMax()) {
        iter.remove();
      }
    }

    return passwords.size();
  }

  @Override
  public Integer partTwo() throws IOException {

    ArrayList<Password> passwords = getPasswords();

    passwords.removeIf(
        pw -> {
          int l = pw.getPolicy().getMin() - 1;
          int u = pw.getPolicy().getMax() - 1;
          char c = pw.getPolicy().getCharacter();
          String con = pw.getContent();

          /* Effectively XOR the checks for char in each location */
          return (con.charAt(l) == c) == (con.charAt(u) == c);
        });

    return passwords.size();
  }

  private int countCharInString(String hay, char needle) {

    int count = 0;
    for (int i = 0; i < hay.length(); i++) {
      if (hay.charAt(i) == needle) {
        count++;
      }
    }

    return count;
  }

  private ArrayList<Password> getPasswords() throws IOException {

    BufferedReader br = new InputFileManager().getInputFile(2);

    ArrayList<Password> passwords = new ArrayList<>();
    String line;
    Pattern pattern = Pattern.compile("(\\d*)-(\\d*) ([a-z]): ([a-z]*)");

    while ((line = br.readLine()) != null) {
      Matcher m = pattern.matcher(line);
      if (m.find()) {
        passwords.add(
            new Password(
                new PasswordPolicy(
                    parseInt(m.group(1)), parseInt(m.group(2)), m.group(3).charAt(0)),
                m.group(4)));
      }
    }

    return passwords;
  }
}
