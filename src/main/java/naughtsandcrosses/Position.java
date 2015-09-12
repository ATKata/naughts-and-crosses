package naughtsandcrosses;
public enum Position {
    TOP_MIDDLE(Row.TOP,Column.MIDDLE), TOP_RIGHT(Row.TOP,Column.RIGHT), MIDDLE_LEFT(Row.MIDDLE,Column.LEFT), MIDDLE(Row.MIDDLE,Column.MIDDLE), TOP_LEFT(Row.TOP,Column.LEFT), MIDDLE_RIGHT(Row.MIDDLE,Column.RIGHT);

    private final Row row;
    private final Column column;

    private Position(Row row, Column column) {
        this.row = row;
        this.column = column;
    }
}
