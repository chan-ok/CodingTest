package study.codingtest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC_336 {

  public List<List<Integer>> palindromePairs(String[] words) {
    Trie t = new Trie();
    List<List<Integer>> results = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      t.insert(i, words[i]);
    }

    for (int i = 0; i < words.length; i++) {
      results.addAll(t.search(i, words[i]));
    }
    return results;
  }

  public static class TrieNode {

    int wordId;
    TrieNode[] children;
    List<Integer> palindromeWordIds;

    public TrieNode() {
      this.children = new TrieNode[26];
      this.wordId = -1;
      this.palindromeWordIds = new ArrayList<>();
    }
  }

  class Trie {

    TrieNode root;

    public Trie() {
      this.root = new TrieNode();
    }

    public boolean isPalindrome(String str, int start, int end) {
      while (start < end) {
        if (str.charAt(start++) != str.charAt(end--)) {
          return false;
        }
      }
      return true;
    }

    public void insert(int index, String word) {
      TrieNode cur = root;
      for (int i = word.length() - 1; i >= 0; i--) {
        char c = word.charAt(i);
        if (isPalindrome(word, 0, i)) {
          cur.palindromeWordIds.add(index);
        }
        if (cur.children[c - 'a'] == null) {
          cur.children[c - 'a'] = new TrieNode();
        }
        cur = cur.children[c - 'a'];
      }
      cur.wordId = index;
    }

    public List<List<Integer>> search(int index, String word) {
      TrieNode cur = root;
      List<List<Integer>> result = new ArrayList<>();

      for (int i = 0; i < word.length(); i++) {
        if (cur.wordId >= 0 && isPalindrome(word, i, word.length() - 1)) {
          result.add(List.of(index, cur.wordId));
        }
        if (cur.children[word.charAt(i) - 'a'] == null) {
          return result;
        }
        cur = cur.children[word.charAt(i) - 'a'];
      }

      if (cur.wordId >= 0 && cur.wordId != index) {
        result.add(List.of(index, cur.wordId));
      }
      for (int palindromeWordId : cur.palindromeWordIds) {
        result.add(List.of(index, palindromeWordId));
      }
      return result;
    }
  }
}
