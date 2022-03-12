import java.util.*;
import java.io.*;
import java.awt.*;

public class MapDataDrawer {

    private int[][] grid;

    public MapDataDrawer(String filename, int rows, int columns) throws FileNotFoundException {
        grid = new int[rows][columns];
        Scanner scan = new Scanner(new File(filename));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = scan.nextInt();
            }
        }
    }    // initialize grid
    //read the data from the file into the grid

    /**
     * @return the min value in the entire grid
     */
    public int findMinValue() {
        int minValue = grid[0][0];
        for (int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++){
                if (grid[row][col] < minValue) {
                    minValue = grid[row][col];
            }

            }

        }
        return minValue;
    }

    /**
     * @return the max value in the entire grid
     */
    public int findMaxValue() {
        int maxValue = grid[0][0];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] > maxValue) {
                    maxValue = grid[row][col];

                }
            }
        }
        return maxValue;
    }

    /**
     * @param col the column of the grid to check
     * @return the index of the row with the lowest value in the given col for the grid
     */
    public int indexOfMinInCol(int column) {
        int min = grid[0][column];
        int lowest = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][column] < min) {
                min = grid[i][column];
                lowest = i;
            }
        }
        return lowest;
    }


    /**
     * Draws the grid using the given Graphics object.
     * Colors should be grayscale values 0-255, scaled based on min/max values in grid
     */
    public void drawMap(Graphics g) {
        int lowest = findMinValue();
        int highest = findMaxValue();
        double value = 0;
        int c = 0;
        for (int row = 1; row < grid.length; row++) {
            for (int col = 1; col < grid[0].length; col++) {
                value = grid[row][col];
                c = (int)(((value - lowest) / (highest - lowest)) * 255);
                g.setColor(new Color(c, c, c));
                g.fillRect(col,row,1,1);
            }


        }

    }

    /**
     * Find a path from West-to-East starting at given row.
     * Choose a foward step out of 3 possible forward locations, using greedy method described in assignment.
     * @return the total change in elevation traveled from West-to-East
     */
    public int drawLowestElevPath(Graphics g, int row){
        int totalElevationChange = 0;
        g.fillRect(0,row,1,1);
        for(int col = 1; col<grid[0].length; col++){
            if (row == 0){
                int current = grid[row][col-1];
                int forward = grid[row][col];
                int down = grid[row+1][col];
                int a = Math.abs(current-forward);
                int b = Math.abs(current-down);
                if (a<b){
                    row++;
                    totalElevationChange += b;
                }
                else{
                    totalElevationChange += a;
                }
            }
            else if (row == grid.length-1){
                int current = grid[row][col-1];
                int forward = grid[row][col];
                int up = grid[row-1][col];
                int a = Math.abs(current-forward);
                int b = Math.abs(current-up);
                if (a<b){
                    row--;
                    totalElevationChange += b;
                }
                else{
                    totalElevationChange += a;
                }
            }
            else{
                int current = grid[row][col-1];
                int forward = grid[row][col];
                int up = grid[row-1][col];
                int down = grid[row+1][col];
                int a = Math.abs(current-forward);
                int b = Math.abs(current-up);
                int c = Math.abs(current-down);
                if (b<c && b<a){
                    row--;
                    totalElevationChange += b;
                }
                else if (c<a && c<b){
                    row++;
                    totalElevationChange += c;
                }
                else if (c == b && c<a){
                    int x = (int)(Math.random()*2) + 1;
                    if (x==1){
                        row--;
                        totalElevationChange += b;
                    }
                    else{
                        row++;
                        totalElevationChange += c;
                    }
                }
                else{
                    totalElevationChange += a;
                }
            }
            g.fillRect(col,row,1,1);
        }
        return totalElevationChange;
    }

    /**
     * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
     */
    public int indexOfLowestElevPath(Graphics g) {
        int lowest = drawLowestElevPath(g, 0);
        int index = 0;

        for (int i = 1; i < grid.length; i++) {
            int change = drawLowestElevPath(g, i);
            if (change < lowest) {
                lowest = change;
                index = i;
            }
        }

        return index;
    }


}