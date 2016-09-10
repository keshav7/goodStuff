package goodProblems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by keshav.gupta on 06/04/16.
 *
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 */
public class SearchRange {

    public static void main(String[] args) {


        ArrayList<Integer> aa= new ArrayList<>(Arrays.asList(1,2,3,4,5,8,8,8,9,10,11,11,12,18));
        SearchRange searchRange=new SearchRange();
        int k=8;
        int l=searchRange.func(aa,0,aa.size()-1,k,true,false);
        int r=searchRange.func(aa,0,aa.size()-1,k,false,true);
        System.out.println(l+","+r);

    }

    int func(ArrayList<Integer> input,int m,int n,int num,Boolean left,Boolean right) {
        if(m>n||(m==n&&input.get(m)!=num)) {
            return -1;
        }

        int mid=m+(n-m)/2;
        if(input.get(mid)==num) {
            if(left) {
                if(mid==0||input.get(mid-1)!=num) {
                    return mid;
                }
                else {
                    return func(input,m,mid,num,left,right);
                }
            }
            if(right) {
                if(mid==input.size()-1 ||input.get(mid+1)!=num) {
                    return mid;
                }
                else {
                    return func(input,mid+1,n,num,left,right);
                }
            }
        }
        else {
            if(num>input.get(mid)) {
                return func(input,mid+1,n,num,left,right);
            }
            return func(input,m,mid,num,left,right);
        }
        return -1;

    }

}
