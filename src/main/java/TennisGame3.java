
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
        String s;
        if ( pointPlayerOne < 4 && pointPlayerTwo < 4 && !(pointPlayerOne + pointPlayerTwo == 6) ) {
            s = TennisScore.getScore (pointPlayerOne).getScoreLabel ( );
            return (pointPlayerOne == pointPlayerTwo) ? s + "-All" : s + "-" + TennisScore.getScore (pointPlayerTwo).getScoreLabel ( );
        } else {
            if ( pointPlayerOne == pointPlayerTwo )
                return "Deuce";
            s = pointPlayerOne > pointPlayerTwo ? playerOneName : playerTwoName;
            return ((pointPlayerOne - pointPlayerTwo) * (pointPlayerOne - pointPlayerTwo) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }

    public void wonPoint(String playerName) {
        if ( playerName == "player1" )
            this.pointPlayerOne += 1;
        else
            this.pointPlayerTwo += 1;

    }

}
