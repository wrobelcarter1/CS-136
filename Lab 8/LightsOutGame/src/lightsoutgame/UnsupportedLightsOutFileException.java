package lightsoutgame;

/**
* The UnsupportedLightsOutFileException checks the file to be 
* run with an exception.
*
* @author Carter Wrobel (cjw446) and Bryce Croft(bwc45)
* @version 1.0
* @since 04-13-2018
*/
public class UnsupportedLightsOutFileException extends Exception
{
/**
* Checks the exception for a bad file.
* @param message This is the message displayed to the user.
*/
 public UnsupportedLightsOutFileException(String message)
 {
     super(message);
 }
}
