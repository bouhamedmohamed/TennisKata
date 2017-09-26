
public class TennisGame2 implements TennisGame {
    public static final String SEPARATOR = "-";
    public static final String ALL = "All";
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if ( P1point == P2point && P1point < 4 ) {
            if ( P1point == 0 )
                score = TennisScore.LOVE.getScore ( );
            if ( P1point == 1 )
                score = TennisScore.FIFTEEN.getScore ( );
            if ( P1point == 2 )
                score = TennisScore.THIRTY.getScore ( );
            score += SEPARATOR + ALL;
        }
        if ( P1point == P2point && P1point >= 3 )
            score = TennisScore.DEUCE.getScore ( );

        if ( P1point > 0 && P2point == 0 ) {
            P1res = getSuitableMessage (P1point);

            P2res = TennisScore.LOVE.getScore ( );
            score = P1res + SEPARATOR + P2res;
        }
        if ( P2point > 0 && P1point == 0 ) {
            P2res = getSuitableMessage (P2point);

            P1res = TennisScore.LOVE.getScore ( );
            score = P1res + SEPARATOR + P2res;
        }

        if ( P1point > P2point && P1point < 4 ) {
            if ( P1point == 2 )
                P1res = TennisScore.THIRTY.getScore ( );
            if ( P1point == 3 )
                P1res = TennisScore.FORTY.getScore ( );
            if ( P2point == 1 )
                P2res = TennisScore.FIFTEEN.getScore ( );
            if ( P2point == 2 )
                P2res = TennisScore.THIRTY.getScore ( );
            score = P1res + SEPARATOR + P2res;
        }
        if ( P2point > P1point && P2point < 4 ) {
            if ( P2point == 2 )
                P2res = TennisScore.THIRTY.getScore ( );
            if ( P2point == 3 )
                P2res = TennisScore.FORTY.getScore ( );
            if ( P1point == 1 )
                P1res = TennisScore.FIFTEEN.getScore ( );
            if ( P1point == 2 )
                P1res = TennisScore.THIRTY.getScore ( );
            score = P1res + SEPARATOR + P2res;
        }

        if ( P1point > P2point && P2point >= 3 ) {
            score = "Advantage " + player1Name;
        }

        if ( P2point > P1point && P1point >= 3 ) {
            score = "Advantage " + player2Name;
        }

        if ( P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2 ) {
            score = "Win for player1";
        }
        if ( P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2 ) {
            score = "Win for player2";
        }
        return score;
    }

    private String getSuitableMessage(int Score) {
        if ( Score == 1 )
            return TennisScore.FIFTEEN.getScore ( );
        if ( Score == 2 )
            return TennisScore.THIRTY.getScore ( );
        else
            return TennisScore.FORTY.getScore ( );
    }

    public void P1Score() {
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if ( player == "player1" )
            P1Score ( );
        else
            P2Score ( );
    }
}