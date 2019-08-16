package com.cjs.leetcode.add_two_number;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode firstPrevNode = node;
        // 进位值
        int inc = 0;
        while (l1 != null || l2 != null) {
            int positionSum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + inc;
            int positionNum = positionSum % 10;
            inc = positionSum / 10;
            node = (node.next = new ListNode(positionNum));
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (inc > 0) {
            node.next = new ListNode(inc);
        }

        return firstPrevNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);

        ListNode returnNode = new AddTwoNumber().addTwoNumbers(node1, node2);
        while (returnNode != null) {
            System.out.println(returnNode.val);
            returnNode = returnNode.next;
        }
    }
}
