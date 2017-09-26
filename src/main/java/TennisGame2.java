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
        String score = "";
        if ( p1point == p2point ) {
            score = caseEqualScore ( );
        }

        if ( p1point != p2point ) {
            score = caseNotEqualScore ( );
        }
        return score;
    }

    private String caseEqualScore() {
        String score;
        if ( p1point < 3 ) {
            score = getSuitableMessage (p1point);
            score += SEPARATOR + ALL;
        } else
            score = TennisScore.DEUCE.getScoreLabel ( );
        return score;
    }

    private String caseNotEqualScore() {
        String score;
        final boolean isBreakGame = p1point >= 4 || p2point >= 4;
        if ( isBreakGame ) {
            score = getScoreBreakGame ( );
        } else {
            p1res = getSuitableMessage (p1point);
            p2res = getSuitableMessage (p2point);
            score = p1res + SEPARATOR + p2res;
        }
        return score;
    }

    private String getScoreBreakGame() {
        String score;
        int differenceResults = p1point - p2point;
        final boolean isPlayerOneInHead = differenceResults > 0;
        if ( isPlayerOneInHead )
            score = getAdvantageOrWin (differenceResults, player1Name);
        else
            score = getAdvantageOrWin (differenceResults, player2Name);
        return score;
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