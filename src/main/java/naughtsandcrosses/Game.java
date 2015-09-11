package naughtsandcrosses;

import java.util.ArrayList;
import java.util.List;
import static naughtsandcrosses.Position.*;

public class Game {

    private List<Position> history = new ArrayList<Position>();

    public int getNumberOfTurnsPlayed() {
        return history.size();
    }

    public Status takeTurn(Position position) {
        history.add(position);
        List<Position> noughts = getNoughts();
        if (noughts.contains(TOP_LEFT)&&noughts.contains(TOP_MIDDLE)&&noughts.contains(TOP_RIGHT)) {
            return Status.WIN;
        }
        return Status.IN_PROGRESS;
    }

    public boolean isValidTurn(Position position) {
        return !history.contains(position);
    }

    public List<Position> getNoughts() {
        ArrayList<Position> noughts = new ArrayList<Position>();
        for (int i = 0; i < history.size(); i += 2) {
            noughts.add(history.get(i));
        }
        return noughts;
    }
}