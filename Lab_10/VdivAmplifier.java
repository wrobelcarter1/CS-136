/**
* The InvertingAmplifier class is a subclass of the Amplifier class.
* It calculates the Voltage Divider and Voltage Follower amplifier output.
*
* @author Carter Wrobel and Anjun Zhang
* @version 1.0
* @since 05-04-2018
*/
public class VdivAmplifier extends Amplifier{
  /**
     The VdivAmplifier constructor does the math for the gain of the amplifier.
     @param r1 resistor 1
     @param r2 resistor 2
  */
  public VdivAmplifier(double r1, double r2){
      super(r1,r2);
      g = r2/(r1+r2);
  }
  /**
     Returns the description of the amplifier
     @return  The description as a string.
  */
  public String getDescription(){
      String s = " Voltage Divider and Voltage Follower: R1 = " + R1 + ", R2 = " + R2;
      return s;
    }


}
