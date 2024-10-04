package study.codingtest.leetcode;

public class LC_208 {

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    trie.insert("appear");

    System.out.println(trie.search("apple"));
    System.out.println(trie.search("app"));
    System.out.println(trie.search("appearance"));
    System.out.println(trie.search("appear"));
  }

  public static class Trie {

    TrieNode root;

    public Trie() {
      this.root = new TrieNode();
    }

    public void insert(String word) {
      TrieNode cur = root;
      for (char c : word.toCharArray()) {
        int charCode = c - 'a';
        if (cur.children[charCode] == null) {
          cur.children[charCode] = new TrieNode();
        }
        cur = cur.children[charCode];
      }
      cur.word = true;
    }

    public boolean search(String word) {
      TrieNode cur = root;
      for (char c : word.toCharArray()) {
        int charCode = c - 'a';
        if (cur.children[charCode] == null) {
          return false;
        }
        cur = cur.children[charCode];
      }
      return cur.word;
    }

    public boolean startsWith(String prefix) {
      TrieNode cur = root;
      for (char c : prefix.toCharArray()) {
        int charCode = c - 'a';
        if (cur.children[charCode] == null) {
          return false;
        }
        cur = cur.children[charCode];
      }
      return true;
    }
  }

  public static class TrieNode {

    boolean word;
    TrieNode[] children;

    public TrieNode() {
      this.children = new TrieNode[26];
      this.word = false;
    }
  }
}
