package goodProblems;

import java.util.Scanner;

/**
 * Created by keshav.gupta on 07/04/16.
 *
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 *
 *For example:
 *Given "aacecaaa", return "aaacecaaa".
 *Given "abcd", return "dcbabcd".
 *
 */
public class ShortestPalindrome {

    static String result="aaaaajfrjfirjirjfirjifrjifjrifjrifjirffirjirjirfirjirifrifjrifrijfirjfirjirjirjfirjirjifri";

    public static Boolean isPalindrome(String str) {

        int p=0;
        int q=str.length()-1;
        while(p<q) {
            if(str.charAt(p)!=str.charAt(q)) {
                break;
            }
            p++;
            q--;
        }
        if(p==q) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        shortestPalindrome(input,input,0);
        System.out.println(result);
    }


    public static void shortestPalindrome(String input,String prev,int index) {

        if(isPalindrome(prev)&&prev.length()<result.length()) {
            result=prev;
        }
        if(index>=input.length()) {
            return;
        }
        shortestPalindrome(input,input.charAt(index)+prev,index+1);
        shortestPalindrome(input,prev,index+1);


    }

}


