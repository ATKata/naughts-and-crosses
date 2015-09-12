package naughtsandcrosses;

import static naughtsandcrosses.Position.*;

public class Game {

    private Pieces noughts = new Pieces();
    private Pieces crosses = new Pieces();

    public int getNumberOfTurnsPlayed() {
        return noughts.size() + crosses.size();
    }

    public Status takeTurn(Position position) {
        if ((noughts.size() + crosses.size()) % 2 == 0) {
            noughts.add(position);
            if (noughts.threeInALine()) {
                return Status.WIN_NOUGHTS;
            }
        } else {
            crosses.add(position);
            if (crosses.threeInALine()) {
                return Status.WIN_CROSSES;
            }
        }
        if(getNumberOfTurnsPlayed()==9){
            return Status.DRAW;
        }
        return Status.IN_PROGRESS;
    }

    public boolean isValidTurn(Position position) {
        return !noughts.contains(position) && !crosses.contains(position);
    }

}