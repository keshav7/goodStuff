package goodProblems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 31/01/16.
 */
public class MedianRunningStreamOfNumbers {

    PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(new Comparator<Integer>()
    {
        @Override
        public int compare(Integer a, Integer b)
        {
            return b-a;
        }
    });
    public void readNumber(int num) {
        int currMedian=findMedian();
        if(num>currMedian) {
            minHeap.add(num);
        }
        else {
            maxHeap.add(num);
        }
        if(minHeap.size()>maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
        else if(maxHeap.size()>minHeap.size()+1) {
            minHeap.add(maxHeap.poll());
        }
    }

    public int findMedian() {
        if(maxHeap.size()==0) {
            return 0;
        }
        if(maxHeap.size()==minHeap.size()) {
            return (maxHeap.peek()+minHeap.peek())/2;
        }
        return maxHeap.peek();
    }




    public static void main(String[] args) {
        MedianRunningStreamOfNumbers medianRunningStreamOfNumbers=new MedianRunningStreamOfNumbers();

        Scanner sc=new Scanner(System.in);
        int number;
        String line;
        System.out.println("Enter the numbers one by one and press enter twice when done");
        while(sc.hasNextLine()) {
            line=sc.nextLine();
            if(line.isEmpty()) {
                break;
            }
            number=Integer.parseInt(line);
            medianRunningStreamOfNumbers.readNumber(number);
        }
        System.out.println(medianRunningStreamOfNumbers.findMedian());

    }
}
