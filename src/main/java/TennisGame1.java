
public class TennisGame1 implements TennisGame {
    public static final String SEPARATOR = "-";
    public static final String ALL = "All";
    public static final boolean EQUAL_SCORE = true;
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
            return getScoreBeforeForty (m_score1, EQUAL_SCORE);
        else {

            if ( isBreakPoint ( ) )
                return getScoreAfterForty ( );
            else
                return getScoreBeforeForty (m_score1, !EQUAL_SCORE)
                        + SEPARATOR
                        + getScoreBeforeForty (m_score2, !EQUAL_SCORE);
        }
    }

    private boolean isBreakPoint() {
        return m_score1 >= 4 || m_score2 >= 4;
    }

    private String getScoreAfterForty() {
        int minusResult = m_score1 - m_score2;
        if ( minusResult > 0 )
            return getScoreAfterForty (minusResult, player1Name);
        return getScoreAfterForty (minusResult, player2Name);
    }

    private String getScoreAfterForty(int minusResult, String playerName) {
        return Math.abs (minusResult) == 1 ? "Advantage " + playerName : "Win for " + playerName;
    }

    private String getScoreBeforeForty(int tempScore, boolean isEqualScore) {
        String score;
        switch (tempScore) {
            case 0:
                score = getSuitableMessage (TennisScore.LOVE, isEqualScore);
                break;
            case 1:
                score = getSuitableMessage (TennisScore.FIFTEEN, isEqualScore);
                break;
            case 2:
                score = getSuitableMessage (TennisScore.THIRTY, isEqualScore);
                break;
            default:
                score =  getSuitableMessage (TennisScore.FORTY, isEqualScore);
        }
        return score;
    }

    String getSuitableMessage(TennisScore message, boolean equalScore) {
        String lastMessage = message.getValue ();

        if ( equalScore )
            if ( !message.equals (TennisScore.FORTY) )
                lastMessage = lastMessage + SEPARATOR + ALL;
            else
                lastMessage = TennisScore.DEUCE.getValue ();
        return lastMessage;

    }
}
