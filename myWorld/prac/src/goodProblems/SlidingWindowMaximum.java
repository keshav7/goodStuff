package goodProblems;

import java.util.*;

/**
 * Created by keshav.gupta on 08/04/16.
 *
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

 * Window position                Max
 ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 *
 * Note: You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 *
 * Follow up: Could you solve it in linear time?
 *
 *
 *My favourite question :)
 *
 */
public class SlidingWindowMaximum {

    static Queue<Integer> que=new LinkedList<>();
    static ArrayList<Integer> integerInput=new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        ArrayList<String> stringInput=new ArrayList<>();
        stringInput=new ArrayList<>(Arrays.asList(input.split(" ")));
        stringInput.forEach(p->integerInput.add(Integer.parseInt(p)));

        int k=3;
        int i;
        for(i=0;i<k;i++) {
            if(!que.isEmpty()&&integerInput.get(que.peek())<integerInput.get(i)) {
                que.remove();
            }
            que.add(i);
        }

        for(;i<integerInput.size();i++) {
            System.out.print(String.valueOf(integerInput.get(que.peek()))+" ");

            while(!que.isEmpty()&&que.peek()<i-k) {
                que.remove();
            }
            while(!que.isEmpty()&&integerInput.get(que.peek())<integerInput.get(i)) {
                que.remove();
            }
            que.add(i);

        }
        while(!que.isEmpty()) {
            System.out.print(String.valueOf(integerInput.get(que.peek()))+" ");
            que.remove();
        }
    }
}
