package de.gebelcl.disentis2;

import android.util.Log;
import android.view.View;

public class ArraySquare {
    public static void changeArraySquare(boolean[][] array, int x, int y) {
        // First Line
         if (y > 0 && x == 0) {
            array[x][y-1] = !array[x][y-1];
            array[x+1][y-1] = !array[x+1][y-1];
        } else if (y > 0 && x == 4) {
             array[x-1][y-1] = !array[x-1][y-1];
             array[x][y-1] = !array[x][y-1];
         } else if (y > 0){
             array[x-1][y-1] = !array[x-1][y-1];
             array[x][y-1] = !array[x][y-1];
             array[x+1][y-1] = !array[x+1][y-1];
         }

        // Second Line
        if (x == 0) {
            array[x+1][y] =  !array[x+1][y];
        } else if (x == 4) {
            array[x-1][y] = !array[x-1][y];
        } else {
            array[x-1][y] = !array[x-1][y];
            array[x+1][y] = !array[x+1][y];
        }

        //Third Line
        if (y < 4 && x == 0) {
            array[x][y+1] = !array[x][y+1];
            array[x+1][y+1] = !array[x+1][y+1];
        } else if (y < 4 && x == 4) {
            array[x-1][y+1] = !array[x-1][y+1];
            array[x][y+1] = !array[x][y+1];
        } else if (y < 4 && x < 4) {
            array[x-1][y+1] = !array[x-1][y+1];
            array[x][y+1] = !array[x][y+1];
            array[x+1][y+1] = !array[x+1][y+1];
        }
    }

    public static int getXTag(View tag) {
        return Integer.parseInt(tag.getTag().toString().substring(0,2));
    }

    public static int getYTag(View tag) {
        return Integer.parseInt(tag.getTag().toString().substring(2,4));
    }
}
