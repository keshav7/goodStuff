package goodProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 15/02/16.
 *
 * You have to paint N boards of length {A0, A1, A2 … AN-1}. There are K painters available
 * and you are also given how much time a painter takes to paint 1 unit of board.
 * You have to get this job done as soon as possible under the constraints that any painter
 * will only paint continuous sections of board, say board {2, 3, 4} or only board {1} or
 * nothing but not board {2, 4, 5}
 */
public class PartitionPainter {

    public static void main(String[] args) {
        PartitionPainter pp=new PartitionPainter();
        Scanner sc=new Scanner(System.in);
        String boards=sc.nextLine();
        String painters=sc.nextLine();
        ArrayList<String> boardsCollStr= new ArrayList(Arrays.asList(boards.split(" ")));
        ArrayList<Integer> boardsColl=pp.convertToIntArray(boardsCollStr);
        ArrayList<String> paintersCollStr= new ArrayList(Arrays.asList(boards.split(" ")));
        ArrayList<Integer> paintersColl=pp.convertToIntArray(paintersCollStr);
        System.out.println(pp.findMinTime(boardsColl, 0, paintersColl,paintersColl.size()));
    }

    int findMinTime(ArrayList<Integer> boards,int index,ArrayList<Integer> painters,int k) {
        if(index>=boards.size()) {
            return 0;
        }
        int min = 0;
        for(int i=0;i<k;i++) {
            int temp=findMinTime(boards,index+1,painters,k)+painters.get(i)*boards.get(index);
            if(i==0) {
                min=temp;
            }
            else {
                min=(temp<min)?temp:min;
            }
        }
        System.out.println(min+"\n");
        return min;
    }


    ArrayList<Integer> convertToIntArray(ArrayList<String> strArr) {
        ArrayList<Integer> intArr=new ArrayList<>();
        for(String str:strArr) {
            intArr.add(Integer.parseInt(str));
        }
        return intArr;
    }


}
