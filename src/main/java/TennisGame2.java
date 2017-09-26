public class TennisGame2 implements TennisGame {
    public static final String SEPARATOR = "-";
    public static final String ALL = "All";
    public int p1point = 0;
    public int p2point = 0;

    public String p1res = "";
    public String p2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if ( p1point == p2point )
            return caseEqualScore (p1point);
        return caseNotEqualScore (p1point, p2point);

    }

    private String caseEqualScore(int point) {
        String score;
        if ( point < 3 ) {
            score = getSuitableMessage (point);
            score += SEPARATOR + ALL;
        } else
            score = TennisScore.DEUCE.getScoreLabel ( );
        return score;
    }

    private String caseNotEqualScore(int pointOne, int pointTwo) {
        String score;
        final boolean isBreakGame = pointOne >= 4 || pointTwo >= 4;
        if ( isBreakGame ) {
            score = getScoreBreakGame (pointOne, pointTwo);
        } else {
            p1res = getSuitableMessage (pointOne);
            p2res = getSuitableMessage (pointTwo);
            score = p1res + SEPARATOR + p2res;
        }
        return score;
    }

    private String getScoreBreakGame(int pointOne, int pointTwo) {
        int differenceResults = pointOne - pointTwo;
        final boolean isPlayerOneInHead = differenceResults > 0;
        if ( isPlayerOneInHead )
            return getAdvantageOrWin (differenceResults, player1Name);

        return getAdvantageOrWin (differenceResults, player2Name);

    }

    private String getAdvantageOrWin(int differenceResults, String playerName) {
        return Math.abs (differenceResults) == 1 ? "Advantage " + playerName : "Win for " + playerName;
    }

    private String getSuitableMessage(int score) {
        return TennisScore.getScore (score).getScoreLabel ( );
    }

    public void P1Score() {
        p1point++;
    }

    public void P2Score() {
        p2point++;
    }

    public void wonPoint(String player) {
        if ( player == "player1" )
            P1Score ( );
        else
            P2Score ( );
    }
}