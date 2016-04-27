import java.util.Scanner;

public class PigGame {
  public static final int GOAL = 100;
  private PigPlayer player1, player2;
  private static boolean verbose;
  
  public PigGame() {
    player1 = new UserPigPlayer("Player 1");
    player2 = new UserPigPlayer("Player 2");
  }
  
  public PigGame(String p1, String p2) {
    player1 = new UserPigPlayer(p1);
    player2 = new UserPigPlayer(p2);
  }
  
  
  public PigGame(PigPlayer p1, PigPlayer p2) {
    player1 = p1;
    player2 = p2;
  }
  
  /**
   * Resets both players in the PigGame.
   */
  public void reset() {
    player1.reset();
    player2.reset();
  }
  
  /**
   * Makes it so that the System.out.println's in the playTurn and playGame methods
   * in the PigGame.
   */
  public void setVerbose(boolean opinion){
    verbose = opinion;
  }
  
  /**
   * Plays the turn for the current player of the game.
   */
  public static int playTurn(PigPlayer player, PigPlayer opponent) {
    int r, turnTotal;
    boolean answer;
    Die die = new Die();
    r = 0;
    turnTotal = 0;
    if(verbose){
      System.out.println(player.getName() + "'s score: " + player.getScore());
      System.out.println(opponent.getName() + "'s score: " + opponent.getScore());
      System.out.println();
      System.out.println(player.getName() + "'s Turn");
    }
    do{
      System.out.println(answer = player.isRolling(turnTotal,opponent.getScore()));
      if(answer == true){
        r = die.roll();
        if(verbose){
          System.out.println("Roll: " + r);
          System.out.println();
        }
        if(r == 1){
          return turnTotal = 0;
        }
        
        else
          turnTotal = turnTotal + r;
      }
    }
    while(answer == true && r != 1 && !player.won());
    return turnTotal;
  }
  
  /**
   * Plays the game with both players taking turns until one of them scores over the GOAL.
   */
  public void playGame() {
    do{
      player1.addPoints(this.playTurn(player1, player2));
      if(player1.won()){
        break;
      }
      player2.addPoints(this.playTurn(player2, player1));
      if(player2.won()){
        break;
      }
    }
    while(!player1.won() && !player2.won());
    if(player1.won()){
      if(verbose){
        System.out.println(player1.getName() + ": " + player1.getScore());
        System.out.println(player1.getName() + " Wins!");
        System.out.println("Player 1 win record: " + player1.getWinRecord());
      }
    }
    else if(player2.won()){
      if(verbose){
        System.out.println(player2.getName() + ": " + player2.getScore());
        System.out.println(player2.getName() + " Wins!");
        System.out.println("Player 2 win record: " + player2.getWinRecord());
      }
    }
    this.reset();
  }
  
  /**
   * PigGame mode that plays two users against each other.
   */
  public static void userVsUser() {
    Scanner keyboard = new Scanner(System.in);
    String name1, name2;
    System.out.println("Hello! Welcome to the Pig Game!");
    System.out.println();
    System.out.println("Two players race to reach 100 points.");
    System.out.println("Each turn, a player repeatedly rolls a die until either a 1");
    System.out.println("is rolled or the player holds and scores the sum of the rolls.");
    System.out.println();
    System.out.println("When it is your turn, press enter to roll or type anything to hold.");
    System.out.println();
    System.out.println("Good luck to both of you!");
    System.out.println();
    System.out.println("Player 1, please enter your name.");
    name1 = keyboard.nextLine();
    System.out.println("Player 2, please enter your name.");
    name2 = keyboard.nextLine();
    System.out.println("Player 1: " + name1);
    System.out.println("Player 2: " + name2);
    System.out.println();
    if(Math.random() > 0.5){
      PigGame play = new PigGame(name1, name2);
      System.out.println(name1 + " goes first.");
      play.setVerbose(true);
      play.playGame();
    }
    else {
      PigGame play = new PigGame(name2, name1);
      System.out.println(name2 + " goes first.");
      play.setVerbose(true);
      play.playGame();
    }
  }
  
  /**
   * Plays the user against a computer (which is currently a FourTurnsPlayer and has a SimpleHoldPlayer
   * commented out).
   */
  public static void userVsComputer(){
    Scanner keyboard = new Scanner(System.in);
    String name;
    System.out.println("Please enter your name");
    name = keyboard.nextLine();
    PigPlayer player = new UserPigPlayer(name);
//    PigPlayer computer = new SimpleHoldPlayer("Computer", 15);
    PigPlayer computer = new FourTurnsPlayer();
    if(Math.random() > 0.5){
      PigGame play = new PigGame(player, computer);
      play.setVerbose(true);
      System.out.println(name + " goes first.");
      play.playGame();
    }
    else{
      PigGame play = new PigGame(computer, player);
      play.setVerbose(true);
      System.out.println("Computer goes first");
      play.playGame();
    }
  }
  
  /**
   * Plays two SimleHoldPlayer computers against each other.
   */
  public static void computerVsComputer(){
    System.out.println("Computer 1 vs. Computer 2");
    PigPlayer computer1 = new SimpleHoldPlayer("Computer 1", 15);
    PigPlayer computer2 = new SimpleHoldPlayer("Computer 2", 18);
    PigGame comVsCom = new PigGame(computer1, computer2);
    comVsCom.setVerbose(true);
    comVsCom.playGame();
  }
  
  
  /**
   * Main method that currently plays the userVsComputer method (with userVsUser and computerVsComputer commented out.
   */
  public static void main(String[] args) {
//    PigGame.userVsUser();
    PigGame.userVsComputer();
//    PigGame.computerVsComputer();
    
    
    
    
  }
  
}