package com.bartek;

import java.util.Arrays;

/**
 * Created by bartek on 12/12/16.
 */
public class LargestDifference {
    public static int largestDifference(int[] data) {


        int[] distances = new int[data.length];

        for(int a=0; a<data.length; a++){

            int maxDistance = 0;
            for(int b = a+1; b< data.length; b++){

                if(data[a] <= data[b]){

                    int newDistance = b - a;

                    if(newDistance > maxDistance){
                        maxDistance = newDistance;
                    }
                }
            }

            distances[a] = maxDistance;
        }

        return Arrays.stream(distances).max().getAsInt();

    }
}
