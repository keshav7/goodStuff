package goodProblems;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 14/02/16.
 * a) find longest palindromic substring
 *
 * b)Given a string s, partition s such that every substring of the partition is a palindrome.
 *   Return the minimum cuts needed for a palindrome partitioning of s.
 *   For example, given s = "aab",
 *   Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 */
public class LongestPalindrome {

    int M=0;
    int N=0;
    int longest=1;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LongestPalindrome lp=new LongestPalindrome();
        System.out.println("Enter string");
        String str=sc.nextLine();
        //lp.longestPalindrome(str,0,str.length()-1,new HashMap<String,Boolean>());
        System.out.println(lp.minimumCuts(str, 0, str.length() - 1, new HashMap<String, Integer>()));
        //System.out.println(str.substring(lp.M,lp.N+1));
    }

    Boolean longestPalindrome(String str,int m,int n,
                              HashMap<String,Boolean> memo) {
        if(m==n) {
            return true;
        }
        if(memo.get(m + "," + n)!=null) {
            return memo.get(m+","+n);
        }
        memo.put(m + "," + n, false);
        if(str.charAt(m)==str.charAt(n)&&
                (((n-m>1)&&longestPalindrome(str,m+1,n-1,memo))||m==n-1)) {
            memo.put(m+","+n,true);
            if(longest<n-m+1) {
                longest=n-m+1;
                M=m;
                N=n;
            }
        }
        else {
            longestPalindrome(str, m + 1, n, memo);
            longestPalindrome(str, m, n - 1, memo);
        }
        return memo.get(m+","+n);
    }


    int minimumCuts(String str,int m,int n,
                    HashMap<String,Integer> memo) {
        if(m==n) {
            return 0;
        }
        if(memo.get(m + "," + n)!=null) {
            return memo.get(m+","+n);
        }

        if(str.charAt(m)==str.charAt(n)&&
                (((n-m>1)&&minimumCuts(str,m+1,n-1,memo)==0)||m==n-1)) {
            memo.put(m+","+n,0);
        }
        else {
            int l = minimumCuts(str, m + 1, n, memo)+1;
            int r = minimumCuts(str, m, n - 1, memo)+1;
            int min=(l < r) ? l : r;
            if(n-m>1) {
                int b = minimumCuts(str, m + 1, n - 1, memo) + 2;
                min=(min < b) ? min : b;
            }
            memo.put(m + "," + n, min);
        }
        return memo.get(m+","+n);
    }
}
