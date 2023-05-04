import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Yahtzee {
    private Dice[] dice;
    private Player player;
    public ScoreTable temp = new ScoreTable();

    public Yahtzee(Player player) {
        this.player = player;
        dice = new Dice[5];
        for (int i = 0; i < dice.length; i++) {
        	dice[i] = new Dice();
        }
    }
    
 // Add this method to get the dice array
    public Dice[] getDice() {
        return dice;
    }

    public void showDice() {
    	for (Dice die : dice) {
            System.out.print(die.getValue() + " ");
        }
    }
    
    // Add this method to get the player
    public Player getPlayer() {
        return player;
    }
    
    public String showScore(Player player) {
    	return player.showScoreTable();
    }
    
    public void roundCheck(int fillIn) {
    	switch(fillIn) {
    	case 1: player.getScoreTable().scoreTable.put("aces", temp.scoreTable.get("aces"));break;
    	case 2: player.getScoreTable().scoreTable.put("twos", temp.scoreTable.get("twos"));break;
    	case 3: player.getScoreTable().scoreTable.put("threes", temp.scoreTable.get("threes"));break;
    	case 4: player.getScoreTable().scoreTable.put("fours", temp.scoreTable.get("fours"));break;
    	case 5: player.getScoreTable().scoreTable.put("fives", temp.scoreTable.get("fives"));break;
    	case 6: player.getScoreTable().scoreTable.put("sixes", temp.scoreTable.get("sixes"));break;
    	case 7: player.getScoreTable().scoreTable.put("threeOfKind", temp.scoreTable.get("threeOfKind"));break;
    	case 8: player.getScoreTable().scoreTable.put("fourOfKind", temp.scoreTable.get("fourOfKind"));break;
    	case 9: player.getScoreTable().scoreTable.put("fullhouse", temp.scoreTable.get("fullhouse"));break;
    	case 10: player.getScoreTable().scoreTable.put("smallStraight", temp.scoreTable.get("smallStraight"));break;
    	case 11: player.getScoreTable().scoreTable.put("largeStraight", temp.scoreTable.get("largeStraight"));break;
    	case 12: player.getScoreTable().scoreTable.put("yahtzee", temp.scoreTable.get("yahtzee"));break;
    	case 13: player.getScoreTable().scoreTable.put("chance", temp.scoreTable.get("chance"));break;	
    	}
    	System.out.println(this.player.showScoreTable());
    }
    
    public void playTurn(int round) {
        int numRolls = 0;
        
        System.out.print("Round " + (round + 1) + ":");
        System.out.println();
        for(Dice die :dice) {
        	die.roll();
        }
        System.out.print("Roll " + (numRolls + 1) + ":");
        System.out.println();
        showDice();
        System.out.println();
        calculateScore();
        System.out.println((temp));
        while (numRolls < 3) {
            if(numRolls == 2) {
            	Scanner scanner = new Scanner(System.in);
                System.out.println("Please enter the box that you want to fill in on your score card (1-13). Type numebr to finish this round.");
                try {
                	int fillIn = scanner.nextInt();
                	roundCheck(fillIn);
                }catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid input. Please enter the dice numbers you want to reroll (1-5) separated by spaces, or 'done' to finish.");
                }
                break;
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the dice you want to reroll (1-5), separated by spaces. Type 'done' to finish.");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
            	System.out.println("Please choose a box( 1-13 ) you want to fill in this round");
            	int fillIn = scanner.nextInt();
            	roundCheck(fillIn);
                break;
            }
            String[] tokens = input.split(" ");
            for (String token : tokens) {
                try {
                    int dieIndex = Integer.parseInt(token) - 1;
                    dice[dieIndex].roll();
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid input. Please enter the dice numbers you want to reroll (1-5) separated by spaces, or 'done' to finish.");
                }
            }
            numRolls++;
            System.out.print("Roll " + (numRolls + 1) + ":");
            System.out.println();
            showDice();
            System.out.println();
            calculateScore();
            System.out.println((temp));
        }
    }

    private void calculateScore() {
    	int maxSameKind=0;
    	int chance = 0;
        int[] diceCounts = {0,0,0,0,0,0};
        for (Dice die : dice) {
            diceCounts[die.getValue() - 1]++;
            maxSameKind = maxSameKind>diceCounts[die.getValue() - 1]?maxSameKind:diceCounts[die.getValue() - 1];
        }

        int score = 0;

        // Scoring for 1, 2, 3, 4, or 5 of a kind.
        for (int i = 0; i < diceCounts.length; i++) {
        	if(diceCounts[i]>=2) {
        		switch(i+1) {
                case 1: temp.scoreTable.put("aces", diceCounts[i]*1); break;
                case 2: temp.scoreTable.put("twos", diceCounts[i]*2);break;
                case 3: temp.scoreTable.put("threes", diceCounts[i]*3);break;
                case 4: temp.scoreTable.put("fours", diceCounts[i]*4);break;
                case 5: temp.scoreTable.put("fives", diceCounts[i]*5);break;
                case 6: temp.scoreTable.put("sixes", diceCounts[i]*6);break;
                }
        	}
            chance +=  diceCounts[i] * (i + 1);
            temp.scoreTable.put("chance", chance);
        }

     // Check for 3, 4, or 5 of a kind
        for (int i = 0; i < diceCounts.length; i++) {
            if (diceCounts[i] >= 3) {
            	temp.scoreTable.put("threeOfKind", chance);
            }
            if (diceCounts[i] >= 4) {
            	temp.scoreTable.put("fourOfKind", chance);
            }
            if (diceCounts[i] == 5) {
            	temp.scoreTable.put("ace", 50);
            }
        }

        // Check for small straight
        if (isStraight(diceCounts, 1, 4) || isStraight(diceCounts, 2, 5) || isStraight(diceCounts, 3, 6)) {
        	temp.scoreTable.put("smallStraight", 30);
        }

        // Check for large straight
        if (isStraight(diceCounts, 1, 5) || isStraight(diceCounts, 2, 6)) {
        	temp.scoreTable.put("largeStraight", 40);
        }
    }

    public static boolean isStraight(int[] counts, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (counts[i - 1] != 1) {
                return false;
            }
        }
        return true;
    }
}

