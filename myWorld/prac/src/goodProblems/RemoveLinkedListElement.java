package goodProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 06/04/16.
 *
 * Remove all elements from a linked list of integers that have value val.

 *Example Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6 Return: 1 --> 2 --> 3 --> 4 --> 5
 *
 */
public class RemoveLinkedListElement {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String inputStr=sc.nextLine();
        ArrayList<String> inputStringColl=new ArrayList<>(Arrays.asList(inputStr.split(" ")));
        ArrayList<Integer> inputIntegerColl=new ArrayList<>();

        inputStringColl.forEach(p->inputIntegerColl.add(Integer.parseInt(p)));

        LinkedList<Integer> linkedList=new LinkedList<>(inputIntegerColl);
        int val=5;
        while (linkedList.indexOf(val)>=0) {
            linkedList.remove(linkedList.indexOf(val));
        }

        for(Integer e:linkedList) {
            System.out.print(e+"->");
        }


    }


}
