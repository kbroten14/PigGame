public abstract class PigPlayer {
  private String name;
  private int currentScore, gamesWon;
  
  public PigPlayer(String n) {
    name = n;
    currentScore = 0;
    gamesWon = 0;
  }
  
  public void setName(String n) {
    name = n;
  }
  
  public String getName() {
    return name;
  }
  
  public void reset() {
    currentScore = 0;
  }
  
  public void addPoints(int turnTotal) {
    currentScore = turnTotal + currentScore;
    if(currentScore >= PigGame.GOAL)
      gamesWon++;
  }
  
  public boolean won() {
    if(this.getScore() >= PigGame.GOAL)
      return true;
    else
      return false;
  }
  
  public int getScore() {
    return currentScore;
  }
  
  public int getWinRecord() {
    return gamesWon;
  }
  
  public String toString() {
    return "Name: " + name + " Score: " + currentScore;
  }
  
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