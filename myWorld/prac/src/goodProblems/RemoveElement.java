package goodProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 05/04/16.
 *
 *
 * Given an array and a value, remove all instances of that value in place and return the new length.
 *The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Use iterator or use quick sort step for c-style
 */
public class RemoveElement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int num=sc.nextInt();
        ArrayList<String> stringInput=new ArrayList<>(Arrays.asList(str.split(" ")));
        ArrayList<Integer> integerInput=new ArrayList();
        stringInput.forEach(p->integerInput.add(Integer.parseInt(p)));

        for(Iterator<Integer> iterator=integerInput.iterator();iterator.hasNext();) {
            int val=iterator.next();
            if(val==num) {
                iterator.remove();
            }
        }
        System.out.println(integerInput);

    }
}
