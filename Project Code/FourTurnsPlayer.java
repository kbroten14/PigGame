public class FourTurnsPlayer extends PigPlayer{
  private int holdTurns;
  
  public FourTurnsPlayer(){
    super("Four Turns Player");
    holdTurns = 0;
  }
  
  public FourTurnsPlayer(String name){
    super(name);
    holdTurns = 0;
  }
  
  /**
   * Makes it so that the reset also resets the holdTurns variable.
   */
  public void reset(){
    super.reset();
    holdTurns = 0;
  }
  
  /**
   * isRolling for the FourTurnsPlayer PigPlayer class. Changes hold value from PigGame.GOAL/4 - the player's score
   * down to PigGame.Goal - the player's score depending on how many times the player has held.
   */
  public boolean isRolling(int turnTotal, int opponentScore){
    if(opponentScore<PigGame.GOAL && turnTotal < (PigGame.GOAL-this.getScore())/4 && holdTurns == 0){
      return true;
    }
    else if(opponentScore<PigGame.GOAL && turnTotal < (PigGame.GOAL-this.getScore())/3 && holdTurns == 1){
      return true;
    }
    else if(opponentScore<PigGame.GOAL && turnTotal < (PigGame.GOAL-this.getScore())/2 && holdTurns == 2){
      return true;
    }
    else if(opponentScore<PigGame.GOAL && turnTotal < PigGame.GOAL-this.getScore() && holdTurns == 3){
      return true;
    }
    else{
      holdTurns++;
      return false;
    }
  }
  
    
    
    
}

