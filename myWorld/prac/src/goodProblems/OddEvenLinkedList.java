package goodProblems;

import java.util.Scanner;

/**
 * Created by keshav.gupta on 30/03/16.
 *
 * Bring all the odd nodes in front and even nodes
 * at last in the linked list in place
 */
public class OddEvenLinkedList {

    public static class Node {
        public int num;
        public Node next;
    }



    public static void main(String[] args) {
        Node start,old;
        Scanner sc=new Scanner(System.in);
        OddEvenLinkedList oddEvenLinkedList=new OddEvenLinkedList();
        String input;
        int inputInt;
        start=old=null;
        while(sc.hasNextLine()) {
            input= sc.nextLine();
            if(input.isEmpty()) {
                break;
            }
            inputInt=Integer.valueOf(input);
            Node node=new Node();
            node.num=inputInt;
            node.next=null;
            if(start==null) {
                start=node;
                old=start;
            }
            else {
                old.next=node;
                old=old.next;
            }
        }
        oddEvenLinkedList.printLinkedList(start);
        if(start==null||start.next==null) {
            return;
        }
        Node p,prev,temp,temp1;
        prev=start;
        p=start.next;

        /*
         * This is the main logic
         */
        while(p!=null && p.next!=null) {
            temp=prev.next;
            prev.next=p.next;
            temp1=p.next.next;
            prev=prev.next;
            prev.next=temp;
            p.next=temp1;
            p=p.next;
        }

        System.out.println("\n");
        oddEvenLinkedList.printLinkedList(start);


    }


    public void printLinkedList(Node start) {

        Node ptr;
        ptr=start;
        while(ptr!=null) {
            System.out.printf(ptr.num+"->");
            ptr=ptr.next;
        }
    }

}
