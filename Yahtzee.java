import java.util.Scanner;

public class Yahtzee {
    private Dice[] dice;
    private Player player;

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

    // Add this method to get the player
    public Player getPlayer() {
        return player;
    }
    
    public void roundCheck() {
    	
    }
    
    public void rollDice(int[] position) {
    	for(int i : position) {
    		dice[i].roll();
    	}
    }
    
    public void playTurn() {
        int numRolls = 0;
        
        while (numRolls < 3) {
        	int count = 1;
            for (Dice die : dice) {
                die.roll();
            }
            numRolls++;
            
            System.out.println("Roll " + (numRolls + 1) + ": ");
            for (Dice die : dice) {
                System.out.print(die.getValue() + " ");
            }
            System.out.println();
            
            if(numRolls == 3) {
            	Scanner scanner = new Scanner(System.in);
                System.out.println("Please enter the box that you want to fill in on your score card (1-13). Type numebr to finish this round.");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("done")) {
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
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the dice you want to reroll (1-5), separated by spaces. Type 'done' to finish.");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
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
         // Implement scoring and update the player's score.
            int points = calculateScore();
            player.addScore(points);
            System.out.println(player.getName() + " scored " + points + " points this turn. Total score: " + player.getScore());
        }
    }

    private int calculateScore() {
        int[] diceCounts = new int[6];
        for (Dice die : dice) {
            diceCounts[die.getValue() - 1]++;
        }

        int score = 0;

        // Scoring for 3, 4, or 5 of a kind.
        for (int i = 0; i < diceCounts.length; i++) {
            if (diceCounts[i] >= 3) {
                score += (i + 1) * diceCounts[i];
            }
        }

        // Scoring for a full house (3 of a kind + 2 of a kind).
        boolean hasThreeOfAKind = false;
        boolean hasTwoOfAKind = false;
        for (int count : diceCounts) {
            if (count == 3) {
                hasThreeOfAKind = true;
            } else if (count == 2) {
                hasTwoOfAKind = true;
            }
        }
        if (hasThreeOfAKind && hasTwoOfAKind) {
            score += 25; // Full House
        }

        // Scoring for a small straight (4 consecutive numbers).
        if ((diceCounts[0] > 0 && diceCounts[1] > 0 && diceCounts[2] > 0 && diceCounts[3] > 0) ||
            (diceCounts[1] > 0 && diceCounts[2] > 0 && diceCounts[3] > 0 && diceCounts[4] > 0) ||
            (diceCounts[2] > 0 && diceCounts[3] > 0 && diceCounts[4] > 0 && diceCounts[5] > 0)) {
            score += 30; // Small Straight
        }

        // Scoring for a large straight (5 consecutive numbers).
        if ((diceCounts[0] == 1 && diceCounts[1] == 1 && diceCounts[2] == 1 && diceCounts[3] == 1 && diceCounts[4] == 1) ||
            (diceCounts[1] == 1 && diceCounts[2] == 1 && diceCounts[3] == 1 && diceCounts[4] == 1 && diceCounts[5] == 1)) {
            score += 40; // Large Straight
        }

        // Scoring for a Yahtzee (5 of a kind).
        for (int count : diceCounts) {
            if (count == 5) {
                score += 50; // Yahtzee
                break;
            }
        }

        return score;
    }

}

