package goodProblems;

import java.util.*;

/**
 * Created by keshav.gupta on 25/01/16.
 *
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 * The same repeated number may be chosen from C unlimited number of times.

 * Note: All numbers (including target) will be positive integers.

 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).

 The solution set must not contain duplicate combinations.

 For example, given candidate set 2,3,6,7 and target 7,
 A solution set is:

 [7]
 [2, 2, 3]
 *
 *
 */
public class CombinationSum {

    public void solve(List<Integer> list,int index,int prevSum,
                       int requiredSum,Stack<Integer> stack,ArrayList<ArrayList<Integer>> result) {

        int num = list.size();
        //if ((index >= num) || prevSum > requiredSum) {
        if (index >= num) {
            return;
        }

        if (prevSum == requiredSum) {
            result.add(new ArrayList<Integer>(stack));
            //return;
        }

        for (int i = index; i < num; i++) {
            stack.push(list.get(i));
            solve(list, index + 1, prevSum + list.get(i), requiredSum, stack, result);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        CombinationSum combiSum=new CombinationSum();
        ArrayList<Integer> inputList;
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        Stack<Integer> stack;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter list");
        String list=sc.nextLine();
        ArrayList<String> arr= new ArrayList(Arrays.asList(list.split(" ")));
        inputList=convertStringToIntArr(arr);
        stack=new Stack<Integer>();
        System.out.println("Enter required sum");
        int reqSum=sc.nextInt();
        combiSum.solve(inputList, 0, 0, reqSum, stack, result);
        System.out.println(result);
    }

    public static ArrayList<Integer> convertStringToIntArr(ArrayList<String> stringArr) {
        ArrayList<Integer> integerArr=new ArrayList<Integer>();
        for(String str:stringArr) {
            integerArr.add(Integer.parseInt(str));
        }
        return integerArr;
    }
}