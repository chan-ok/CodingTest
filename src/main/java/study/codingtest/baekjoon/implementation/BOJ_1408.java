package study.codingtest.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class BOJ_1408 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long[] currentTimeArr = Arrays.stream(br.readLine().split(":")).mapToLong(Long::valueOf)
        .toArray();
    int[] missionTimeArr = Arrays.stream(br.readLine().split(":")).mapToInt(Integer::valueOf)
        .toArray();
    LocalTime missionTime = LocalTime.of(missionTimeArr[0], missionTimeArr[1], missionTimeArr[2]);
    LocalTime current = missionTime.minusHours(currentTimeArr[0]).minusMinutes(currentTimeArr[1])
        .minusSeconds(currentTimeArr[2]);
    System.out.println(current.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
  }
}
