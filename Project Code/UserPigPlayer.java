import java.util.Scanner;

public class UserPigPlayer extends PigPlayer {
  Scanner keyboard = new Scanner(System.in);
  
  public UserPigPlayer(String n) {
    super(n);
  }
  
  /**
   * UserVsUser isRolling holds depending on input by the user.
   */
  public boolean isRolling(int turnTotal, int opponentScore) {
    if(opponentScore<PigGame.GOAL&& turnTotal+this.getScore()<PigGame.GOAL){
      System.out.print("Turn Total: " + turnTotal);
      System.out.print(" Hold or roll?");
      String answer = keyboard.nextLine();
      if(answer.equals(""))
        return true;
      else
        return false;
    }
    return false;
  }
  
  
//  public static void main(String[] args) {
//    UserPigPlayer kevin = new UserPigPlayer("Kevin");
//    System.out.println(kevin.isRolling(50, 60));
//  }
  
}