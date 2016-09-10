package goodProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 17/02/16.
 *
 * Trapping Rain Water Given n non-negative integers representing an elevation map
 * where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *For example,
 *Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class HarnessRainWater {

    public static void main(String[] args) {
        HarnessRainWater harnessRainWater=new HarnessRainWater();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter lengths");
        String input=sc.nextLine();
        int max=0;
        int sum=0;
        ArrayList<Integer> inputLengthCollections=Common.convertStringToIntegerCollection(
                new ArrayList<String>(Arrays.asList(input.split(" "))));
        max=0;
        for(int i=1;i<inputLengthCollections.size();i++) {
            if(inputLengthCollections.get(i)>=inputLengthCollections.get(max)) {
                sum+=(inputLengthCollections.get(max))*(i-max);
                max=i;
            }
        }
        System.out.println(sum);
    }
}
