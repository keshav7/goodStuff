package goodProblems;

import java.util.Stack;

/**
 * Created by keshav.gupta on 01/04/16.
 *
 *
 * Print edge of a binary tree
 */
public class BoundaryOfTree {

    public static class Node {
        Character c;
        Node left;
        Node right;
        public Node(Character c) {
            this.c=c;
            this.left=null;
            this.right=null;
        }
    }


    public static void main(String[] args) {
        //Scanner sc=new Scanner(System.in);
        Node1<Character> root= new Node1<>('a');
        Node1 node1=new Node1<>('b');
        Node1 node2=new Node1<>('c');
        Node1 node3=new Node1<>('d');
        Node1 node4=new Node1<>('e');
        Node1 node5=new Node1<>('f');
        Node1 node6=new Node1<>('g');
        Node1 node7=new Node1<>('h');
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        node3.left=node7;
        BTreePrinter bTreePrinter=new BTreePrinter();
        BTreePrinter.printNode(root);
        Stack<Node1> lStack,rStack;
        lStack=new Stack<>();
        rStack=new Stack<>();
        lStack.push(root);
        BoundaryOfTree boundaryOfTree=new BoundaryOfTree();
        boundaryOfTree.trackBoundary(root,true,false,lStack);
        boundaryOfTree.trackBoundary(root,false,true,rStack);
        while(!lStack.isEmpty()) {
            rStack.push(lStack.pop());
        }
        while(!rStack.isEmpty()) {
            System.out.print(rStack.pop().data+" ");
        }



    }


    public void trackBoundary(Node1 node,Boolean leftFlag,Boolean rightFlag,Stack<Node1> stack) {
        if (node == null) {
            return;
        }

        if(node.left==null&&node.right==null) {
            stack.push(node);
            return;
        }

        if(leftFlag) {
            if(node.left!=null && (node.left.left!=null || node.left.right!=null)) {
                stack.push(node.left);
            }
            else{
                if(node.right!=null && (node.right.left!=null ||node.right.right!=null)) {
                    stack.push(node.right);
                }
            }
            trackBoundary(node.left,leftFlag,rightFlag,stack);
            trackBoundary(node.right, false, rightFlag, stack);
        }

        if(rightFlag) {
            if(node.right!=null && (node.right.left!=null || node.right.right!=null)) {
                stack.push(node.right);
            }
            else {
                if(node.left!=null&& (node.left.left!=null || node.left.right!=null)) {
                    stack.push(node.left);
                }
            }
            trackBoundary(node.right,leftFlag,rightFlag,stack);
            trackBoundary(node.left,leftFlag,false,stack);
        }


    }
}
