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
    
    public boolean roundCheck(int fillIn) {
    	boolean fillCheck=false;
    	switch(fillIn) {
    	case 1: if(player.getScoreTable().scoreTable.get("aces")==0) {
    		player.getScoreTable().scoreTable.put("aces", temp.scoreTable.get("aces"));
    		fillCheck = true;
    	}else {
    		System.out.println("You can't refill this box, please choose another one");
    		System.out.println();
    	}
    	break;
    	case 2: if(player.getScoreTable().scoreTable.get("twos")==0) {
    		player.getScoreTable().scoreTable.put("twos", temp.scoreTable.get("twos"));
    		fillCheck = true;
    	}else {
    		System.out.println("You can't refill this box, please choose another one");
    		System.out.println();
    	}
    	break;
    	case 3: 
    		if(player.getScoreTable().scoreTable.get("threes")==0) {
    			player.getScoreTable().scoreTable.put("threes", temp.scoreTable.get("threes"));
    			fillCheck = true;
        	}else {
        		System.out.println("You can't refill this box, please choose another one");
        		System.out.println();
        	}
        	break;
    	case 4: if(player.getScoreTable().scoreTable.get("fours")==0) {
    		player.getScoreTable().scoreTable.put("fours", temp.scoreTable.get("fours"));
    		fillCheck = true;
    	}else {
    		System.out.println("You can't refill this box, please choose another one");
    		System.out.println();
    	}
    	break;
    	case 5: if(player.getScoreTable().scoreTable.get("fives")==0) {
    		player.getScoreTable().scoreTable.put("fives", temp.scoreTable.get("fives"));
    		fillCheck = true;
    	}else {
    		System.out.println("You can't refill this box, please choose another one");
    		System.out.println();
    	}
    	break;
    	case 6: if(player.getScoreTable().scoreTable.get("sixes")==0) {
    		player.getScoreTable().scoreTable.put("sixes", temp.scoreTable.get("sixes"));
    		fillCheck = true;
    	}else {
    		System.out.println("You can't refill this box, please choose another one");
    		System.out.println();
    	}
    	break;
    	case 7: if(player.getScoreTable().scoreTable.get("threeOfKind")==0) {
    		player.getScoreTable().scoreTable.put("threeOfKind", temp.scoreTable.get("threeOfKind"));
    		fillCheck = true;
    	}else {
    		System.out.println("You can't refill this box, please choose another one");
    		System.out.println();
    	}
    	break;
    	case 8: if(player.getScoreTable().scoreTable.get("fourOfKind")==0) {
    		player.getScoreTable().scoreTable.put("fourOfKind", temp.scoreTable.get("fourOfKind"));
    		fillCheck = true;
    	}else {
    		System.out.println("You can't refill this box, please choose another one");
    		System.out.println();
    	}
    	break;
    	case 9: if(player.getScoreTable().scoreTable.get("fullhouse")==0) {
    		player.getScoreTable().scoreTable.put("fullhouse", temp.scoreTable.get("fullhouse"));
    		fillCheck = true;
    	}else {
    		System.out.println("You can't refill this box, please choose another one");
    		System.out.println();
    	}
    	break;
    	case 10: if(player.getScoreTable().scoreTable.get("smallStraight")==0) {
    		player.getScoreTable().scoreTable.put("smallStraight", temp.scoreTable.get("smallStraight"));
    		fillCheck = true;
    	}else {
    		System.out.println("You can't refill this box, please choose another one");
    		System.out.println();
    	}
    	break;
    	case 11: if(player.getScoreTable().scoreTable.get("largeStraight")==0) {
    		player.getScoreTable().scoreTable.put("largeStraight", temp.scoreTable.get("largeStraight"));
    		fillCheck = true;
    	}else {
    		System.out.println("You can't refill this box, please choose another one");
    		System.out.println();
    	}
    	break;
    	case 12: if(player.getScoreTable().scoreTable.get("yahtzee")==0) {
    		player.getScoreTable().scoreTable.put("yahtzee", temp.scoreTable.get("yahtzee"));
    		fillCheck = true;
    	}else {
    		System.out.println("You can't refill this box, please choose another one");
    		System.out.println();
    	}
    	break;
    	case 13: if(player.getScoreTable().scoreTable.get("chance")==0) {
    		player.getScoreTable().scoreTable.put("chance", temp.scoreTable.get("chance"));
    		fillCheck = true;
    	}else {
    		System.out.println("You can't refill this box, please choose another one");
    		System.out.println();
    	}
    	break;	
    	}
    	System.out.println(this.player.showScoreTable());
    	return fillCheck;
    }
    
    public void playTurn(int round) {
        int numRolls = 0;
        int fillIn = 0;
        boolean fillCheck = false;
        
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
                
                try {
                	do {
                		System.out.println("Please enter the box that you want to fill in on your score card (1-13). Type numebr to finish this round.");
                		fillIn = scanner.nextInt();
                    	fillCheck = roundCheck(fillIn);
                	}while(fillCheck==false);
                }catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid input. Please enter the dice numbers you want to reroll (1-5) separated by spaces, or 'done' to finish.");
                }
                break;
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the dice you want to reroll (1-5), separated by spaces. Type 'done' to finish.");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
            	
            	do {
            		System.out.println("Please choose a box( 1-13 ) you want to fill in this round");
            		fillIn = scanner.nextInt();
                	fillCheck = roundCheck(fillIn);
            	}while(fillCheck==false);
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
