
public class TennisGame1 implements TennisGame {
    public static final String SEPARATOR = "-";
    public static final String ALL = "All";
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if ( playerName == player1Name )
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if ( m_score1 == m_score2 )
            return getEqualScoreBeforeForty (m_score1);

        else if ( isBreakOrMatchPoint ( ) )
            return getScoreAfterForty ( );

        return getScoreBeforeForty (m_score1)
                + SEPARATOR
                + getScoreBeforeForty (m_score2);
    }

    private String getEqualScoreBeforeForty(int score) {
        final boolean isDeuce = score >= 3;
        if ( isDeuce )
            return TennisScore.DEUCE.getScoreLabel ( );
        TennisScore tennisScore = TennisScore.getScore (score);
        return tennisScore.getScoreLabel ( ) + SEPARATOR + ALL;


    }

    private boolean isBreakOrMatchPoint() {
        return m_score1 >= 4 || m_score2 >= 4;
    }

    private String getScoreAfterForty() {
        int minusResult = m_score1 - m_score2;
        if ( minusResult > 0 )
            return checkAdvantageOrWin (minusResult, player1Name);
        return checkAdvantageOrWin (minusResult, player2Name);
    }

    private String checkAdvantageOrWin(int minusResult, String playerName) {
        return Math.abs (minusResult) == 1 ? "Advantage " + playerName : "Win for " + playerName;
    }

    private String getScoreBeforeForty(int tempScore) {

        TennisScore tennisScore = TennisScore.getScore (tempScore);
        return tennisScore.getScoreLabel ( );
    }


}
