package lightsoutgame;
// This is where we import the classes being used
import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;
/**
* The UnsupportedLightsOutFileException checks the file to be 
* run with an exception.
*
* @author Carter Wrobel (cjw446) and Bryce Croft(bwc45)
* @version 1.0
* @since 04-13-2018
*/
class LightsOutFileLoader {

    FileNotFoundException ex;
    
    public LightsOutFileLoader() {
    }
    /**
    * Loads the file into the game to be played.
    * @param lightsOut This is game being loaded.
    * @param file This is the file being loaded to the game.
    */
    public void load(LightsOut lightsOut, File file) 
            throws UnsupportedLightsOutFileException,IOException
    {
        Scanner scan = null;
        try
        {
            scan = new Scanner(file);
        }
        catch(FileNotFoundException ex)
        {
            System.err.println(ex);
        }
        int linnum = 0;
        while(scan.hasNextLine())
        {
            String line = scan.nextLine();
            for(int i=0; i<line.length(); i++)
            {
                char cha = line.charAt(i);
                if(cha == '_')
                {
                    lightsOut.forceLit(linnum, i, true);
                }
                else if(cha == 'X')
                {
                    lightsOut.forceLit(linnum, i, false);
                }
                else
                {
                    throw new UnsupportedLightsOutFileException("");
                }  
            }
            linnum++;
        }
        scan.close();
    }
}
