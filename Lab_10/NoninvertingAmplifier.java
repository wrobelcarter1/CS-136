/**
* The NoninvertingAmplifier class is a subclass of the Amplifier class.
* It calculates the Noninverting amplifier output.
*
* @author Carter Wrobel and Anjun Zhang
* @version 1.0
* @since 05-04-2018
*/
public class NoninvertingAmplifier extends Amplifier {
  /**
     The NoninvertingAmplifier constructor does the math for the gain of the amplifier.
     @param r1 resistor 1
     @param r2 resistor 2
  */
  public NoninvertingAmplifier(double r1, double r2){
      super(r1,r2);
      g = 1 + (r2/r1);
  }
  /**
     Returns the description of the amplifier
     @return  The description as a string.
  */
  public String getDescription(){
      String s = " Noninverting Amplifier: R1 = " + R1 + ", R2 = " + R2;
      return s;
    }


}
