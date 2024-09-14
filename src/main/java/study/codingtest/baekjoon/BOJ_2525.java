package study.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.StringTokenizer;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class BOJ_2525 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int hour = Integer.parseInt(st.nextToken());
    int minute = Integer.parseInt(st.nextToken());

    int addMinute = Integer.parseInt(br.readLine());
    LocalTime time = LocalTime.of(hour, minute).plusMinutes(addMinute);
    System.out.println(time.getHour() + " " + time.getMinute());
    br.close();
  }
}
