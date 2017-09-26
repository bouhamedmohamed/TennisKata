public enum TennisScore {
    LOVE ("Love"),
    FIFTEEN ("Fifteen"),
    THIRTY ("Thirty"),
    FORTY ("Forty"),
    DEUCE ("Deuce");
    private String score;

    public String getScore() {
        return score;
    }

    TennisScore(String score) {
        this.score = score;
    }
}