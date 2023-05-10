import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class GameLogicTest {
	public ArrayList<Dice> diceList;

    @Test
    public void testSingleKind() {
    	diceList = new ArrayList<>();
    	for(int i = 0; i<5; i++) {
    		diceList.add(new Dice());
            diceList.get(i).setValue(i+1);
    	}
       
        int scoreOfOne = GameLogic.calculateScoreForCategory("Ones", diceList);
        assertEquals(1, scoreOfOne);
        int scoreOfTwo = GameLogic.calculateScoreForCategory("Twos", diceList);
        assertEquals(2, scoreOfTwo);
        int scoreOfThree = GameLogic.calculateScoreForCategory("Threes", diceList);
        assertEquals(3, scoreOfThree);
        int scoreOfFours = GameLogic.calculateScoreForCategory("Fours", diceList);
        assertEquals(4, scoreOfFours);
        int scoreOfFive = GameLogic.calculateScoreForCategory("Fives", diceList);
        assertEquals(5, scoreOfFive);
        int scoreOfSixes = GameLogic.calculateScoreForCategory("Sixes", diceList);
        assertEquals(0, scoreOfSixes);
    }

    @Test
    public void testSumOfAKind() {
    	diceList = new ArrayList<>();
    	for(int i = 0; i<5; i++) {
    		diceList.add(new Dice());
            diceList.get(i).setValue(2);
    	}
        int score = GameLogic.calcSumOfAKind(diceList, 2);
        assertEquals(10, score);
    }

    // Similarly, write tests for other categories

    @Test
    public void testInvalidCategory() {
    	diceList = new ArrayList<>();
    	for(int i = 0; i<5; i++) {
    		diceList.add(new Dice());
            diceList.get(i).setValue(2);
    	}
        int score = GameLogic.calculateScoreForCategory("Invalid Category", diceList);
        assertEquals(0, score);
    }
    
    @Test
    public void testCalcNumScoreOnes() {
    	diceList = new ArrayList<>();
    	for(int i = 0; i<5; i++) {
    		diceList.add(new Dice());
            diceList.get(i).setValue(i+1);
    	}
        int sum = GameLogic.calcNumScore(diceList, 1);
        assertEquals(1, sum);
    }

    @Test
    public void testCalcNumScoreTwos() {
    	diceList = new ArrayList<>();
    	for(int i = 0; i<5; i++) {
    		diceList.add(new Dice());
            diceList.get(i).setValue(i+1);
    	}
        int sum = GameLogic.calcNumScore(diceList, 2);
        assertEquals(2, sum);
    }

    // You can add more test cases for other numbers if necessary

    @Test
    public void testCalcNumScoreInvalidNumber() {
    	diceList = new ArrayList<>();
    	for(int i = 0; i<5; i++) {
    		diceList.add(new Dice());
            diceList.get(i).setValue(i+1);
    	}
        int sum = GameLogic.calcNumScore(diceList, 7);
        assertEquals(0, sum);
    }
    
    @Test
    public void testCalcSumOfAKind() {
        ArrayList<Dice> diceList = new ArrayList<>();
        diceList.add(new Dice());
        diceList.get(0).setValue(1);
        diceList.add(new Dice());
        diceList.get(1).setValue(1);
        diceList.add(new Dice());
        diceList.get(2).setValue(2);
        diceList.add(new Dice());
        diceList.get(3).setValue(2);
        diceList.add(new Dice());
        diceList.get(4).setValue(2);
        
        // Edge-pair coverage test cases
        assertEquals(0, GameLogic.calcSumOfAKind(new ArrayList<>(), 3)); // empty dice list
        assertEquals(0, GameLogic.calcSumOfAKind(diceList, 5)); // no five of a kind
        assertEquals(0, GameLogic.calcSumOfAKind(diceList, 4)); // no four of a kind
        assertEquals(9, GameLogic.calcSumOfAKind(diceList, 3)); // typical three of a kind score

        
        // All-DU-Path coverage test cases
        assertEquals(0, GameLogic.calcSumOfAKind(new ArrayList<>(), 3)); // empty dice list
        assertEquals(0, GameLogic.calcSumOfAKind(diceList, 5)); // no five of a kind
        assertEquals(0, GameLogic.calcSumOfAKind(diceList, 4)); // no four of a kind
        
        assertEquals(9, GameLogic.calcSumOfAKind(diceList, 3)); // typical three of a kind score
    }
    
    @Test
    public void testCalcSumOfAllDice() {
    	diceList = new ArrayList<>();
    	for(int i = 0; i<5; i++) {
    		diceList.add(new Dice());
            diceList.get(i).setValue(i+1);
    	}
        
        // Edge-pair coverage test cases
        assertEquals(0, GameLogic.calcSumOfAllDice(new ArrayList<>())); // empty dice list
        assertEquals(15, GameLogic.calcSumOfAllDice(diceList)); // typical sum of all dice
        
        // All-DU-Path coverage test cases
        assertEquals(0, GameLogic.calcSumOfAllDice(new ArrayList<>())); // empty dice list
        assertEquals(15, GameLogic.calcSumOfAllDice(diceList)); // typical sum of all dice
    }
    


}