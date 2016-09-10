package goodProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 19/01/16.
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 *For example, If n = 4 and k = 2, a solution is:
*      [
*      [2,4],
*      [3,4],
*      [2,3],
*      [1,2],
*      [1,3],
*      [1,4],
*      ]
*/
public class Kcombos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter list");
        String input=sc.nextLine();
        ArrayList<String> arr= new ArrayList(Arrays.asList(input.split(" ")));
        ArrayList<Integer> inputInts=convertStringToIntArr(arr);
        Integer k;
        System.out.println("Enter k");
        k=sc.nextInt();
        System.out.println(k);
        if(k>inputInts.size()) {
            System.out.println("Subset size should be <= input size");
            return;
        }
        printSubSets(inputInts,0,0,k,inputInts.size(),new ArrayList<Integer>(3));
        return;

    }

    public static ArrayList<Integer> convertStringToIntArr(ArrayList<String> stringArr) {
        ArrayList<Integer> integerArr=new ArrayList<Integer>();
        for(String str:stringArr) {
            integerArr.add(Integer.parseInt(str));
        }
        return integerArr;
    }

    public static void printSubSets(ArrayList<Integer> input,int index,int rover,int k,int n,ArrayList<Integer> buff) {
        /**
         * For the last loop
         */
        if (rover == k-1) {
            for (int i = index; i < n; i++) {
                buff.add(input.get(i));
                System.out.println(buff);
                buff.remove(buff.size() - 1);
            }
            return;
        }
        /**
         * For all but last loop
         */
        for(int i=index;i<n-k+rover;i++) {
            buff.add(input.get(i));
            printSubSets(input,i+1,rover+1,k,n,buff);
            buff.remove(buff.size()-1);
        }
    }
}