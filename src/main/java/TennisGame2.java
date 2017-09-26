public class TennisGame2 implements TennisGame {
    public static final String SEPARATOR = "-";
    public static final String ALL = "All";
    public static final String ADVANTAGE = "Advantage ";
    public static final String WIN_FOR = "Win for ";
    public int pointPlayerOne = 0;
    public int pointPlayerTwo = 0;

    public String resultPlayerOne = "";
    public String resultPlayerTwo = "";
    private String playerOneName;
    private String playerTwoName;

    public TennisGame2(String player1Name, String player2Name) {
        this.playerOneName = player1Name;
        this.playerTwoName = player2Name;
    }

    public String getScore() {
        if ( pointPlayerOne == pointPlayerTwo )
            return caseEqualScore (pointPlayerOne);
        return caseNotEqualScore (pointPlayerOne, pointPlayerTwo);

    }

    private String caseEqualScore(int point) {
        if ( point < 3 )
            return getSuitableMessage (point) + SEPARATOR + ALL;
        return TennisScore.DEUCE.getScoreLabel ( );
    }

    private String caseNotEqualScore(int pointOne, int pointTwo) {
        final boolean isBreakGame = pointOne >= 4 || pointTwo >= 4;
        if ( isBreakGame )
            return getScoreBreakGame (pointOne, pointTwo);
        resultPlayerOne = getSuitableMessage (pointOne);
        resultPlayerTwo = getSuitableMessage (pointTwo);
        return resultPlayerOne + SEPARATOR + resultPlayerTwo;

    }

    private String getScoreBreakGame(int pointOne, int pointTwo) {
        int differenceResults = pointOne - pointTwo;
        final boolean isPlayerOneInHead = differenceResults > 0;
        if ( isPlayerOneInHead )
            return getAdvantageOrWin (differenceResults, playerOneName);
        return getAdvantageOrWin (differenceResults, playerTwoName);

    }

    private String getAdvantageOrWin(int differenceResults, String playerName) {
        return Math.abs (differenceResults) == 1 ? ADVANTAGE + playerName : WIN_FOR + playerName;
    }

    private String getSuitableMessage(int score) {
        return TennisScore.getScore (score).getScoreLabel ( );
    }

    public void P1Score() {
        pointPlayerOne++;
    }

    public void P2Score() {
        pointPlayerTwo++;
    }

    public void wonPoint(String player) {
        if ( player == playerOneName )
            P1Score ( );
        else
            P2Score ( );
    }
}