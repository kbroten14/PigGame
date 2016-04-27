
public class Die {
  private double side;
  
  //methods
  /**
   * roll() rolls a 6 sided die every time.
   */
  public static int roll() {
    double side = Math.random()*6+1;
    return (int)side;
  }
  
  /**
   * Sets the amount of sides you want your die to have.
   */
  public void setSides(double s) {
    side = s;
  }
  
  /**
   * Returns the number of sides.
   */
  public int getSides() {
    return (int)side;
  }
  
  /**
   * Rolls the die with however many sides you assigned it with setSides().
   */
  public int rollDie() {
    side = Math.random()*side+1;
    return (int)side;
  }
  
}