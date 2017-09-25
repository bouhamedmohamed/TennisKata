
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
        String score;

        if ( m_score1 >= 4 || m_score2 >= 4 ) {
            score = getScoreSecondPart ( );
        } else
            score = getScoreLastPart (m_score1, NOT_EQUAL_SCORE) + SEPARATOR + getScoreLastPart (m_score2, NOT_EQUAL_SCORE);

        if ( m_score1 == m_score2 ) {

            score = getScoreLastPart (m_score1, EQUAL_SCORE);

        }
        return score;
    }

    private String getScoreSecondPart() {
        int minusResult = m_score1 - m_score2;
        if ( minusResult > 0 ) {
            if ( minusResult == 1 )
                return "Advantage player1";
            return "Win for player1";
        } else {
            if ( minusResult == -1 )
                return "Advantage player2";
            return "Win for player2";
        }
    }

    private String getScoreLastPart(int tempScore, boolean equalScore) {
        String score;
        switch (tempScore) {
            case 0:
                score = getSuitableMessage ("Love", equalScore);
                break;
            case 1:
                score = getSuitableMessage ("Fifteen", equalScore);
                break;
            case 2:
                score = getSuitableMessage ("Thirty", equalScore);
                break;
            default:
                return getSuitableMessage ("Forty", equalScore);
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
