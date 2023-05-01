public class Player {
    private String name;
    private int score;
    private ScoreTable scoreTable;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.scoreTable = new ScoreTable();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        score += points;
    }
}
