package ru.homework.work13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class WC {

  static String indent = " ".repeat(3);

  public static void main(String[] args) throws FileNotFoundException {

    final long startTime = System.currentTimeMillis();

    var output = new ArrayList<String[]>();
    Optional<String[]> total = null;
    String textOut = "";
    Integer[] indents = {1, 1, 1};
    String[] outFormats;
    Supplier<String[]> updateFormat = () -> new String[] {
        "%7s %7s %7s%n",
        "%" + indents[0] + "s %" + indents[1] + "s %" + indents[2] + "s %s%n"
    };
    if (args.length == 0) {
      output.add(checkInput(new Scanner(System.in)));
      outFormats = updateFormat.get();
      textOut = String.format(outFormats[0], output.get(0)[0], output.get(0)[1], output.get(0)[2]);
    } else {
      for (String f : args) {
        File file = new File(f);
        if (file.exists()) {
          output.add(
              checkInput(new Scanner(new FileReader(file)), file.length() + "", file.getName())
          );
          output.get(output.size() - 1)[2] = String.valueOf(file.length());
          for (int i = 0; i < indents.length; i++) {
            int lenLetters = output.get(output.size() - 1)[i].length();
            if (indents[i] < lenLetters) {
              indents[i] = lenLetters;
            }
          }
        } else {
          throw new RuntimeException("File " + f + " does not exist");
        }
      }
      outFormats = updateFormat.get();
      textOut =
          output.stream().map(v -> String.format(outFormats[1], v[0], v[1], v[2], v[3])).collect(
              Collectors.joining(""));
      total = output.stream().reduce((o1, o2) -> new String[] {
          "" + (Long.parseLong(o1[0]) + Long.parseLong(o2[0])),
          "" + (Long.parseLong(o1[1]) + Long.parseLong(o2[1])),
          "" + (Long.parseLong(o1[2]) + Long.parseLong(o2[2])),
          "total"
      });
    }
    System.out.print(textOut);
    System.out.print(total.isPresent() ? String
        .format(outFormats[1], total.get()[0], total.get()[1], total.get()[2], total.get()[3])
        : ""
    );

    long time = System.currentTimeMillis() - startTime;
    System.out.println("Время выполнения программы: " + time + " ms");
  }

  public static String[] checkInput(Scanner input, String... opt) {
    var count = new String[] {"0", "0", "0", ""}; // lines, words, bytes, [fileName]
    Consumer<String> calculate = line -> {
      String tmp;
      count[0] = "" + (Long.parseLong(count[0]) + 1L);
      tmp = line.trim().replaceAll("\\s+", " ");
      count[1] =
          tmp.length() > 0 ? "" + (Long.parseLong(count[1]) + tmp.split(" ", -1).length) : count[1];
      count[2] =
          opt.length > 0 ? opt[0] : "" + (Long.parseLong(count[2]) + line.getBytes().length + 1);
      count[3] = opt.length > 0 ? opt[1] : "";
    };
    try {
      while (true) {
        calculate.accept(input.nextLine());
      }
    } catch (NoSuchElementException e) {
      return count;
    }
  }
}
