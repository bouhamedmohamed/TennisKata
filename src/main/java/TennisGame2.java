
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
        if ( p1point == p2point && p1point < 4 ) {
            score = getSuitableMessage (p1point);
            score += SEPARATOR + ALL;
        }
        if ( p1point == p2point && p1point >= 3 )
            score = TennisScore.DEUCE.getScore ( );

        if ( p1point > 0 && p2point == 0 ) {
            p1res = getSuitableMessage (p1point);

            p2res = TennisScore.LOVE.getScore ( );
            score = p1res + SEPARATOR + p2res;
        }
        if ( p2point > 0 && p1point == 0 ) {
            p2res = getSuitableMessage (p2point);

            p1res = TennisScore.LOVE.getScore ( );
            score = p1res + SEPARATOR + p2res;
        }

        if ( p1point > p2point && p1point < 4 ) {
            if ( p1point == 2 )
                p1res = TennisScore.THIRTY.getScore ( );
            if ( p1point == 3 )
                p1res = TennisScore.FORTY.getScore ( );
            if ( p2point == 1 )
                p2res = TennisScore.FIFTEEN.getScore ( );
            if ( p2point == 2 )
                p2res = TennisScore.THIRTY.getScore ( );
            score = p1res + SEPARATOR + p2res;
        }
        if ( p2point > p1point && p2point < 4 ) {
            if ( p2point == 2 )
                p2res = TennisScore.THIRTY.getScore ( );
            if ( p2point == 3 )
                p2res = TennisScore.FORTY.getScore ( );
            if ( p1point == 1 )
                p1res = TennisScore.FIFTEEN.getScore ( );
            if ( p1point == 2 )
                p1res = TennisScore.THIRTY.getScore ( );
            score = p1res + SEPARATOR + p2res;
        }

        if ( p1point > p2point && p2point >= 3 ) {
            score = "Advantage " + player1Name;
        }

        if ( p2point > p1point && p1point >= 3 ) {
            score = "Advantage " + player2Name;
        }

        if ( p1point >= 4 && p2point >= 0 && (p1point - p2point) >= 2 ) {
            score = "Win for player1";
        }
        if ( p2point >= 4 && p1point >= 0 && (p2point - p1point) >= 2 ) {
            score = "Win for player2";
        }
        return score;
    }

    private String getSuitableMessage(int Score) {
        if ( Score == 0 )
            return TennisScore.LOVE.getScore ( );
        if ( Score == 1 )
            return TennisScore.FIFTEEN.getScore ( );
        if ( Score == 2 )
            return TennisScore.THIRTY.getScore ( );
        else
            return TennisScore.FORTY.getScore ( );
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