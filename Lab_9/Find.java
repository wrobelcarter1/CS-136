import java.io.*;
import java.util.*;
import java.lang.*;

class Find {
  public static void main(String[] args) throws FileNotFoundException
  {
    // These lines take in the command line args and store them in the correpsonding vars.
    String ring = args[0];
    File report = new File(args[1]);
    File addresses = new File(args[2]);
    File keyring = new File(args[3]);
    // Scanners to read each individual file, named correspondingly.
    Scanner reportReader = new Scanner(report);
    Scanner addressReader = new Scanner(addresses);
    Scanner keyReader = new Scanner(keyring);
    // This loops through each line, tokenizes them, and evals each token to match the ring variable.
    while(reportReader.hasNextLine()){
      String line = reportReader.nextLine();
      StringTokenizer report_string = new StringTokenizer(line);
      while(report_string.hasMoreTokens()){
        if(report_string.nextToken().toString().contains(ring)){
          System.out.println("report.txt: " + line);
          System.out.println(" ");
        }
      }
    }
    // This is the looping code for the address file.
    while(addressReader.hasNextLine()){
      String line = addressReader.nextLine();
      StringTokenizer address_string = new StringTokenizer(line);
      while(address_string.hasMoreTokens()){
        if(address_string.nextToken().toString().contains(ring)){
          System.out.println("addresses.txt: " + line);
          System.out.println(" ");
        }
      }
    }
    // This is the looping code for the keyring file.
    while(keyReader.hasNextLine()){
      String line = keyReader.nextLine();
      StringTokenizer key_string = new StringTokenizer(line);
      while(key_string.hasMoreTokens()){
        if(key_string.nextToken().toString().contains(ring)){
          System.out.println("keyring.txt: " + line);
          System.out.println(" ");
        }
      }
    }
    // Close each scanner.
    reportReader.close();
    addressReader.close();
    keyReader.close();  
}
}
