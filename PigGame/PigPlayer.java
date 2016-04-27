public abstract class PigPlayer {
  private String name;
  private int currentScore, gamesWon;
  
  public PigPlayer(String n) {
    name = n;
    currentScore = 0;
    gamesWon = 0;
  }
  
  /**
   * Sets the player's name.
   */
  public void setName(String n) {
    name = n;
  }
  
  /**
   * Returns the player's name.
   */
  public String getName() {
    return name;
  }
  
  /**
   * Resets the player's current score.
   */
  public void reset() {
    currentScore = 0;
  }
  
  /**
   * Adds points to the player's current score.
   */
  public void addPoints(int turnTotal) {
    currentScore = turnTotal + currentScore;
    if(currentScore >= PigGame.GOAL)
      gamesWon++;
  }
  
  /**
   * Returns true if the player's score goes over the GOAL.
   */
  public boolean won() {
    if(this.getScore() >= PigGame.GOAL)
      return true;
    else
      return false;
  }
  
  /**
   * Returns the player's current score.
   */
  public int getScore() {
    return currentScore;
  }
  
  /**
   * Returns the amount of games the player has won.
   */
  public int getWinRecord() {
    return gamesWon;
  }
  
  /**
   * Returns a string that prints the player's name and current score.
   */
  public String toString() {
    return "Name: " + name + " Score: " + currentScore;
  }
  
  /**
   * Abstract isRolling method to be changed for each type of PigPlayer.
   */
  public abstract boolean isRolling(int turnTotal, int opponentScore);
  
//  public static void main(String[] args) {
//    PigPlayer kevin = new PigPlayer("Jim");
//    kevin.setName("Kevin");
//    System.out.println(kevin.getName());
//    kevin.addPoints(50);
//    System.out.println(kevin.getScore());
//    System.out.println(kevin);
//    kevin.addPoints(50);
//    System.out.println(kevin.won());
//    System.out.println(kevin.getWinRecord());
//    kevin.reset();
//    System.out.println(kevin);
//  }
  
}