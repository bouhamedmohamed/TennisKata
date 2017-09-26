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
            if ( p1point < 3 ) {
                score = getSuitableMessage (p1point);
                score += SEPARATOR + ALL;
            } else
                score = TennisScore.DEUCE.getScoreLabel ( );
        }

        if ( p1point != p2point ) {
            final boolean isBreakGame = p1point >= 4 || p2point >= 4;
            if ( isBreakGame ) {
                score = getScoreBreakGame ( );
            } else {
                p1res = getSuitableMessage (p1point);
                p2res = getSuitableMessage (p2point);
                score = p1res + SEPARATOR + p2res;
            }
        }
        return score;
    }

    private String getScoreBreakGame() {
        String score;
        int differenceResults = p1point - p2point;
        final boolean isPlayerOneInHead = differenceResults > 0;
        if ( isPlayerOneInHead )
            score = differenceResults == 1 ? "Advantage " + player1Name : "Win for " + player1Name;
        else
            score = differenceResults == -1 ? "Advantage " + player2Name : "Win for " + player2Name;
        return score;
    }

    private String getSuitableMessage(int Score) {
        if ( Score == 0 )
            return TennisScore.LOVE.getScoreLabel ( );
        if ( Score == 1 )
            return TennisScore.FIFTEEN.getScoreLabel ( );
        if ( Score == 2 )
            return TennisScore.THIRTY.getScoreLabel ( );
        else
            return TennisScore.FORTY.getScoreLabel ( );
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