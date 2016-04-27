public class StrategicPlayer extends PigPlayer{
  
  public StrategicPlayer(){
    super("Kevin Broten's Strategic Player");
  }
  
  public StrategicPlayer(String name){
    super(name);
  }
  
  /**
   * isRolling for my Strategic Player. If the player is ahead in points the hold value is reduced.
   * If opponent is within 10 points behind the player, the player's hold value is increased. Also
   * increases player's hold value if the opponent is ahead of the player.
   */
  public boolean isRolling(int turnTotal, int opponentScore){
    if(opponentScore > this.getScore() && turnTotal < 20)
      return true;
    else if(opponentScore < this.getScore() && opponentScore >= this.getScore() - 10 && turnTotal < 20)
      return true;
    else if(opponentScore<this.getScore()-20 && turnTotal < 10)
      return true;
    else
      return false;
  }
  
  
}