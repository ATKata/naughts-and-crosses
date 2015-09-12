package naughtsandcrosses;

public enum Position {

    TOP_MIDDLE(Row.TOP, Column.MIDDLE), TOP_RIGHT(Row.TOP, Column.RIGHT), MIDDLE_LEFT(Row.MIDDLE, Column.LEFT), MIDDLE(Row.MIDDLE, Column.MIDDLE), TOP_LEFT(Row.TOP, Column.LEFT), MIDDLE_RIGHT(Row.MIDDLE, Column.RIGHT), BOTTOM_RIGHT(Row.BOTTOM, Column.RIGHT), BOTTOM_LEFT(Row.BOTTOM,Column.LEFT ), BOTTOM_MIDDLE(Row.BOTTOM,Column.MIDDLE);

    private final Row row;
    private final Column column;

    Position(Row row, Column column) {
        this.row = row;
        this.column = column;
    }

    public Row getRow() {
        return row;
    }

    public Column getColumn() {
        return column;
    }

}
