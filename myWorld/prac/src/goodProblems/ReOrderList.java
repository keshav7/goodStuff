package goodProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 06/04/16.
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 *You may not alter the values in the nodes, only nodes itself may be changed.
 *Only constant memory is allowed.
 *
 *For example,
 *Given this linked list: 1->2->3->4->5
 *For k = 2, you should return: 2->1->4->3->5
 *For k = 3, you should return: 3->2->1->4->5
 *
 *
 */
public class ReOrderList {

    public class LinkList {
        int num;
        LinkList next;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        ReOrderList reOrderList=new ReOrderList();
        String inputString=sc.nextLine();
        ArrayList<String> inputStringColl=new ArrayList<>(Arrays.asList(inputString.split(" ")));
        ArrayList inputIntegerColl=new ArrayList();
        inputStringColl.forEach(p -> inputIntegerColl.add(Integer.parseInt(p)));
        LinkList ptr=reOrderList.createList(inputIntegerColl);
        reOrderList.printList(ptr);

        LinkList prev,newStart = null;
        LinkList rover=ptr;
        prev=null;

        int count,k;
        count=0;
        k=3;
        while(rover!=null) {
            if(count%k==0) {
                if(prev==null) {
                    prev=reOrderList.reverse(rover,k);
                    rover=newStart=prev;
                }
                else {
                    prev.next=reOrderList.reverse(rover,k);
                    rover=prev.next;
                }

            }
            prev=rover;
            count++;
            rover=rover.next;
        }


        //ptr=reOrderList.reverse(ptr,8);
        reOrderList.printList(newStart);
    }

    public LinkList createList(ArrayList<Integer> input) {
        LinkList start=null;
        LinkList prev=null;
        for(Integer p:input) {
            LinkList node=new LinkList();
            node.num=p;
            node.next=null;
            if(start==null) {
                start=node;
            }
            else {
                prev.next=node;
            }
            prev=node;
        }
        return start;
    }

    public void printList(LinkList list) {
        LinkList start=list;
        System.out.println("\n");
        while(start!=null) {
            System.out.print(start.num + "->");
            start=start.next;
        }
    }

    public LinkList reverse(LinkList startPoint,int k) {
        LinkList p,q,temp;
        LinkList endPoint;
        LinkList start;
        start=startPoint;
        temp=startPoint;
        for(int i=0;i<k;i++) {
            if(temp==null) {
                return null;
            }
            temp=temp.next;
        }
        endPoint=temp;
        p=start;
        q=start.next;
        while(q!=endPoint) {
            temp=q.next;
            q.next=p;
            if(p==start) {
                p.next=endPoint;
            }
            p=q;
            q=temp;
        }
        start=p;
        return start;


    }
}
