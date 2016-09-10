package goodProblems;

//@Data
public class Node {
    public int num;
    public Node next;
    public Node random;

    public Node(int num) {
        this.setNum(num);
    }

    public Node() {}

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getRandom() {
        return random;
    }

    public void setRandom(Node random) {
        this.random = random;
    }
}
