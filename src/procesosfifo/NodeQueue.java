/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesosfifo;

/**
 *
 * @author jgale
 */
public class NodeQueue {

    private Node head;
    private int id;

    public NodeQueue() {
        this.id = 1;
        this.head = null;
    }

    public void add(int timeIn, int raf) {

        Node newNode = new Node(this.id, timeIn, raf);

        if (this.head != null) {
            Node tail = getTail();
            tail.setNext(newNode);
        } else {
            this.head = newNode;
        }

        this.id++;
    }

    public void add(Node newNode) {

        if (this.head != null) {
            Node tail = getTail();
            tail.setNext(newNode);
        } else {
            this.head = newNode;
        }
    }

    public Node remove() {
        Node removed = this.head;

        if (this.head != null) {
            this.head = this.head.getNext();
            removed.setNext(null);
        }
        return removed;
    }

    public Node dequeue() {

        Node removed = this.head;
        Node next = this.head.getNext();

        this.head = next;
        removed.setNext(null);
        return removed;
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        Node tail = this.head;

        if (this.head != null) {
            while (tail.getNext() != null) {
                tail = tail.getNext();
            }
        }

        return tail;
    }

    public Node getPrev(int raf) {
        Node prev = head;

        if (prev != null && prev.getRaf() <= raf) {
            while (prev.getNext() != null && prev.getNext().getRaf() <= raf) {
                prev = prev.getNext();
            }
        }
        return prev;
    }

    public int getLength() {

        Node temp = head;
        int counter = 0;

        while (temp != null) {
            counter++;
            temp = temp.getNext();
        }
        return counter;
    }

    public void print() {
        Node q = this.head;
        while (q != null) {
            System.out.print(q.getRaf() + " -> ");
            q = q.getNext();
        }
        System.out.println();
    }
}
