package naughtsandcrosses;

        import org.junit.Before;
        import org.junit.Test;

        import static naughtsandcrosses.Position.*;
        import static naughtsandcrosses.Status.IN_PROGRESS;
        import static naughtsandcrosses.Status.WIN;
        import static org.hamcrest.MatcherAssert.assertThat;
        import static org.hamcrest.Matchers.equalTo;
        import static org.junit.Assert.assertFalse;
        import static org.junit.Assert.assertTrue;

public class GameTest {
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void shouldStartWithAnEmptyGrid() {
        assertThat(game.getNumberOfTurnsPlayed(), equalTo(0));
    }

    @Test
    public void takeTurnTopLeftShouldMakeGridNotEmpty() {
        game.takeTurn(TOP_LEFT);
        assertThat(game.getNumberOfTurnsPlayed(), equalTo(1));
    }

    @Test
    public void takeTurnTopLeftTwiceShouldNotBeAllowed(){
        game.takeTurn(TOP_LEFT);
        assertFalse(game.isValidTurn(TOP_LEFT));
    }

    @Test
    public void takeTwoTurnsInDifferentBoxesIsValid() {
        game.takeTurn(TOP_LEFT);
        assertTrue(game.isValidTurn(TOP_MIDDLE));
    }

    @Test
    public void aRowOfOXOIsNotAWin() {
        assertThat(game.takeTurn(TOP_LEFT), equalTo(IN_PROGRESS));
        assertThat(game.takeTurn(TOP_MIDDLE), equalTo(IN_PROGRESS));
        assertThat(game.takeTurn(TOP_RIGHT), equalTo(IN_PROGRESS));
    }

    @Test
    public void aRowOfOOOIsAWin() {
        assertThat(game.takeTurn(TOP_LEFT), equalTo(IN_PROGRESS));
        assertThat(game.takeTurn(MIDDLE_LEFT), equalTo(IN_PROGRESS));
        assertThat(game.takeTurn(TOP_MIDDLE), equalTo(IN_PROGRESS));
        assertThat(game.takeTurn(MIDDLE), equalTo(IN_PROGRESS));
        assertThat(game.takeTurn(TOP_RIGHT), equalTo(WIN));
    }

    @Test
    public void aRowOfOOXIsNotAWin() {
        assertThat(game.takeTurn(TOP_LEFT), equalTo(IN_PROGRESS));
        assertThat(game.takeTurn(MIDDLE_LEFT), equalTo(IN_PROGRESS));
        assertThat(game.takeTurn(TOP_MIDDLE), equalTo(IN_PROGRESS));
        assertThat(game.takeTurn(TOP_RIGHT), equalTo(IN_PROGRESS));
        assertThat(game.takeTurn(MIDDLE), equalTo(IN_PROGRESS));
    }
}
