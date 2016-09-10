package goodProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 16/03/16.
 *
 * Longest goodProblems.Common Prefix Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        ArrayList<String> arr=new ArrayList<>(Arrays.asList(str.split(" ")));
        LongestCommonPrefix longestCommonPrefix=new LongestCommonPrefix();

        System.out.println(longestCommonPrefix.findLongestCommonPrefix(arr));
    }

    public String findLongestCommonPrefix(ArrayList<String> arr) {
        String temp;
        if(arr.size()<2) {
            return null;
        }
        temp=arr.get(0);
        int p,q;
        for(int i=1;i<arr.size();i++) {
            p=0;
            q=0;
            while(p<temp.length()&&
                    q<arr.get(i).length()&&
                    temp.charAt(p)==arr.get(i).charAt(q)) {
                p++;
                q++;
            }
            if(p==0) {
                return null;
            }
            temp=temp.substring(0,p);
        }
        return temp;
    }

}
