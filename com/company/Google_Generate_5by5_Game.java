package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Google_Generate_5by5_Game {
    public void generateGame(){
        int[][] game = new int[5][5];
        int start = 1, end = 15;
        for(int i=0;i<5;i++){
            game[i] = generateRow(start, end);
            start += 15;
            end += 15;
        }
        for(int i =0;i<5;i++){
            System.out.println(Arrays.toString(game[i]));
        }
    }

    int[] generateRow(int start, int end){
        ArrayList<Integer> currRow = new ArrayList<>(15);
        for(int i=start; i<=end; i++) currRow.add(i);
        ArrayList<Integer> items = new ArrayList<>();

        while(items.size() != 5){
            int index = (int) (Math.floor(Math.random()*(15-items.size())));
            items.add(currRow.get(index));
            // swap el at `index` with last
            int t = currRow.get(index);
            currRow.add(index, currRow.get(currRow.size()-1));
            // remove last element
            currRow.remove(currRow.size()-1);
        }
        int[] row = new int[5];
        for(int i=0;i<5;i++) row[i] = items.get(i);
        return row;
    }
}
