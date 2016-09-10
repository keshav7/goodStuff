package goodProblems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 06/04/16.
 *
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

 * Note: The input string may contain letters other than the parentheses ( and ).

 * Examples:

 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 *
 *
 */
public class RemoveInvalidParenthesis {

    public static class LengthComparator implements Comparator<String> {
        public int compare(String list1, String list2) {
            return list2.length() - list1.length(); // sort descending in length
        }
    }


    public ArrayList<String> hash=new ArrayList<>();
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        RemoveInvalidParenthesis removeInvalidParenthesis=new RemoveInvalidParenthesis();
        String inputStr=sc.nextLine();
        ArrayList<String> inputColl=new ArrayList<>();
        char[] chh=inputStr.toCharArray();
        for(char c:chh) {
            inputColl.add(String.valueOf(c));
        }

        removeInvalidParenthesis.populateValidParenthesis(inputColl, "", 0, 0, 0);


        System.out.println(removeInvalidParenthesis.hash);

        //Collections.sort(removeInvalidParenthesis.hash, new LengthComparator());
        System.out.println(removeInvalidParenthesis.hash);


    }


    public void populateValidParenthesis(ArrayList<String> input,String prev,int l,int r,int index) {

        if(index==input.size()) {
            if(l==r&& !hash.contains(prev)) {
                hash.add(prev);
            }
            return;
        }

        if(l<r) {
            return;
        }

        if(!input.get(index).equals("(")
                &&!input.get(index).equals(")")) {
            if(index==0||input.get(index-1).equals(")")) {
                return;
            }
            populateValidParenthesis(input,prev+input.get(index),l,r,index+1);
            return;
        }

        int currL=l;
        int currR=r;

        if(input.get(index).equals(")")) {
            currR++;
        }
        if(input.get(index).equals("(")) {
            currL++;
        }
        populateValidParenthesis(input,prev+input.get(index),currL,currR,index+1);
        populateValidParenthesis(input,prev,l,r,index+1);
    }

}
