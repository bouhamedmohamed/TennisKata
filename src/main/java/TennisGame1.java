
public class TennisGame1 implements TennisGame {
    public static final String SEPARATOR = "-";
    public static final String DEUCE = "Deuce";
    public static final String ALL = "All";
    public static final boolean EQUAL_SCORE = true;
    public static final String FORTY = "Forty";
    public static final String THIRTY = "Thirty";
    public static final String FIFTEEN = "Fifteen";
    public static final String LOVE = "Love";
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
            return getScoreLastPart (m_score1, EQUAL_SCORE);
        else {

            if ( isGameMoreThanForty ( ) )
                return getScoreSecondPart ( );
            else
                return getScoreLastPart (m_score1, !EQUAL_SCORE)
                        + SEPARATOR
                        + getScoreLastPart (m_score2, !EQUAL_SCORE);
        }
    }

    private boolean isGameMoreThanForty() {
        return m_score1 >= 4 || m_score2 >= 4;
    }

    private String getScoreSecondPart() {
        int minusResult = m_score1 - m_score2;
        if ( minusResult > 0 )
            return minusResult == 1 ? "Advantage " + player1Name : "Win for " + player1Name;
        else
            return minusResult == -1 ? "Advantage " + player2Name : "Win for " + player2Name;
    }

    private String getScoreLastPart(int tempScore, boolean isEqualScore) {
        String score;
        switch (tempScore) {
            case 0:
                score = getSuitableMessage (LOVE, isEqualScore);
                break;
            case 1:
                score = getSuitableMessage (FIFTEEN, isEqualScore);
                break;
            case 2:
                score = getSuitableMessage (THIRTY, isEqualScore);
                break;
            default:
                return getSuitableMessage (FORTY, isEqualScore);
        }
        return score;
    }

    String getSuitableMessage(String message, boolean equalScore) {
        String lastMessage = message;
        if ( equalScore )
            if ( !message.equals (FORTY) )
                lastMessage = message + SEPARATOR + ALL;
            else
                lastMessage = DEUCE;
        return lastMessage;

    }
}
