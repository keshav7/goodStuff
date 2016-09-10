package goodProblems;

import java.util.*;

/**
 * Created by keshav.gupta on 24/03/16.
 *
 *
 *
 * Given an array of meeting time intervals consisting of start and end times
 * [s1,e1],[s2,e2],..., determine if a person could attend all meetings.
 *For example,
 *Given [[0, 30],[5, 10],[15, 20]],
 *return false.
 */
public class MeetingRooms {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<ArrayList<Integer>> input=new ArrayList<>();
        String line;
        while(sc.hasNextLine()) {
            line=sc.nextLine();
            if(line.isEmpty()) {
                break;
            }
            ArrayList<String> temp=new ArrayList(Arrays.asList(line.split(",")));
            ArrayList<Integer> intInput=new ArrayList<>(Arrays.asList(Integer.parseInt(temp.get(0)), Integer.parseInt(temp.get(1))));
            input.add(intInput);
        }

        System.out.println(input);

        Collections.sort(input, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (o1.get(0) > o2.get(0)) {
                    return 1;
                } else if (o1.get(0) == o2.get(0)) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        for(int i=1;i<input.size();i++) {
            if(input.get(i).get(0)<input.get(i-1).get(1)) {
                System.out.println("Not possible");
                return;
            }
        }
        System.out.println("possible");

    }

}
