package naughtsandcrosses;

import org.junit.Before;
import org.junit.Test;

import static naughtsandcrosses.Position.*;
import static naughtsandcrosses.Status.*;
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
    public void takeTurnTopLeftTwiceShouldNotBeAllowed() {
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
    public void aTopRowOfOOOIsAWinForNoughts() {
        game.takeTurn(TOP_LEFT);
        game.takeTurn(MIDDLE_LEFT);
        game.takeTurn(TOP_MIDDLE);
        game.takeTurn(MIDDLE);
        assertThat(game.takeTurn(TOP_RIGHT), equalTo(WIN_NOUGHTS));
    }

    @Test
    public void aLeftColumnOfOOOIsAWinForNoughts() {
        game.takeTurn(TOP_LEFT);
        game.takeTurn(TOP_MIDDLE);
        game.takeTurn(MIDDLE_LEFT);
        game.takeTurn(MIDDLE);
        assertThat(game.takeTurn(BOTTOM_LEFT), equalTo(WIN_NOUGHTS));
    }

    @Test
    public void aTopLeftToBottomRightDiagonalOfOOOIsAWinForNoughts() {
        game.takeTurn(TOP_LEFT);
        game.takeTurn(TOP_MIDDLE);
        game.takeTurn(MIDDLE);
        game.takeTurn(TOP_RIGHT);
        assertThat(game.takeTurn(BOTTOM_RIGHT), equalTo(WIN_NOUGHTS));
    }

    @Test
    public void aBttomLeftToTopRightDiagonalOfXXXIsAWinForCrosses() {
        game.takeTurn(MIDDLE_LEFT);
        game.takeTurn(BOTTOM_LEFT);
        game.takeTurn(TOP_LEFT);
        game.takeTurn(MIDDLE);
        game.takeTurn(TOP_MIDDLE);
        assertThat(game.takeTurn(TOP_RIGHT), equalTo(WIN_CROSSES));
    }

    @Test
    public void aTopRowOfXXXIsAWinForCrosses() {
        game.takeTurn(MIDDLE_LEFT);
        game.takeTurn(TOP_LEFT);
        game.takeTurn(MIDDLE);
        game.takeTurn(TOP_MIDDLE);
        game.takeTurn(BOTTOM_RIGHT);
        assertThat(game.takeTurn(TOP_RIGHT), equalTo(WIN_CROSSES));
    }

    @Test
    public void aMiddleRowofOOOIsAWinForNoughts(){
        game.takeTurn(MIDDLE_LEFT);
        game.takeTurn(TOP_LEFT);
        game.takeTurn(MIDDLE);
        game.takeTurn(TOP_MIDDLE);
        assertThat(game.takeTurn(MIDDLE_RIGHT), equalTo(WIN_NOUGHTS));
    }

    @Test
    public void aTopRowOfOOXIsNotAWin() {
        game.takeTurn(TOP_LEFT);
        game.takeTurn(MIDDLE_LEFT);
        game.takeTurn(TOP_MIDDLE);
        game.takeTurn(TOP_RIGHT);
        assertThat(game.takeTurn(MIDDLE), equalTo(IN_PROGRESS));
    }

    @Test
    public void nineTurnsWithoutThreeInARowIsADraw(){
        game.takeTurn(TOP_LEFT);
        game.takeTurn(TOP_MIDDLE);
        game.takeTurn(TOP_RIGHT);
        game.takeTurn(MIDDLE);
        game.takeTurn(MIDDLE_LEFT);
        game.takeTurn(MIDDLE_RIGHT);
        game.takeTurn(BOTTOM_MIDDLE);
        game.takeTurn(BOTTOM_LEFT);
        assertThat(game.takeTurn(BOTTOM_RIGHT), equalTo(DRAW));

    }
}
