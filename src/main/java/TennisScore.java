public enum TennisScore {
    DEUCE ("Deuce"), FORTY ("Forty"), THIRTY ("Thirty"), FIFTEEN ("Fifteen"), LOVE ("Love");
    private String value;

    public String getValue() {
        return value;
    }

    TennisScore(String value) {
        this.value = value;
    }
}