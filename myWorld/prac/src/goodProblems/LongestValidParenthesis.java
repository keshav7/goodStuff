package goodProblems;

import java.util.Scanner;

/**
 * Created by keshav.gupta on 21/03/16.
 *
 *
 *Given a string containing just the characters '(' and ')',
 *find the length of the longest valid (well-formed) parentheses substring.
 *For "(()", the longest valid parentheses substring is "()", which has
 *length = 2.
 *Another example is ")()())", where the longest valid parentheses
 *substring is "()()", which has length = 4.
 */
public class LongestValidParenthesis {


    int pMax,qMax,Max;
    LongestValidParenthesis() {
        pMax= qMax = 0;
        Max = 0;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        LongestValidParenthesis longestValidParenthesis=new LongestValidParenthesis();
        longestValidParenthesis.findLongestParenthesis(str,0,0,0);
        System.out.printf(String.valueOf(longestValidParenthesis.Max + "\n"));
        System.out.println("startIndex: " + longestValidParenthesis.pMax);
        System.out.println("endIndex: " + longestValidParenthesis.qMax + "\n");
        System.out.println(str.substring(longestValidParenthesis.pMax, longestValidParenthesis.qMax + 1));


    }

    public void findLongestParenthesis(String str,int index,int l,int r) {

        if(index>=str.length()) {
            return;
        }
        if(str.charAt(index)==')')
        {
            //right parenthesis
            if(r+1>l) {
                findLongestParenthesis(str,index+1,0,0);
                return;
            }

            if((r+1==l) && (l+r+1>Max)) {
                Max=l+r+1;
                pMax=index-l-r;
                qMax=index;
            }
            findLongestParenthesis(str,index+1,l,r+1);
        }
        else
        {
            //left parenthesis
            findLongestParenthesis(str,index+1,l+1,r);
            findLongestParenthesis(str,index+1,1,0);

        }
    }
}
