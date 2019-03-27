/**
* The Amplifier class defines the varibles to be used in its subclasses
* and also defines generic methods as well.
*
* @author Carter Wrobel and Anjun Zhang
* @version 1.0
* @since 05-04-2018
*/
public class Amplifier {
  public double g = 0;
  public double R2;
  public double R1;
  /**
     Sets the varibles used as they are passed in
     @param r1 resistor 1
     @param r2 resistor 2
  */
  public Amplifier(double r1, double r2) {
    R1 = r1;
    R2 = r2;
  }
  /**
     Returns the gain of the amplifier.
     @return g the gain as a double value
  */
  public double getGain(){
    return g;
  }
  /**
     Returns the description of the amplifier
     @return  The description as a string.
  */
  public String getDescription(){
    return " ";
  }

}
