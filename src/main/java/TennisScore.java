import java.util.Arrays;

public enum TennisScore {
    LOVE ("Love", 0),
    FIFTEEN ("Fifteen", 1),
    THIRTY ("Thirty", 2),
    FORTY ("Forty", 3),
    DEUCE ("Deuce", 4);
    private String scoreLabel;
    private int score;

    public String getScoreLabel() {
        return scoreLabel;
    }

    public int getScore() {
        return score;
    }

    TennisScore(String scoreLabel, int score) {
        this.scoreLabel = scoreLabel;
        this.score = score;
    }

    public static TennisScore getScore(int tempScore) {
        return Arrays.stream (values ( ))
                .filter (tennisScore -> tennisScore.getScore ( ) == tempScore)
                .findFirst ( )
                .orElseThrow (RuntimeException::new);
    }
}