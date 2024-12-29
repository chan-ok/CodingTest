package study.codingtest.leetcode;

public class LC_148 {

  public static void main(String[] args) throws Exception {
    ListNode head = new ListNode(-1);
    head.next = new ListNode(5);
    head.next.next = new ListNode(0);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(4);

    ListNode print = sortList(head);
    while (print != null) {
      System.out.print(print.val + " ");
      print = print.next;
    }
  }

  public static ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode half = null, slow = head, fast = head;
    while (fast != null && fast.next != null) {
      half = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    half.next = null;

    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);

    return mergeTwoLists(l1, l2);
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }

    if (l1.val > l2.val) {
      ListNode temp = l1;
      l1 = l2;
      l2 = temp;
    }

    l1.next = mergeTwoLists(l1.next, l2);
    return l1;
  }

  public static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
