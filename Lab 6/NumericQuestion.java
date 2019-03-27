/**
* The NumericQuestion program is a mathematical question.
*
* @author Sara Huber and Carter Wrobel
* @version 1.0
* @since 03-09-2018
*/
public class NumericQuestion extends Question
{
  // Declaring the vaiable used for the class
  private double answer;

  /**
     Sets the answer for this question.
     @param correctResponse the answer
  */
  public void setAnswer(double correctResponse)
  {
     answer = correctResponse;
  }

  /**
     Checks a given response for correctness.
     @param response the response to check
     @return true if the response was correct, false otherwise
  */
  public boolean checkAnswer(String response)
  {
    double responsedouble = Double.parseDouble(response);
    return (Math.abs(answer - responsedouble) <= 0.01);
  }

}
