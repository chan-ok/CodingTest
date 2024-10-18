package study.codingtest.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16916 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String source = br.readLine();
    String pattern = br.readLine();
    System.out.println(searchByKMP(source, pattern));
  }

  public static int searchByKMP(String source, String pattern) {
    int patternLen = pattern.length();
    int sourceLen = source.length();

    int[] pi = computePiArray(pattern);
    int pp = 0;
    int sp = 0;
    int count = 0;
    while ((sourceLen - sp) >= (patternLen - pp)) {
      if (pattern.charAt(pp) == source.charAt(sp)) {
        pp++;
        sp++;
      }
      if (pp == patternLen) {
        count++;
        break;
      } else if (sp < sourceLen && pattern.charAt(pp) != source.charAt(sp)) {
        if (pp != 0) {
          pp = pi[pp - 1];
        } else {
          sp++;
        }
      }
    }

    return count;
  }

  public static int[] computePiArray(String pattern) {
    int len = 0;
    int i = 1;
    int[] pi = new int[pattern.length()];

    while (i < pattern.length()) {
      if (pattern.charAt(i) == pattern.charAt(len)) {
        len++;
        pi[i] = len;
        i++;
      } else {
        if (len != 0) {
          len = pi[len - 1];
        } else {
          pi[i] = len;
          i++;
        }
      }
    }

    return pi;
  }
}