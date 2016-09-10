package goodProblems;

import java.util.*;

/**
 * Created by keshav.gupta on 17/02/16.
 */
public class PrintZigZagLists {


    public static void main(String[] args) {
        PrintZigZagLists removeDuplicatesMaxTwo=new PrintZigZagLists();
        Scanner sc=new Scanner(System.in);
        String line;
        ArrayList<String> lists=new ArrayList<String>();
        //HashMap<ArrayList<String>,Iterator> listCollections=new HashMap<>();
        ArrayList<Iterator> listCollections=new ArrayList<>();

        while(sc.hasNextLine()) {
            line=sc.nextLine();
            if(line.isEmpty()) {
                break;
            }
            lists.add(line);
        }

        for(String str:lists) {
            ArrayList<String> entry=new ArrayList<String>(Arrays.asList(str.split(" ")));
            listCollections.add(entry.iterator());
        }
        int k=listCollections.size();
        while(k>0) {
            for(int i=0;i<listCollections.size();i++) {
                if(listCollections.get(i).hasNext()) {
                    System.out.println(listCollections.get(i).next());
                }
                else {
                    k++;
                }
            }
        }
    }

}




