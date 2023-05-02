public class Player {
    private String name;
    private ScoreTable scoreTable;

    public Player(String name) {
        this.name = name;
        this.scoreTable = new ScoreTable();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return scoreTable.totalScore;
    }
    
    public ScoreTable getScoreTable() {
    	return scoreTable;
    }
    
    public String showScoreTable() {
    	return this.scoreTable.toString();
    }
}
