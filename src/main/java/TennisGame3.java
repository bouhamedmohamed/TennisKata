
public class TennisGame3 implements TennisGame {

    public static final String SEPARATOR = "-";
    public static final String ALL = "All";
    public static final String ADVANTAGE = "Advantage ";
    public static final String WIN_FOR = "Win for ";
    private int pointPlayerTwo;
    private int pointPlayerOne;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame3(String p1N, String p2N) {
        this.playerOneName = p1N;
        this.playerTwoName = p2N;
    }

    public String getScore() {

        final boolean breakPoint = isBreakPoint ( );
        if ( pointPlayerOne == pointPlayerTwo )
            return scoreEqualGame (pointPlayerOne);
        if ( breakPoint )
            return getAdvantagedOrWinner ( );
        return scoreBeforeBreakGame ( );
    }

    private boolean isBreakPoint() {
        return pointPlayerOne >= 4 || pointPlayerTwo >= 4;
    }

    private String scoreEqualGame(int point) {
        if ( point >= 3 )
            return TennisScore.DEUCE.getScoreLabel ( );
        final String scoreLabel = TennisScore.getScore (point).getScoreLabel ( );
        return scoreLabel + SEPARATOR + ALL;
    }

    private String scoreBeforeBreakGame() {
        final String scoreLabelPlayerOne = TennisScore.getScore (pointPlayerOne).getScoreLabel ( );
        final String scoreLabelPlayerTwo = TennisScore.getScore (pointPlayerTwo).getScoreLabel ( );
        return scoreLabelPlayerOne + SEPARATOR + scoreLabelPlayerTwo;
    }

    private String getAdvantagedOrWinner() {

        String playerInHead = pointPlayerOne > pointPlayerTwo ? playerOneName : playerTwoName;
        final int difference = pointPlayerOne - pointPlayerTwo;
        return (Math.abs (difference) == 1) ? ADVANTAGE + playerInHead : WIN_FOR + playerInHead;
    }

    public void wonPoint(String playerName) {
        if ( playerName == playerOneName )
            this.pointPlayerOne += 1;
        else
            this.pointPlayerTwo += 1;

    }

}
