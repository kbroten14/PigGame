public class SimpleHoldPlayer extends PigPlayer{
  private int hold;
  
  public SimpleHoldPlayer(){
    super("Simple Hold Player");
    hold = 20;
  }
  
  public SimpleHoldPlayer(String name){
    super(name);
    hold = 20;
  }
  
  public SimpleHoldPlayer(String name, int value){
    super(name);
    hold = value;
  }
  
  /**
   * isRolling for SimpleHoldPlayer. Holds if the player's turnTotal is less than the 
   * SimpleHoldPlayer's set hold value (which is set in the constructors).
   */
  public boolean isRolling(int turnTotal, int opponentScore){
    if(opponentScore<PigGame.GOAL && turnTotal + this.getScore()<PigGame.GOAL){
      if(turnTotal < hold && !super.won())
        return true;
      else
        return false;
    }
    return false;
  }
  
  
}