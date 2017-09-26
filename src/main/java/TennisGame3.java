
public class TennisGame3 implements TennisGame {

    private int pointPlayerTwo;
    private int pointPlayerOne;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame3(String p1N, String p2N) {
        this.playerOneName = p1N;
        this.playerTwoName = p2N;
    }

    public String getScore() {

        if ( pointPlayerOne < 4 && pointPlayerTwo < 4 && !(pointPlayerOne + pointPlayerTwo == 6) ) {
            final String scoreLabelPlayerOne = TennisScore.getScore (pointPlayerOne).getScoreLabel ( );
            final String scoreLabelPlayerTwo = TennisScore.getScore (pointPlayerTwo).getScoreLabel ( );
            return (pointPlayerOne == pointPlayerTwo) ? scoreLabelPlayerOne + "-All" : scoreLabelPlayerOne + "-" + scoreLabelPlayerTwo;
        } else {
            if ( pointPlayerOne == pointPlayerTwo )
                return "Deuce";
            String inHead = pointPlayerOne > pointPlayerTwo ? playerOneName : playerTwoName;
            final int difference = pointPlayerOne - pointPlayerTwo;
            return (Math.abs (difference) == 1) ? "Advantage " + inHead : "Win for " + inHead;
        }
    }

    public void wonPoint(String playerName) {
        if ( playerName == "player1" )
            this.pointPlayerOne += 1;
        else
            this.pointPlayerTwo += 1;

    }

}
