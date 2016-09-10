package goodProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 28/01/16.
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *'A' -> 1
 *'B' -> 2
 *...
 *'Z' -> 26
 *Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 *For example,
 *Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *
 *The number of ways decoding "12" is 2.
 */

public class DecodeWays {


    public static void main(String[] args) {
        DecodeWays decodeWays=new DecodeWays();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the input numbers");
        String input=sc.nextLine();
        int ways=decodeWays.findWays((convertStringToIntArr(new ArrayList<>
                (Arrays.asList(input.split(" "))))),0);
        System.out.println(ways);
    }

    public int findWays(ArrayList<Integer> intlist,int index) {

        if(index>=intlist.size()) {
            return 1;
        }
        int ways=0;
        ways+=findWays(intlist,index+1);
        if((index<intlist.size()-1)&&((intlist.get(index)==1)
                ||(intlist.get(index)==2&&intlist.get(index)<=6))) {
            ways+=findWays(intlist,index+2);
        }
        return ways;
    }


    public static ArrayList<Integer> convertStringToIntArr(ArrayList<String> stringArr) {
        ArrayList<Integer> integerArr=new ArrayList<Integer>();
        for(String str:stringArr) {
            integerArr.add(Integer.parseInt(str));
        }
        return integerArr;
    }
}