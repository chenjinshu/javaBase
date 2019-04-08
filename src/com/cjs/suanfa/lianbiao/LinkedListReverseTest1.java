package com.cjs.suanfa.lianbiao;

/**
 * 单链表逆序(常规方式)
 * @author chen.jinshu (青禾)
 * 2018/12/17
 */
public class LinkedListReverseTest1 {

    public static void main(String[] args) {
        Node head = new Node();
        head.setData("cjs");
        Node node2 = new Node();
        node2.setData("llp");
        Node node3 = new Node();
        node3.setData("hqt");
        Node node4 = new Node();
        node4.setData("sq");
        Node node5 = new Node();
        node5.setData("lq");

        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        Node h = head;
        do {
            System.out.println(h.getData());
        } while ((h = h.getNext()) != null);

        head = reverse(head);
        System.out.println("==================");

        Node m = head;
        do {
            System.out.println(m.getData());
        } while ((m = m.getNext()) != null);
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node next;
        while (head != null) {
            next = head.getNext();
            head.setNext(prev);
            prev = head;
            head = next;
        }
        return prev;
    }

    private static class Node {
        private String data;

        private Node next;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
