import java.util.*;
import java.io.*;

public class NameSplitter {
  
  public static void main(String[] args) throws FileNotFoundException{
    // Create two printwriters to create new files to write to.
    PrintWriter boysFile;
    PrintWriter girlsFile;
    boysFile = new PrintWriter("boys.txt");
    girlsFile = new PrintWriter("girls.txt");
    // Defines the file to be read, as well as making the Scanner to read it.
    File file = new File("babynames.txt");
    Scanner fileReader = new Scanner(file);
    // Loop through all the lines in file babynames.txt.
    while(fileReader.hasNextLine()){
      String line = fileReader.nextLine();
      // Tokenizes each line of babynames, and writes the necessary elements to boy and girl file.
      StringTokenizer split_string = new StringTokenizer(line);
      split_string.nextToken();
      boysFile.print(split_string.nextToken());
      boysFile.print(" " + split_string.nextToken());
      boysFile.println(" " + split_string.nextToken());
      girlsFile.print(split_string.nextToken());
      girlsFile.print(" " + split_string.nextToken());
      girlsFile.println(" " + split_string.nextToken());
    }
    // Close both Printwriters.
    boysFile.close();
    girlsFile.close();
    // Close the Scanner
    fileReader.close();
  }
}
