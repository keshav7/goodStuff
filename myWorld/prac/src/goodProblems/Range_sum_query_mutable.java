package goodProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 05/04/16.
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *The update(i, val) function modifies nums by updating the element at index i to val. Example: Given nums = [1, 3, 5]
 *sumRange(0, 2) -> 9 update(1, 2) sumRange(0, 2) -> 8 Note: The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 *
 * Very tricky question mostly will solve thru O(n) and O(1) but curious can
 * do in O(logn) and O(logn) using segment tree. Each element is a leaf node in the segment tree.
 *
 */
public class Range_sum_query_mutable {

    public static class SegmentTree {
        int start,end,sum;
        SegmentTree left,right,root;
        public SegmentTree(int start,int end,int sum) {
            this.start=start;
            this.end=end;
            this.sum=sum;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> stringInput;
        ArrayList<Integer> integerInput=new ArrayList<>();
        Range_sum_query_mutable range_sum_query_mutable=new Range_sum_query_mutable();
        String str=sc.nextLine();
        stringInput=new ArrayList<>(Arrays.asList(str.split(" ")));
        stringInput.forEach(p-> integerInput.add(Integer.parseInt(p)));
        SegmentTree root=Range_sum_query_mutable.createSegmentTree(integerInput, 0, integerInput.size() - 1);
        System.out.printf(String.valueOf(range_sum_query_mutable.getSum(root,1,3)));
        System.out.println();
    }

    public static SegmentTree createSegmentTree(ArrayList<Integer> nums,int start,int end) {
        if(start>end) {
            return null;
        }
        SegmentTree node;

        if(start==end) {
            node=new SegmentTree(start,end,nums.get(start));
            return node;
        }

        int mid=start+(end-start)/2;
        node=new SegmentTree(start,end,0);
        node.left=createSegmentTree(nums,start,mid);
        node.right=createSegmentTree(nums,mid+1,end);
        node.sum=node.left.sum + node.right.sum;
        return node;
    }

    public int getSum(SegmentTree root, int start, int end) {

        if (root == null || end < root.start || start > root.end ||
                start > end) {
            return 0;
        }

        if (start <= root.start && end >= root.end) {
            return root.sum;
        }

        int mid = root.start + (root.end - root.start) / 2;

        return getSum(root.left, start, Math.min(end, mid)) +
                getSum(root.right, Math.max(mid + 1, start), end);

    }

    public void update(SegmentTree root,int index,int num) {
        if(root.start==root.end && root.start==index) {
            root.sum=num;
            return;
        }
        int mid=root.start+(root.end-root.start)/2;
        if(index<=mid) {
            update(root.left,index,num);
        }
        else {
            update(root.right,index,num);
        }
        root.sum=root.left.sum+root.right.sum;
    }

}
