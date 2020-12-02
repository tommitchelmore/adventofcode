package com.tommitchelmore.adventofcode.year2020;

import com.tommitchelmore.adventofcode.common.Day;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

/** The type Main. */
public class Main {

  /**
   * The entry point of application.
   *
   * @param args the input arguments - see README.md
   * @throws IOException io exception
   * @throws IllegalAccessException illegal access exception
   * @throws InvocationTargetException invocation target exception
   * @throws InstantiationException instantiation exception
   * @throws NoSuchMethodException no such method exception
   */
  public static void main(String[] args)
      throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException,
          NoSuchMethodException {

    try {
      try {
        printDay(Integer.parseInt(args[0]));
      } catch (NumberFormatException e) {
        // Not an int, look for "all" instead
      }

      if (args[0].equals("all")) {
        printAllDays();
      }

    } catch (ArrayIndexOutOfBoundsException e) {
      Calendar cal = Calendar.getInstance();
      if (cal.get(Calendar.MONTH) == Calendar.DECEMBER) {
        printDay(cal.get(Calendar.DAY_OF_MONTH));
      } else {
        printAllDays();
      }

    }
  }

  /**
   * Print all days of the 2020 AoC.
   *
   * @throws IOException io exception
   * @throws IllegalAccessException illegal access exception
   * @throws InvocationTargetException invocation target exception
   * @throws InstantiationException instantiation exception
   * @throws NoSuchMethodException no such method exception
   */
  public static void printAllDays()
      throws IllegalAccessException, InvocationTargetException, InstantiationException, IOException,
          NoSuchMethodException {
    for (int day = 1; day <= 25; day++) {
      printDay(day);
    }
  }

  /**
   * Print a specific day of the AoC 2020.
   *
   * @param day the day
   * @throws IOException io exception
   * @throws IllegalAccessException illegal access exception
   * @throws InvocationTargetException invocation target exception
   * @throws InstantiationException instantiation exception
   * @throws NoSuchMethodException no such method exception
   */
  public static void printDay(int day)
      throws IllegalAccessException, InvocationTargetException, InstantiationException, IOException,
          NoSuchMethodException {
    try {

      Day instance =
          (Day)
              Class.forName("com.tommitchelmore.adventofcode.year2020.days.Day" + day)
                  .getDeclaredConstructor()
                  .newInstance();

      System.out.println("=========== Day " + day + " ===========");
      instance.printParts();
      System.out.println();

    } catch (ClassNotFoundException e) {

      // Rare case of an intentionally blank catch block :o

    }
  }
}
