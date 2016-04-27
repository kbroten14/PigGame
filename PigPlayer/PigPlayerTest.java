import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class PigPlayerTest extends TestCase {
  
  public void testDie() {
    int[] results = new int[6];
    for (int i=0; i<results.length; i++)
      results[i] = 0;
    Die die = new Die();
    for (int i=0; i<6000; i++) {
      int j = die.roll() - 1;
      results[j]++;
    }
    for (int i=0; i<results.length; i++)
      assertTrue(850 < results[i] && results[i] < 1150);
      
  }
  
  public void testName() {
    UserPigPlayer person = new UserPigPlayer("user");
    assertEquals("user",person.getName());
    person.setName("Helen");
    assertEquals("Helen",person.getName());
  }
  
  public void testScore() {
    UserPigPlayer person = new UserPigPlayer("user");
    assertEquals(0,person.getScore());
  }
  
  
  public void testAddPoints() {
    UserPigPlayer person = new UserPigPlayer("user");
    assertEquals(0,person.getScore());
    person.addPoints(12);
    assertEquals(12,person.getScore());
    person.addPoints(13);
    assertEquals(25,person.getScore());
  }
  
  
  public void testAddReset() {
    UserPigPlayer person = new UserPigPlayer("user");
    assertEquals(0,person.getScore());
    person.addPoints(12);
    person.addPoints(13);
    assertEquals(25,person.getScore());
    person.reset();
    assertEquals(0,person.getScore());
    person.addPoints(22);
    assertEquals(22,person.getScore());
  }
  
  // assumes PigGame.GOAL is 100
  public void testWon() {
    UserPigPlayer person = new UserPigPlayer("user");
    person.addPoints(99);
    assertFalse(person.won());
    
    // check 100 points
    person.addPoints(1);       
    assertTrue(person.won());
    
    // check 101 points
    person = new UserPigPlayer("user");
    person.addPoints(101);
    assertTrue(person.won());
  }
  
  // assumes PigGame.GOAL is 100
  public void testWinRecord() {
    UserPigPlayer person = new UserPigPlayer("user");
    person.addPoints(20);
    assertEquals(0,person.getWinRecord());
    person.addPoints(102);
    assertEquals(1,person.getWinRecord());
    person.reset();
    assertEquals(1,person.getWinRecord());
    person.addPoints(85);
    person.addPoints(35);
    assertEquals(2,person.getWinRecord());
  }
}
