import java.util.HashMap;
import java.util.Map;

public class ScoreTable {
	public Map<String, Integer> scoreTable;
	public int totalScore;
	
	
	public ScoreTable() {
		scoreTable = new HashMap<>();
		scoreTable.put("aces", 0);
		scoreTable.put("twos", 0);
		scoreTable.put("threes", 0);
		scoreTable.put("fours", 0);
		scoreTable.put("fives", 0);
		scoreTable.put("sixes", 0);
		scoreTable.put("threeOfKind", 0);
		scoreTable.put("fourOfKind", 0);
		scoreTable.put("fullhouse", 0);
		scoreTable.put("smallStraight", 0);
		scoreTable.put("largeStraight", 0);
		scoreTable.put("yahtzee", 0);
		scoreTable.put("chance", 0);
		totalScore = 0;
	}
	
	public void countScore() {
		for(String i : scoreTable.keySet()) {
			totalScore += scoreTable.get(i);
		}
	}
	
	public String toString() {
		String output="";
		for(String i : scoreTable.keySet()) {
			output = output + i + ": " + scoreTable.get(i) + "\n";
		}
		return output;
	}
}
