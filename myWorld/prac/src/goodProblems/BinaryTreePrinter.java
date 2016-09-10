package goodProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreePrinter {

    private static Node1<Integer> test1() {
        Node1<Integer> root = new Node1<Integer>(2);
        Node1<Integer> n11 = new Node1<Integer>(7);
        Node1<Integer> n12 = new Node1<Integer>(5);
        Node1<Integer> n21 = new Node1<Integer>(2);
        Node1<Integer> n22 = new Node1<Integer>(6);
        Node1<Integer> n23 = new Node1<Integer>(3);
        Node1<Integer> n24 = new Node1<Integer>(6);
        Node1<Integer> n31 = new Node1<Integer>(5);
        Node1<Integer> n32 = new Node1<Integer>(8);
        Node1<Integer> n33 = new Node1<Integer>(4);
        Node1<Integer> n34 = new Node1<Integer>(5);
        Node1<Integer> n35 = new Node1<Integer>(8);
        Node1<Integer> n36 = new Node1<Integer>(4);
        Node1<Integer> n37 = new Node1<Integer>(5);
        Node1<Integer> n38 = new Node1<Integer>(8);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;

        n21.left = n31;
        n21.right = n32;
        n22.left = n33;
        n22.right = n34;
        n23.left = n35;
        n23.right = n36;
        n24.left = n37;
        n24.right = n38;

        return root;
    }

    private static Node1<Integer> test2() {
        Node1<Integer> root = new Node1<Integer>(2);
        Node1<Integer> n11 = new Node1<Integer>(7);
        Node1<Integer> n12 = new Node1<Integer>(5);
        Node1<Integer> n21 = new Node1<Integer>(2);
        Node1<Integer> n22 = new Node1<Integer>(6);
        Node1<Integer> n23 = new Node1<Integer>(9);
        Node1<Integer> n31 = new Node1<Integer>(5);
        Node1<Integer> n32 = new Node1<Integer>(8);
        Node1<Integer> n33 = new Node1<Integer>(4);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.right = n23;
        n22.left = n31;
        n22.right = n32;

        n23.left = n33;

        return root;
    }

    public static void main(String[] args) {

        BTreePrinter.printNode(test1());
        BTreePrinter.printNode(test2());

    }
}

class Node1<T extends Comparable<?>> {
    Node1<T> left, right;
    T data;

    public Node1(T data) {
        this.data = data;
    }
}

class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(Node1<T> root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node1<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Node1<T>> newNodes = new ArrayList<Node1<T>>();
        for (Node1<T> node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node1<T> node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
