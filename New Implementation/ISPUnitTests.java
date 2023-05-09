import static org.junit.Assert.*;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ISPUnitTests {
	
	private MainGui main;
	
	@Before
	public void beforeTest() {
		main = new MainGui();
		ArrayList<Dice> diceList = new ArrayList<Dice>();
		for (int i = 0; i < 5; i++) {
			Dice d = new Dice();
			diceList.add(d);
		}
		main.setDiceList(diceList);
	}
	
	@After
	public void afterTest() {
		main = null;
	}
	
	@Test
	public void testRollDice1() {
		main.rollDice(); // simulates the clicking of a button
		
		assertTrue(main.getRollCount() == 1);
	}
	
	@Test
    public void testRollDiceOneDice() {
        main.setRollCount(0);
        main.rollDice();
        assertEquals("Roll: 1", main.getRollText());
    }
    
    @Test
    public void testRollDiceTwoDice() {
    	main.setRollCount(1);
        main.rollDice();
        assertEquals("Roll: 2", main.getRollText());
    }
    
    @Test
    public void testRollDiceThreeDice() {
    	main.setRollCount(2);
        main.rollDice();
        assertEquals("Roll: 3", main.getRollText());
    }
    
    @Test
    public void testRollDiceFourDice() {
    	main.setRollCount(3);
        main.rollDice();
        assertTrue(3 == main.getRollCount());
    }
    
    // Number of dice selected partition
    @Test
    public void testRollDiceNoDiceSelected() {
    	main.setRollCount(1);
        
        assertTrue(main.getDiceList().get(0).isRollable() == true);
        assertTrue(main.getDiceList().get(1).isRollable() == true);
        assertTrue(main.getDiceList().get(2).isRollable() == true);
        assertTrue(main.getDiceList().get(3).isRollable() == true);
        assertTrue(main.getDiceList().get(4).isRollable() == true);
        
        main.rollDice();
        
        assertTrue(main.getDiceList().get(0).isRollable() == true);
        assertTrue(main.getDiceList().get(1).isRollable() == true);
        assertTrue(main.getDiceList().get(2).isRollable() == true);
        assertTrue(main.getDiceList().get(3).isRollable() == true);
        assertTrue(main.getDiceList().get(4).isRollable() == true);
    }
    
    @Test
    public void testRollDiceOneDiceSelected() {
    	main.setRollCount(1);
    	main.getDiceList().get(0).setRollable(false);
    	assertTrue(main.getDiceList().get(0).isRollable() == false);
        assertTrue(main.getDiceList().get(1).isRollable() == true);
        assertTrue(main.getDiceList().get(2).isRollable() == true);
        assertTrue(main.getDiceList().get(3).isRollable() == true);
        assertTrue(main.getDiceList().get(4).isRollable() == true);
        
        main.rollDice();
        
        assertTrue(main.getDiceList().get(0).isRollable() == false);
        assertTrue(main.getDiceList().get(1).isRollable() == true);
        assertTrue(main.getDiceList().get(2).isRollable() == true);
        assertTrue(main.getDiceList().get(3).isRollable() == true);
        assertTrue(main.getDiceList().get(4).isRollable() == true);
        
    }
    
    @Test
    public void testRollDiceTwoDiceSelected() {
    	main.setRollCount(1);
    	main.getDiceList().get(0).setRollable(false);
    	main.getDiceList().get(1).setRollable(false);
    	assertTrue(main.getDiceList().get(0).isRollable() == false);
        assertTrue(main.getDiceList().get(1).isRollable() == false);
        assertTrue(main.getDiceList().get(2).isRollable() == true);
        assertTrue(main.getDiceList().get(3).isRollable() == true);
        assertTrue(main.getDiceList().get(4).isRollable() == true);
        
        main.rollDice();
        
        assertTrue(main.getDiceList().get(0).isRollable() == false);
        assertTrue(main.getDiceList().get(1).isRollable() == false);
        assertTrue(main.getDiceList().get(2).isRollable() == true);
        assertTrue(main.getDiceList().get(3).isRollable() == true);
        assertTrue(main.getDiceList().get(4).isRollable() == true);
        
    }
    
    @Test
    public void testRollDiceThreeDiceSelected() {
    	main.setRollCount(1);
    	main.getDiceList().get(0).setRollable(false);
    	main.getDiceList().get(1).setRollable(false);
    	main.getDiceList().get(2).setRollable(false);
    	assertTrue(main.getDiceList().get(0).isRollable() == false);
        assertTrue(main.getDiceList().get(1).isRollable() == false);
        assertTrue(main.getDiceList().get(2).isRollable() == false);
        assertTrue(main.getDiceList().get(3).isRollable() == true);
        assertTrue(main.getDiceList().get(4).isRollable() == true);
        
        main.rollDice();
        
        assertTrue(main.getDiceList().get(0).isRollable() == false);
        assertTrue(main.getDiceList().get(1).isRollable() == false);
        assertTrue(main.getDiceList().get(2).isRollable() == false);
        assertTrue(main.getDiceList().get(3).isRollable() == true);
        assertTrue(main.getDiceList().get(4).isRollable() == true);
        
    }
    
    @Test
    public void testRollDiceFourDiceSelected() {
    	main.setRollCount(1);
    	main.getDiceList().get(0).setRollable(false);
    	main.getDiceList().get(1).setRollable(false);
    	main.getDiceList().get(2).setRollable(false);
    	main.getDiceList().get(3).setRollable(false);
    	
    	assertTrue(main.getDiceList().get(0).isRollable() == false);
        assertTrue(main.getDiceList().get(1).isRollable() == false);
        assertTrue(main.getDiceList().get(2).isRollable() == false);
        assertTrue(main.getDiceList().get(3).isRollable() == false);
        assertTrue(main.getDiceList().get(4).isRollable() == true);
        
        main.rollDice();
        
        assertTrue(main.getDiceList().get(0).isRollable() == false);
        assertTrue(main.getDiceList().get(1).isRollable() == false);
        assertTrue(main.getDiceList().get(2).isRollable() == false);
        assertTrue(main.getDiceList().get(3).isRollable() == false);
        assertTrue(main.getDiceList().get(4).isRollable() == true);
        
    }
    
    @Test
    public void testRollDiceFiveDiceSelected() {
    	main.setRollCount(1);
    	main.getDiceList().get(0).setRollable(false);
    	main.getDiceList().get(1).setRollable(false);
    	main.getDiceList().get(2).setRollable(false);
    	main.getDiceList().get(3).setRollable(false);
    	main.getDiceList().get(4).setRollable(false);
    	
    	assertTrue(main.getDiceList().get(0).isRollable() == false);
        assertTrue(main.getDiceList().get(1).isRollable() == false);
        assertTrue(main.getDiceList().get(2).isRollable() == false);
        assertTrue(main.getDiceList().get(3).isRollable() == false);
        assertTrue(main.getDiceList().get(4).isRollable() == false);
        
        main.rollDice();
        
        assertTrue(main.getDiceList().get(0).isRollable() == false);
        assertTrue(main.getDiceList().get(1).isRollable() == false);
        assertTrue(main.getDiceList().get(2).isRollable() == false);
        assertTrue(main.getDiceList().get(3).isRollable() == false);
        assertTrue(main.getDiceList().get(4).isRollable() == false);
        
    }
    
    // Table value selected partition
    @Test
    public void testRollDiceOnes() {
    	main.setRollCount(1);
    	
    	main.getDiceList().get(0).setValue(1);
    	main.getDiceList().get(0).setRollable(false);
    	
    	main.getDiceList().get(1).setValue(1);
    	main.getDiceList().get(1).setRollable(false);
    	
    	main.getDiceList().get(2).setValue(1);
    	main.getDiceList().get(2).setRollable(false);
    	
    	main.getDiceList().get(3).setValue(1);
    	main.getDiceList().get(3).setRollable(false);
    	
    	main.getDiceList().get(4).setValue(1);
    	main.getDiceList().get(4).setRollable(false);
    	
        main.rollDice();
        
        Object[][] tableData = main.getTableData();
        assertEquals("5", "" + tableData[0][2]);
    }
    
    @Test
    public void testRollDiceTwos() {
    	main.setRollCount(1);
    	
    	main.getDiceList().get(0).setValue(2);
    	main.getDiceList().get(0).setRollable(false);
    	
    	main.getDiceList().get(1).setValue(2);
    	main.getDiceList().get(1).setRollable(false);
    	
    	main.getDiceList().get(2).setValue(2);
    	main.getDiceList().get(2).setRollable(false);
    	
    	main.getDiceList().get(3).setValue(2);
    	main.getDiceList().get(3).setRollable(false);
    	
    	main.getDiceList().get(4).setValue(3);
    	main.getDiceList().get(4).setRollable(false);
    	
        main.rollDice();
        
        Object[][] tableData = main.getTableData();
        assertEquals("8", "" + tableData[1][2]);
    }
    
    @Test
    public void testRollDiceThrees() {
    	main.setRollCount(1);
    	
    	main.getDiceList().get(0).setValue(3);
    	main.getDiceList().get(0).setRollable(false);
    	
    	main.getDiceList().get(1).setValue(1);
    	main.getDiceList().get(1).setRollable(false);
    	
    	main.getDiceList().get(2).setValue(1);
    	main.getDiceList().get(2).setRollable(false);
    	
    	main.getDiceList().get(3).setValue(1);
    	main.getDiceList().get(3).setRollable(false);
    	
    	main.getDiceList().get(4).setValue(1);
    	main.getDiceList().get(4).setRollable(false);
    	
        main.rollDice();
        
        Object[][] tableData = main.getTableData();
        assertEquals("3", "" + tableData[2][2]);
    }
    
    @Test
    public void testRollDiceFours() {
    	main.setRollCount(1);
    	
    	main.getDiceList().get(0).setValue(3);
    	main.getDiceList().get(0).setRollable(false);
    	
    	main.getDiceList().get(1).setValue(4);
    	main.getDiceList().get(1).setRollable(false);
    	
    	main.getDiceList().get(2).setValue(4);
    	main.getDiceList().get(2).setRollable(false);
    	
    	main.getDiceList().get(3).setValue(1);
    	main.getDiceList().get(3).setRollable(false);
    	
    	main.getDiceList().get(4).setValue(1);
    	main.getDiceList().get(4).setRollable(false);
    	
        main.rollDice();
        
        Object[][] tableData = main.getTableData();
        assertEquals("8", "" + tableData[3][2]);
    }
    
    @Test
    public void testRollDiceFives() {
    	main.setRollCount(1);
    	
    	main.getDiceList().get(0).setValue(3);
    	main.getDiceList().get(0).setRollable(false);
    	
    	main.getDiceList().get(1).setValue(5);
    	main.getDiceList().get(1).setRollable(false);
    	
    	main.getDiceList().get(2).setValue(1);
    	main.getDiceList().get(2).setRollable(false);
    	
    	main.getDiceList().get(3).setValue(5);
    	main.getDiceList().get(3).setRollable(false);
    	
    	main.getDiceList().get(4).setValue(1);
    	main.getDiceList().get(4).setRollable(false);
    	
        main.rollDice();
        
        Object[][] tableData = main.getTableData();
        assertEquals("10", "" + tableData[4][2]);
    }
    
    @Test
    public void testRollDiceSixes() {
    	main.setRollCount(1);
    	
    	main.getDiceList().get(0).setValue(6);
    	main.getDiceList().get(0).setRollable(false);
    	
    	main.getDiceList().get(1).setValue(1);
    	main.getDiceList().get(1).setRollable(false);
    	
    	main.getDiceList().get(2).setValue(6);
    	main.getDiceList().get(2).setRollable(false);
    	
    	main.getDiceList().get(3).setValue(6);
    	main.getDiceList().get(3).setRollable(false);
    	
    	main.getDiceList().get(4).setValue(1);
    	main.getDiceList().get(4).setRollable(false);
    	
        main.rollDice();
        
        Object[][] tableData = main.getTableData();
        assertEquals("18", "" + tableData[5][2]);
    }
    
    @Test
    public void testRollDice3Kind() {
    	main.setRollCount(1);
    	
    	main.getDiceList().get(0).setValue(3);
    	main.getDiceList().get(0).setRollable(false);
    	
    	main.getDiceList().get(1).setValue(2);
    	main.getDiceList().get(1).setRollable(false);
    	
    	main.getDiceList().get(2).setValue(1);
    	main.getDiceList().get(2).setRollable(false);
    	
    	main.getDiceList().get(3).setValue(1);
    	main.getDiceList().get(3).setRollable(false);
    	
    	main.getDiceList().get(4).setValue(1);
    	main.getDiceList().get(4).setRollable(false);
    	
        main.rollDice();
        
        Object[][] tableData = main.getTableData();
        int check = main.getLogic().calculateScoreForCategory("Three of a Kind", main.getDiceList());
        assertTrue(check == Integer.parseInt("" + tableData[8][2]));
    }
    
    @Test
    public void testRollDice4Kind() {
    	main.setRollCount(1);
    	
    	main.getDiceList().get(0).setValue(3);
    	main.getDiceList().get(0).setRollable(false);
    	
    	main.getDiceList().get(1).setValue(1);
    	main.getDiceList().get(1).setRollable(false);
    	
    	main.getDiceList().get(2).setValue(1);
    	main.getDiceList().get(2).setRollable(false);
    	
    	main.getDiceList().get(3).setValue(1);
    	main.getDiceList().get(3).setRollable(false);
    	
    	main.getDiceList().get(4).setValue(1);
    	main.getDiceList().get(4).setRollable(false);
    	
        main.rollDice();
        
        Object[][] tableData = main.getTableData();
        int check = main.getLogic().calculateScoreForCategory("Four of a Kind", main.getDiceList());
        assertTrue(check == Integer.parseInt("" + tableData[9][2]));
    }
    
    @Test
    public void testRollDiceFullHouse() {
    	main.setRollCount(1);
    	
    	main.getDiceList().get(0).setValue(3);
    	main.getDiceList().get(0).setRollable(false);
    	
    	main.getDiceList().get(1).setValue(3);
    	main.getDiceList().get(1).setRollable(false);
    	
    	main.getDiceList().get(2).setValue(1);
    	main.getDiceList().get(2).setRollable(false);
    	
    	main.getDiceList().get(3).setValue(1);
    	main.getDiceList().get(3).setRollable(false);
    	
    	main.getDiceList().get(4).setValue(1);
    	main.getDiceList().get(4).setRollable(false);
    	
        main.rollDice();
        
        Object[][] tableData = main.getTableData();
        int check = main.getLogic().calculateScoreForCategory("Full House", main.getDiceList());
        assertTrue(check == Integer.parseInt("" + tableData[10][2]));
    }
    
    @Test
    public void testRollDiceSmallStraight() {
    	main.setRollCount(1);
    	
    	main.getDiceList().get(0).setValue(4);
    	main.getDiceList().get(0).setRollable(false);
    	
    	main.getDiceList().get(1).setValue(3);
    	main.getDiceList().get(1).setRollable(false);
    	
    	main.getDiceList().get(2).setValue(1);
    	main.getDiceList().get(2).setRollable(false);
    	
    	main.getDiceList().get(3).setValue(2);
    	main.getDiceList().get(3).setRollable(false);
    	
    	main.getDiceList().get(4).setValue(1);
    	main.getDiceList().get(4).setRollable(false);
    	
        main.rollDice();
        
        Object[][] tableData = main.getTableData();
        int check = main.getLogic().calculateScoreForCategory("Small Straight", main.getDiceList());
        assertTrue(check == Integer.parseInt("" + tableData[11][2]));
    }
    
    @Test
    public void testRollDiceLargeStraight() {
    	main.setRollCount(1);
    	
    	main.getDiceList().get(0).setValue(4);
    	main.getDiceList().get(0).setRollable(false);
    	
    	main.getDiceList().get(1).setValue(3);
    	main.getDiceList().get(1).setRollable(false);
    	
    	main.getDiceList().get(2).setValue(1);
    	main.getDiceList().get(2).setRollable(false);
    	
    	main.getDiceList().get(3).setValue(2);
    	main.getDiceList().get(3).setRollable(false);
    	
    	main.getDiceList().get(4).setValue(5);
    	main.getDiceList().get(4).setRollable(false);
    	
        main.rollDice();
        
        Object[][] tableData = main.getTableData();
        int check = main.getLogic().calculateScoreForCategory("Large Straight", main.getDiceList());
        assertTrue(check == Integer.parseInt("" + tableData[12][2]));
    }
    
    @Test
    public void testRollDiceChance() {
    	main.setRollCount(1);
    	
    	main.getDiceList().get(0).setValue(4);
    	main.getDiceList().get(0).setRollable(false);
    	
    	main.getDiceList().get(1).setValue(4);
    	main.getDiceList().get(1).setRollable(false);
    	
    	main.getDiceList().get(2).setValue(4);
    	main.getDiceList().get(2).setRollable(false);
    	
    	main.getDiceList().get(3).setValue(4);
    	main.getDiceList().get(3).setRollable(false);
    	
    	main.getDiceList().get(4).setValue(4);
    	main.getDiceList().get(4).setRollable(false);
    	
        main.rollDice();
        
        Object[][] tableData = main.getTableData();
        int check = main.getLogic().calculateScoreForCategory("Chance", main.getDiceList());
        assertTrue(check == Integer.parseInt("" + tableData[13][2]));
    }
    
    @Test
    public void testRollDiceYahtzee() {
    	main.setRollCount(1);
    	
    	main.getDiceList().get(0).setValue(4);
    	main.getDiceList().get(0).setRollable(false);
    	
    	main.getDiceList().get(1).setValue(4);
    	main.getDiceList().get(1).setRollable(false);
    	
    	main.getDiceList().get(2).setValue(4);
    	main.getDiceList().get(2).setRollable(false);
    	
    	main.getDiceList().get(3).setValue(4);
    	main.getDiceList().get(3).setRollable(false);
    	
    	main.getDiceList().get(4).setValue(4);
    	main.getDiceList().get(4).setRollable(false);
    	
        main.rollDice();
        
        Object[][] tableData = main.getTableData();
        int check = main.getLogic().calculateScoreForCategory("Yahtzee", main.getDiceList());
        assertTrue(check == Integer.parseInt("" + tableData[14][2]));
    }

}
