import java.util.ArrayList;
import java.util.HashMap;

public class GameLogic {
	
	public static void main(String[] args) {
//		ArrayList<Dice> teem = null;
//        teem = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            teem.add(new Dice());
//            teem.get(i).roll();
//            System.out.println(teem.get(i).getValue());
//        }
//        int val = calculateScoreForCategory("Ones", teem);
//        System.out.println(val);
	}
    // Define a HashMap to keep track of each score category and its corresponding score
    public HashMap<String, Integer> scores = new HashMap<String, Integer>();

    // Method to calculate the score for a given category
    public static int calculateScoreForCategory(String category, ArrayList<Dice> diceList) {
        int score = 0;
        switch (category) {
            case "Ones":
                score = calcNumScore(diceList, 1);
                break;
            case "Twos":
                score = calcNumScore(diceList, 2);
                break;
            case "Threes":
                score = calcNumScore(diceList, 3);
                break;
            case "Fours":
                score = calcNumScore(diceList, 4);
                break;
            case "Fives":
                score = calcNumScore(diceList, 5);
                break;
            case "Sixes":
                score = calcNumScore(diceList, 6);
                break;
            case "Three of a Kind":
                score = calculateSumOfAKind(diceList, 3);
                break;
            case "Four of a Kind":
                score = calculateSumOfAKind(diceList, 4);
                break;
            case "Full House":
                score = calculateFullHouseScore(diceList);
                break;
            case "Small Straight":
                score = calculateStraightScore(diceList, 4);
                break;
            case "Large Straight":
                score = calculateStraightScore(diceList, 5);
                break;
            case "Yahtzee":
                score = calculateYahtzeeScore(diceList);
                break;
            case "Chance":
                score = calculateSumOfAllDice(diceList);
                break;
            default:
                break;
        }
        return score;
    }

    // Method to calculate the sum of a specific number in a list of dice
    private static int calcNumScore(ArrayList<Dice> diceList, int number) {
        int sum = 0;
        for (Dice dice : diceList) {
            if (dice.getValue() == number) {
                sum += number;
            }
        }
        return sum;
    }

    // Method to calculate the score for a given kind of dice (3 of a kind, 4 of a kind, etc.)
    private static int calculateSumOfAKind(ArrayList<Dice> diceList, int kind) {
        int[] counts = new int[6];
        for (Dice dice : diceList) {
            counts[dice.getValue() - 1]++;
        }
        for (int i = 0; i < 6; i++) {
            if (counts[i] >= kind) {
                return calculateSumOfAllDice(diceList);
            }
        }
        return 0;
    }
    
 // Method to calculate the sum of all dice
    private static int calculateSumOfAllDice(ArrayList<Dice> diceList) {
        int sum = 0;
        for (Dice dice : diceList) {
            sum += dice.getValue();
        }
        return sum;
    }

    
 // Method to calculate the score for a straight (small or large)
    private static int calculateStraightScore(ArrayList<Dice> diceList, int length) {
        int[] counts = new int[6];
        for (Dice dice : diceList) {
            counts[dice.getValue() - 1]++;
        }
        int maxSequenceLength = 0;
        int currentSequenceLength = 0;
        for (int i = 0; i < 6; i++) {
            if (counts[i] > 0) {
                currentSequenceLength++;
                if (currentSequenceLength > maxSequenceLength) {
                    maxSequenceLength = currentSequenceLength;
                }
            } else {
                currentSequenceLength = 0;
            }
        }
        if (maxSequenceLength >= length) {
            if (length == 4) {
                return 30; // Score for small straight
            } else if (length == 5) {
                return 40; // Score for large straight
            }
        }
        return 0;
    }
    
 // Method to calculate the score for a full house
    private static int calculateFullHouseScore(ArrayList<Dice> diceList) {
        int[] counts = new int[6];
        for (Dice dice : diceList) {
            counts[dice.getValue() - 1]++;
        }
        boolean hasThreeOfAKind = false;
        boolean hasTwoOfAKind = false;
        for (int i = 0; i < 6; i++) {
            if (counts[i] == 3) {
                hasThreeOfAKind = true;
            } else if (counts[i] == 2) {
                hasTwoOfAKind = true;
            }
        }
        if (hasThreeOfAKind && hasTwoOfAKind) {
            return 25; // Score for full house
        }
        return 0;
    }

    
 // Method to calculate the score for a Yahtzee (five of a kind)
    private static int calculateYahtzeeScore(ArrayList<Dice> diceList) {
        int[] counts = new int[6];
        for (Dice dice : diceList) {
            counts[dice.getValue() - 1]++;
        }
        for (int i = 0; i < 6; i++) {
            if (counts[i] == 5) {
                return 50; // Score for Yahtzee
            }
        }
        return 0;
    }

}