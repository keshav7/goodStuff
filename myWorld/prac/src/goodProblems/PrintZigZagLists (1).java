package goodProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 17/02/16.
 */
class RemoveDuplicatesMaxTwo {


    public static void main(String[] args) {
        RemoveDuplicatesMaxTwo removeDuplicatesMaxTwo=new RemoveDuplicatesMaxTwo();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String");
        String input=sc.nextLine();
        ArrayList<Integer> inputNumbersCollection=Common.convertStringToIntegerCollection(
                new ArrayList<String>(Arrays.asList(input.split(" "))));
        Collections.sort(inputNumbersCollection);


    }




}























