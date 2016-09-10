package goodProblems;

import java.util.ArrayList;

/**
 * Created by keshav.gupta on 16/02/16.
 */
public class Common {

    public static ArrayList<Integer> convertStringToIntegerCollection(ArrayList<String> stringCollection) {

        ArrayList<Integer> integerCollection=new ArrayList<>();
        for(String str:stringCollection) {
            integerCollection.add(Integer.parseInt(str));
        }
        return integerCollection;
    }


}
