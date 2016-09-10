package goodProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 16/02/16.
 * Print all edge nodes of a complete binary tree anti-clockwise. That is all
 * the left most nodes starting at root, then the leaves left to right and
 * finally all the rightmost nodes. In other words, print the boundary of the
 * tree.
 */
public class PrintEdgeOfTree {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PrintEdgeOfTree printEdgeOfTree=new PrintEdgeOfTree();
        Random randomGenerator=new Random();
        String str=sc.nextLine();
        ArrayList<String> inputStringColl=new ArrayList<>(Arrays.asList(str.split(" ")));
        ArrayList<Integer> inputIntegerColl=Common.convertStringToIntegerCollection(inputStringColl);
        ArrayList<Node1<Integer>> nodesCollection=new ArrayList<>();
        ArrayList<Node1<Integer>> nodesTreeCollection=new ArrayList<>();
        Node1<Integer> root = null;
        for(Integer temp:inputIntegerColl) {
            Node1<Integer> node=new Node1<>(temp);
            nodesCollection.add(node);
        }
        while(!nodesCollection.isEmpty()) {
            int index=randomGenerator.nextInt(nodesCollection.size());
            Node1 node=nodesCollection.get(index);
            nodesCollection.remove(index);
            Node1 node1;
            if(nodesTreeCollection.size()==0) {
                root=node;
                nodesTreeCollection.add(node);
            }
            else {
                index=randomGenerator.nextInt(nodesTreeCollection.size());
                node1=nodesTreeCollection.get(index);
                nodesTreeCollection.add(node);
                if(node1.left==null) {
                    node1.left=node;
                }
                else {
                    node1.right=node;
                }
                if(node1.left!= null && node1.right!=null) {
                    nodesTreeCollection.remove(index);
                }
            }
        }
        BTreePrinter.printNode(root);
        System.out.println(root.data);
        printEdgeOfTree.printLeftNodes(root.left, true);
        printEdgeOfTree.printRightNodes(root.right,true);
    }

    public void printLeftNodes(Node1<Integer> node,boolean print) {
        if(node==null) {
            return;
        }
        if(print||(node.left==null&&node.right==null)) {
            System.out.println(node.data);
        }
        printLeftNodes(node.left,print);
        printLeftNodes(node.right, false);
    }

    public void printRightNodes(Node1<Integer> node,boolean print) {
        if(node==null) {
            return;
        }
        printRightNodes(node.left,false);
        printRightNodes(node.right,print);
        if(print||(node.left==null&&node.right==null)) {
            System.out.println(node.data);
        }
    }



}





































