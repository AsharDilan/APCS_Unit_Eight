import java.util.*;
import java.io.*;
import java.awt.*;

public class MapDataDrawer
{

    private int grid;

    public File MapDataDrawer(String filename, int rows, int columns) throws FileNotFoundException {
        int[][] grid = new int [rows][columns];
        Scanner scan = new Scanner("files/Colorado_844x480.dat");
        for (int i = 0; i < rows.length; i++){
            for (int j = 0; j < columns.length; j++){
                grid[i][j] =
            }
        }
    }    // initialize grid
        //read the data from the file into the grid


        private static void readfile () throws FileNotFoundException {
            int[][] grid = [ROWS][COLUMNS];
            Scanner scan = new Scanner(choseTextFile());
            while (scan.hasNextLine()) {
                for (int i = 0; i < grid.length; i++) {
                    String[] line = scan.nextLine().trim().split("," + " ");
                    for (int j = 0; j < line.length; j++) {
                        grid[i][j] = Integer.parseInt(line[j]);
                    }
                }
            }
            System.out.println(Arrays.deepToString(grid));
        }
        private static File choseTextFile () {
            FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
            dialog.setMode(FileDialog.LOAD);
            dialog.setVisible(true);
            File[] file = dialog.getFiles();
            return file[0];
        }

    /**
     * @return the min value in the entire grid
     */
    public int findMinValue(){
        return -1;
    }
    /**
     * @return the max value in the entire grid
     */
    public int findMaxValue(){
        return -1;
    }

    /**
     * @param col the column of the grid to check
     * @return the index of the row with the lowest value in the given col for the grid
     */
    public  int indexOfMinInCol(int col){

        return -1;
    }

    /**
     * Draws the grid using the given Graphics object.
     * Colors should be grayscale values 0-255, scaled based on min/max values in grid
     */
    public void drawMap(Graphics g){




    }

    /**
     * Find a path from West-to-East starting at given row.
     * Choose a foward step out of 3 possible forward locations, using greedy method described in assignment.
     * @return the total change in elevation traveled from West-to-East
     */
    public int drawLowestElevPath(Graphics g, int row){
        return -1;
    }

    /**
     * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
     */
    public int indexOfLowestElevPath(Graphics g){
        return -1;

    }


}