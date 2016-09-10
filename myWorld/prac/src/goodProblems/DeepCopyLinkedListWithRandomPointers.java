package goodProblems;

import java.util.HashMap;

/**
 * Created by keshav.gupta on 26/01/16.
 */
public class DeepCopyLinkedListWithRandomPointers {




    public static void main(String[] args) {


        DeepCopyLinkedListWithRandomPointers deepCopyLinkedListWithRandomPointers=
                new DeepCopyLinkedListWithRandomPointers();
        Node a,b,c,d,e,f,g,h,i,j,k;
        a=new Node(1);
        b=new Node(2);
        c=new Node(3);
        d=new Node(4);
        e=new Node(5);
        f=new Node(6);
        g=new Node(7);
        h=new Node(8);
        i=new Node(9);
        j=new Node(10);
        k=new Node(11);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);
        f.setNext(g);
        g.setNext(h);
        h.setNext(i);
        i.setNext(j);
        j.setNext(k);

        a.setRandom(k);
        b.setRandom(a);
        c.setRandom(a);
        d.setRandom(f);
        e.setRandom(null);
        f.setRandom(h);
        g.setRandom(k);
        h.setRandom(c);
        i.setRandom(b);
        j.setRandom(e);
        k.setRandom(g);

        Node newList=deepCopyLinkedListWithRandomPointers.performDeepCopy(a);
        deepCopyLinkedListWithRandomPointers.printList(a);
        deepCopyLinkedListWithRandomPointers.printList(newList);


    }

    public Node performDeepCopy(Node start) {
        HashMap<Node,Node> mappingsForRandomNodes=new HashMap<Node,Node>();
        Node rover,copyStart,prev,temp;
        rover=start;
        prev=null;
        copyStart=null;
        while(rover!=null) {
            temp=new Node(rover.getNum());
            mappingsForRandomNodes.put(rover,temp);
            temp.setNext(null);
            temp.setRandom(null);
            if(copyStart==null) {
                copyStart=temp;
            }
            else {
                prev.setNext(temp);
            }
            prev=temp;
            rover=rover.getNext();
        }

        rover=start;
        prev=null;
        temp=copyStart;
        while(rover!=null) {
            temp.setRandom(mappingsForRandomNodes.get(rover.getRandom()));
            temp=temp.getNext();
            rover=rover.getNext();
        }


        return copyStart;
    }

    public void printList(Node start) {
        Node temp, tempNext, tempRandom;
        temp = start;
        while (temp!=null) {
            System.out.println("Num: " + temp.getNum() + " NextNode: " + (temp.getNext() == null ? "null" : temp.getNext().getNum()) + " RandomNum: " +
                (temp.getRandom() == null ? "null" : temp.getRandom().getNum()));
            temp = temp.getNext();

        }
    }

}



