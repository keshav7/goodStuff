package goodProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by keshav.gupta on 07/04/16.
 *
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
 * You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 *
 *Each 0 marks an empty land which you can pass by freely. Each 1 marks a building which you cannot pass through.
 *Each 2 marks an obstacle which you cannot pass through. For example, given three buildings at (0,0), (0,4), (2,2),
 *and an obstacle at (0,2):
 *
 *1 - 0 - 2 - 0 - 1
 *0 - 0 - 0 - 0 - 0
 *0 - 0 - 1 - 0 - 0
 *
 *The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
 *Note: There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 *
 *
 *
 */

public class ShortestDistanceFromAllBuildings {

    public static ArrayList<ArrayList<Integer>> input=new ArrayList<>();

    static ArrayList<String> emptyLandList=new ArrayList<>();
    static ArrayList<String> builtHousesList=new ArrayList<>();
    static ArrayList<ArrayList<Integer>> distances=new ArrayList<>();

    static int minDistance=1000000;
    static String coordinate="-2";


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> stringInput;
        ArrayList<Integer> integerInput=new ArrayList<>();
        while(sc.hasNextLine()) {
            String temp=sc.nextLine();
            if(temp.isEmpty()) {
                break;
            }
            stringInput=new ArrayList<>(Arrays.asList(temp.split(" ")));
            integerInput.clear();
            stringInput.forEach(p -> integerInput.add(Integer.parseInt(p)));
            input.add((ArrayList<Integer>) integerInput.clone());

        }

        populateSlotList(input,0,emptyLandList);
        populateSlotList(input, 1, builtHousesList);

        System.out.println(emptyLandList);
        System.out.println(builtHousesList);

        for(String str:emptyLandList) {
            ArrayList<Integer> emptyList=new ArrayList<>();
            for(int k=0;k<builtHousesList.size();k++) {
                emptyList.add(null);
            }
            distances.add(emptyList);

        }

        for(String houseCoord:builtHousesList) {
            int p=Integer.parseInt(Arrays.asList(houseCoord.split(",")).get(0));
            int q=Integer.parseInt(Arrays.asList(houseCoord.split(",")).get(1));

            findBestSlot(input,input.size(),input.get(0).size(),p,q+1,houseCoord,0);
            findBestSlot(input,input.size(),input.get(0).size(),p,q-1,houseCoord,0);
            findBestSlot(input,input.size(),input.get(0).size(),p+1,q,houseCoord,0);
            findBestSlot(input,input.size(),input.get(0).size(),p-1,q,houseCoord,0);
        }

        for(int i=0;i<emptyLandList.size();i++) {
            int min=0;
            if(coordinate.equals("-1")) {
                break;
            }
            for(int j=0;j<builtHousesList.size();j++) {
                if(distances.get(i).get(j)==null) {
                    coordinate="-1";
                    break;
                }
                min+=distances.get(i).get(j);
            }
            if(min<minDistance) {
                minDistance=min;
                coordinate=emptyLandList.get(i);
            }
        }

        System.out.println(distances);
        System.out.println(coordinate);
    }

    public static void populateSlotList(ArrayList<ArrayList<Integer>> input,int num,ArrayList<String> toPopulate) {

        int numRows,numCols;
        numRows=input.size();
        numCols=input.get(0).size();
        for(int i=0;i<numRows;i++) {
            for(int j=0;j<numCols;j++) {
                if(input.get(i).get(j)==num) {
                    toPopulate.add(i+","+j);
                }
            }
        }
    }


    public static void findBestSlot(ArrayList<ArrayList<Integer>> input,int m,int n,int i,int j,String prev,int prevDistance) {


        if(i<0||i>=m||j<0||j>=n||input.get(i).get(j)==2||
                builtHousesList.indexOf(i+","+j)>=0
                ||distances.get(emptyLandList.indexOf(i+","+j)).get(builtHousesList.indexOf(prev))!=null) {
            return;
        }

        if(distances.get(emptyLandList.indexOf(i+","+j)).get(builtHousesList.indexOf(prev))==null) {
            distances.get(emptyLandList.indexOf(i+","+j)).set(builtHousesList.indexOf(prev), prevDistance + 1);
        }
        else if(distances.get(emptyLandList.indexOf(i+","+j)).get(builtHousesList.indexOf(prev))>prevDistance + 1) {
            distances.get(emptyLandList.indexOf(i+","+j)).set(builtHousesList.indexOf(prev), prevDistance + 1);
        }
        findBestSlot(input,m,n,i,j-1,prev,prevDistance+1);
        findBestSlot(input,m,n,i,j+1,prev,prevDistance+1);
        findBestSlot(input,m,n,i-1,j,prev,prevDistance+1);
        findBestSlot(input,m,n,i+1,j,prev,prevDistance+1);
    }
}
