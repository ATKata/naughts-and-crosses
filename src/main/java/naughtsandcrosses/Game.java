package naughtsandcrosses;

import java.util.ArrayList;
import java.util.List;

import static naughtsandcrosses.Position.*;

public class Game {

    private List<Position> noughts = new ArrayList<>();
    private List<Position> crosses = new ArrayList<>();

    public int getNumberOfTurnsPlayed() {
        return noughts.size() + crosses.size();
    }

    public Status takeTurn(Position position) {
        if ((noughts.size() + crosses.size()) % 2 == 0) {
            noughts.add(position);
        } else {
            crosses.add(position);
        }

        if ((noughts.contains(TOP_LEFT) && noughts.contains(TOP_MIDDLE) && noughts.contains(TOP_RIGHT)) ||
                noughts.contains(MIDDLE_LEFT) && noughts.contains(MIDDLE) && noughts.contains(MIDDLE_RIGHT)) {
            return Status.WIN_NOUGHTS;
        }
        return Status.IN_PROGRESS;
    }

    public boolean isValidTurn(Position position) {
        return !noughts.contains(position) && !crosses.contains(position);
    }

}