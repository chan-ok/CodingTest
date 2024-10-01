package study.codingtest.baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class BOJ_10815 {

//  public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    br.readLine();
//
//    Map<Integer, Integer> cardMap = new HashMap<>();
//    List<Integer> cardList = Arrays.stream(br.readLine().split(" "))
//        .map(Integer::parseInt)
//        .collect(Collectors.toList());
//    for (int card : cardList) {
//      cardMap.put(card, cardMap.getOrDefault(card, 0) + 1);
//    }
//    br.readLine();
//    List<Integer> targetCardList = Arrays.stream(br.readLine().split(" "))
//        .map(Integer::parseInt)
//        .collect(Collectors.toList());
//
//    StringBuilder sb = new StringBuilder();
//    for (int targetCard : targetCardList) {
//      sb.append(cardMap.getOrDefault(targetCard, 0)).append(" ");
//    }
//    System.out.println(sb);
//  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String ignore = br.readLine();
    Map<String, Long> cards = Arrays.stream(br.readLine().split(" "))
        .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    String ignore2 = br.readLine();
    StringBuilder sb = new StringBuilder();
    Arrays.stream(br.readLine().split(" "))
        .map(i -> cards.containsKey(i) ? 1 : 0)
        .forEach(i -> sb.append(i).append(" "));
    System.out.println(sb);
  }

}
