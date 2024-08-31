package study.codingtest.baekjoon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BOJ_1697_Test {

  @Test
  void testBFS1() {
    Assertions.assertEquals(4, BOJ_1697.bfs(5, 17));
    Assertions.assertEquals(2, BOJ_1697.bfs(6, 11));
    Assertions.assertEquals(1, BOJ_1697.bfs(0, 1));
    Assertions.assertEquals(1, BOJ_1697.bfs(1, 0));
    Assertions.assertEquals(2, BOJ_1697.bfs(10, 40));
    Assertions.assertEquals(0, BOJ_1697.bfs(0, 0));
    Assertions.assertEquals(5, BOJ_1697.bfs(5, 0));
    Assertions.assertEquals(5, BOJ_1697.bfs(5, 35));
  }

  @Test
  void testBFS2() {
    Assertions.assertEquals(21, BOJ_1697.bfs(1, 100_000));
  }

  @Test
  void testBFS3() {
    Assertions.assertEquals(2343, BOJ_1697.bfs(10007, 98767));
  }

  @Test
  void testBFS4() {
    Assertions.assertEquals(4781, BOJ_1697.bfs(15964, 89498));
  }

  @Test
  void testBFS5() {
    Assertions.assertEquals(637, BOJ_1697.bfs(3482, 45592));
  }

}