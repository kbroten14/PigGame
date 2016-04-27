public class Simulation{
  
  public static void firstAdvantage(long simulations){
    int totalGames;
    double p1Wins, p2Wins;
    totalGames = 0;
    p1Wins = 0;
    p2Wins = 0;
    PigPlayer sim1 = new SimpleHoldPlayer("Sim Player 1");
    PigPlayer sim2 = new SimpleHoldPlayer("Sim Player 2");
    PigGame game = new PigGame(sim1, sim2);
    game.setVerbose(false);
    for(long x=0; x < simulations; x++){
      game.playGame();
      totalGames++;
    }
    p1Wins = ((double)sim1.getWinRecord()/totalGames)*100;
    p2Wins = ((double)sim2.getWinRecord()/totalGames)*100;
    System.out.println("Player 1 wins: " + sim1.getWinRecord());
    System.out.println("Player 2 wins: " + sim2.getWinRecord());
    System.out.println("Total Games: " + totalGames);
    System.out.println("Player 1 wins ratio: " + (int)p1Wins + "%");
    System.out.println("Player 2 wins ratio: " + (int)p2Wins + "%");
    
  }
  
  public static boolean isFirstBetter(long simulations, PigPlayer first, PigPlayer second){
    int totalGames;
    double firstWins, secondWins;
    totalGames = 0;
    firstWins = 0;
    secondWins = 0;
    PigGame game1 = new PigGame(first, second);
    PigGame game2 = new PigGame(second, first);
    game1.setVerbose(false);
    game2.setVerbose(false);
    for(long x = 0; x < (simulations/2); x++){
      game1.playGame();
      totalGames++;
    }
    for(long x = 0; x < (simulations/2); x++){
      game2.playGame();
      totalGames++;
    }
    firstWins = ((double)first.getWinRecord()/totalGames)*100;
    secondWins = ((double)second.getWinRecord()/totalGames)*100;
    System.out.println("Player 1 win ratio: " + (int)firstWins + "%");
    System.out.println("Player 2 win ratio: " + (int)secondWins + "%");
    if(first.getWinRecord()>second.getWinRecord())
      return true;
    else
      return false;
  }
  
//  public static void bestHoldValue(long simulations){
//    PigPlayer sim1, sim2;
//    sim1 = new SimpleHoldPlayer("Sim Player 1");
//    sim2 = new SimpleHoldPlayer("Sim Player 2");
//    
//  }
  
  
//  public static void main(String[] args){
//    Simulation.firstAdvantage(10000);
//    PigPlayer sim1, sim2;
//    sim1 = new SimpleHoldPlayer("Sim Player 1");
//    sim2 = new SimpleHoldPlayer("Sim Player 2");
//    System.out.println(Simulation.isFirstBetter(10000, sim1, sim2));
//    Simulation.bestHoldValue(10000);
//  }
}