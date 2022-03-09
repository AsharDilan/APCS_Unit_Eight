import java.util.*;
import java.io.*;
import java.awt.*;

public class MapDataDrawer {

    private int[][] grid;

    public MapDataDrawer(String filename, int rows, int columns) throws FileNotFoundException {
        grid = new int[rows][columns];
        Scanner scan = new Scanner("files/Colorado_844x480.dat");
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
    public int findMinValue(int[] grid) {
        int minValue = grid[0];
        for (int min = 1; min < grid.length; min++) {
            if (grid[min] < minValue) {
                minValue = grid[min];

            }

        }
        return minValue;
    }

    /**
     * @return the max value in the entire grid
     */
    public int findMaxValue(int[] grid) {
        int maxValue = grid[0];
        for (int max = 1; max < grid.length; max++) {
            if (grid[max] > maxValue) {
                maxValue = grid[max];
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
    public void drawMap(Graphics g){
        int num = grid[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                int c =
        g.setColor(new Color(c, c, c));
        g.fillRect(x,y,1,1);


                }

    /**
     * Find a path from West-to-East starting at given row.
     * Choose a foward step out of 3 possible forward locations, using greedy method described in assignment.
     * @return the total change in elevation traveled from West-to-East
     */
    public int drawLowestElevPath(Graphics g, int row){
        for
        return -1;
    }

    /**
     * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
     */
    public int indexOfLowestElevPath(Graphics g){
        return -1;

    }


}