public class WatchOpponentPlayer extends PigPlayer{
  
  public WatchOpponentPlayer(){
    super("WatchOpponentPlayer");
  }
  
  public WatchOpponentPlayer(String name){
    super(name);
  }
  
  /**
   * WatchOpponent isRolling method that changes hold value if it is behind the opponent. Increases the hold
   * value if either player is close to the GOAL. Lowers the players hold value if they are ahead of the 
   * opponent.
   */
  public boolean isRolling(int turnTotal, int opponentScore){
    if(this.getScore() >= PigGame.GOAL-20 && this.getScore() < PigGame.GOAL && turnTotal < 20)
      return true;
    else if(opponentScore >= PigGame.GOAL-20 && this.getScore() < PigGame.GOAL && turnTotal < 20)
      return true;
    else if(this.getScore() < opponentScore && turnTotal < 20)
      return true;
    else if(this.getScore() > opponentScore && turnTotal < 10)
      return true;
    else
      return false;
  }
  
  
  
  
}