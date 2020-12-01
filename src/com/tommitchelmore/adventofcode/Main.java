package com.tommitchelmore.adventofcode;

import com.tommitchelmore.adventofcode.common.Day;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
  public static void main(String[] args)
      throws IOException, NoSuchMethodException, IllegalAccessException,
          InvocationTargetException, InstantiationException {

    for (int day = 1; day <= 25; day++) {

      try {

        Day instance = (Day) Class
            .forName("com.tommitchelmore.adventofcode.year2020.days.Day" + day)
            .getDeclaredConstructor()
            .newInstance();

        System.out.println("=========== Day " + day + " ===========");
        instance.printParts();
        System.out.println();

      } catch (ClassNotFoundException e) {

        //Rare case of an intentionally blank catch block :o

      }
    }
  }
}
