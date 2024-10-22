package study.codingtest.baekjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;

public class BOJ_29731 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<String> list = List.of(
        "Never gonna give you up",
        "Never gonna let you down",
        "Never gonna run around and desert you",
        "Never gonna make you cry",
        "Never gonna say goodbye",
        "Never gonna tell a lie and hurt you",
        "Never gonna stop");
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      String input = br.readLine();
      if (list.stream().noneMatch(input::equals)) {
        System.out.println("Yes");
        return;
      }
    }
    System.out.println("No");

  }

}
