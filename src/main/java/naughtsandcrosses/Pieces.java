package naughtsandcrosses;

import java.util.*;

public class Pieces {

    private Collection<Position> store;
    private Map<Row, List<Column>> rows;
    private Map<Column, List<Row>> columns;
    private Collection<Position> topLeftToBottomRightDiagonal;
    private Collection<Position> bottomLeftToTopRightDiagonal;

    public Pieces() {
        store = new ArrayList<>();
        rows = new HashMap<>();
        columns = new HashMap<>();
        for (Row row : Row.values()) {
            rows.put(row, new ArrayList<>());
        }
        for (Column column : Column.values()) {
            columns.put(column, new ArrayList<>());
        }
        topLeftToBottomRightDiagonal = new ArrayList<>();
        bottomLeftToTopRightDiagonal = new ArrayList<>();
    }

    public int size() {
        return store.size();
    }

    public void add(Position position) {
        store.add(position);
        rows.get(position.getRow()).add(position.getColumn());
        columns.get(position.getColumn()).add(position.getRow());
        if (Position.TOP_LEFT == position || Position.MIDDLE == position || Position.BOTTOM_RIGHT == position) {
            topLeftToBottomRightDiagonal.add(position);
        }
        if (Position.TOP_RIGHT == position || Position.MIDDLE == position || Position.BOTTOM_LEFT == position) {
            bottomLeftToTopRightDiagonal.add(position);
        }
    }

    public boolean contains(Position position) {
        return store.contains(position);
    }

    public boolean threeInALine() {
        for (Row row : Row.values()) {
            if (rows.get(row).size() == 3) {
                return true;
            }
        }
        for (Column column : Column.values()) {
            if (columns.get(column).size() == 3) {
                return true;
            }
        }
        return topLeftToBottomRightDiagonal.size() == 3 || bottomLeftToTopRightDiagonal.size() == 3;
    }
}
