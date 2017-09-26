
public class TennisGame1 implements TennisGame {
    private int pointPlayerOne = 0;
    private int pointPlayerTwo = 0;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame1(String player1Name, String player2Name) {
        this.playerOneName = player1Name;
        this.playerTwoName = player2Name;
    }

    public void wonPoint(String playerName) {
        if ( playerName == playerOneName )
            pointPlayerOne += 1;
        else
            pointPlayerTwo += 1;
    }

    public String getScore() {
        if ( pointPlayerOne == pointPlayerTwo )
            return getEqualScoreBeforeForty (pointPlayerOne);

        else if ( isBreakOrMatchPoint ( ) )
            return getScoreAfterForty ( );

        return getScoreBeforeForty (pointPlayerOne)
                + Rules.SEPARATOR.getValue ( )
                + getScoreBeforeForty (pointPlayerTwo);
    }

    private String getEqualScoreBeforeForty(int score) {
        final boolean isDeuce = score >= 3;
        if ( isDeuce )
            return TennisScore.DEUCE.getScoreLabel ( );
        TennisScore tennisScore = TennisScore.getScore (score);
        return tennisScore.getScoreLabel ( ) + Rules.SEPARATOR.getValue ( ) + Rules.ALL.getValue ( );
    }

    private boolean isBreakOrMatchPoint() {
        return pointPlayerOne >= 4 || pointPlayerTwo >= 4;
    }

    private String getScoreAfterForty() {
        int minusResult = pointPlayerOne - pointPlayerTwo;
        if ( minusResult > 0 )
            return checkAdvantageOrWin (minusResult, playerOneName);
        return checkAdvantageOrWin (minusResult, playerTwoName);
    }

    private String checkAdvantageOrWin(int minusResult, String playerName) {
        return Math.abs (minusResult) == 1 ? Rules.ADVANTAGE.getValue ( ) + playerName : Rules.WIN_FOR.getValue ( ) + playerName;
    }

    private String getScoreBeforeForty(int tempScore) {

        TennisScore tennisScore = TennisScore.getScore (tempScore);
        return tennisScore.getScoreLabel ( );
    }
}
