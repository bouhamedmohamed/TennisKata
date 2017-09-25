
public class TennisGame1 implements TennisGame {

    public static final String PLAYER1 = "player1";
    public static final String SEPARATOR = "-";
    public static final String DEUCE = "Deuce";
    public static final String ALL = "All";
    public static final boolean NOT_EQUAL_SCORE = false;
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
        if ( playerName == PLAYER1 )
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
                return getScoreLastPart (m_score1, NOT_EQUAL_SCORE)
                        + SEPARATOR
                        + getScoreLastPart (m_score2, NOT_EQUAL_SCORE);
        }
    }

    private boolean isGameMoreThanForty() {
        return m_score1 >= 4 || m_score2 >= 4;
    }

    private String getScoreSecondPart() {
        int minusResult = m_score1 - m_score2;
        if ( minusResult > 0 )
            return minusResult == 1 ? "Advantage player1" : "Win for player1";
        else
            return minusResult == -1 ? "Advantage player2" : "Win for player2";
    }

    private String getScoreLastPart(int tempScore, boolean isEqualScore) {
        String score;
        switch (tempScore) {
            case 0:
                score = getSuitableMessage ("Love", isEqualScore);
                break;
            case 1:
                score = getSuitableMessage ("Fifteen", isEqualScore);
                break;
            case 2:
                score = getSuitableMessage ("Thirty", isEqualScore);
                break;
            default:
                return getSuitableMessage ("Forty", isEqualScore);
        }
        return score;
    }

    String getSuitableMessage(String message, boolean equalScore) {
        String lastMessage = message;
        if ( equalScore )
            if ( !message.equals ("Forty") )
                lastMessage = message + SEPARATOR + ALL;
            else
                lastMessage = DEUCE;
        return lastMessage;

    }
}
