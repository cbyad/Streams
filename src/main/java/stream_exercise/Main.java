package stream_exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Main {

  public static void main(String[] args) throws Exception {

      List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

//get count of empty string
      long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
      System.out.println(count);
  }

}
