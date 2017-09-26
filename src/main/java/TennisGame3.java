
public class TennisGame3 implements TennisGame {
    private int pointPlayerTwo;
    private int pointPlayerOne;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame3(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public String getScore() {

        final boolean breakPoint = isBreakPoint ( );
        if ( pointPlayerOne == pointPlayerTwo )
            return scoreEqualGame (pointPlayerOne);
        if ( breakPoint )
            return getAdvantagedOrWinner ( );
        return scoreBeforeBreakGame ( );
    }

    private boolean isBreakPoint() {
        return pointPlayerOne >= 4 || pointPlayerTwo >= 4;
    }

    private String scoreEqualGame(int point) {
        if ( point >= 3 )
            return TennisScore.DEUCE.getScoreLabel ( );
        final String scoreLabel = TennisScore.getScore (point).getScoreLabel ( );
        return scoreLabel + Rules.SEPARATOR + Rules.ALL;
    }

    private String scoreBeforeBreakGame() {
        final String scoreLabelPlayerOne = TennisScore.getScore (pointPlayerOne).getScoreLabel ( );
        final String scoreLabelPlayerTwo = TennisScore.getScore (pointPlayerTwo).getScoreLabel ( );
        return scoreLabelPlayerOne + Rules.SEPARATOR + scoreLabelPlayerTwo;
    }

    private String getAdvantagedOrWinner() {

        String playerInHead = pointPlayerOne > pointPlayerTwo ? playerOneName : playerTwoName;
        final int difference = pointPlayerOne - pointPlayerTwo;
        return (Math.abs (difference) == 1) ? Rules.ADVANTAGE + playerInHead : Rules.WIN_FOR + playerInHead;
    }

    public void wonPoint(String playerName) {
        if ( playerName == playerOneName )
            this.pointPlayerOne += 1;
        else
            this.pointPlayerTwo += 1;

    }

}
