package lightsoutgame;
/**
* The UnsupportedLightsOutFileException checks the file to be 
* run with an exception.
*
* @author Carter Wrobel (cjw446) and Bryce Croft(bwc45)
* @version 1.0
* @since 04-13-2018
*/
class LightsOut {

    private int size;
    private boolean[][] grid;
    /**
    * LightsOut sets the game up.
    * @param gridsize This is the size game being loaded.
    */
    public LightsOut(int gridsize) 
    {
        size = gridsize;
        grid = new boolean[size][size];
    }
    /**
    * getSize returns the size of the game.
    */
    public int getSize() 
    {
        return size;
    }
    /**
    * press simulates when a button is pressed and changes
    * the surrounding tiles.
    * @param row This is the row of the tile.
    * @param col This is the col of the tile.
    */
    public void press(int row, int col)
    {
        try
        {
            toggle(row, col);
        }
        catch(ArrayIndexOutOfBoundsException aioob) 
        {}
        try
        {
            toggle(row+1, col);
        }
        catch(ArrayIndexOutOfBoundsException aioob) 
        {}
        try
        {
            toggle(row-1, col);
        }
        catch(ArrayIndexOutOfBoundsException aioob) 
        {}
        try
        {
            toggle(row, col+1);
        }
        catch(ArrayIndexOutOfBoundsException aioob) 
        {}
        try
        {
            toggle(row, col-1);
        }
        catch(ArrayIndexOutOfBoundsException aioob) 
        {}
    }
    /**
    * isLit checks if the tile selected is lit or not.
    * @param row This is the row of the tile.
    * @param col This is the col of the tile.
    */
    public boolean isLit(int row, int col)
    {
        if(grid[row][col])
        {
            return true;
        }
        return false;
    }
    /**
    * forceLit sets the tile selected to lit or not.
    * @param row This is the row of the tile.
    * @param col This is the col of the tile.
    */
    public void forceLit(int row, int col, boolean value) 
    {
        grid[row][col] = value;
    }
    /**
    * toggle sets the tile selected to the opposite.
    * @param row This is the row of the tile.
    * @param col This is the col of the tile.
    */
    private void toggle(int row, int col)
    {
        grid[row][col] = !grid[row][col];
    }
}