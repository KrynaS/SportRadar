package dev.kryna;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreboardTest {

    Scoreboard scoreboard = new Scoreboard();

    @BeforeEach
    void init() {
        scoreboard = new Scoreboard();
    }

    @Test
    void startMatch() {
        Match match = scoreboard.startMatch("homeTeam", "awayTeam");
        assertEquals(1, scoreboard.getMatches().size());
        assertEquals(0, match.getHomeScore());
        assertEquals(0, match.getAwayScore());
    }

    @Test
    void updateScore_toPositiveValues() {
        Match match = scoreboard.startMatch("homeTeam", "awayTeam");
        scoreboard.updateScore(match, 1, 0);
        assertEquals(1, match.getHomeScore());
        assertEquals(0, match.getAwayScore());
    }

    @Test
    void updateScore_toNegativeValues() {
        Match match = scoreboard.startMatch("homeTeam", "awayTeam");
        assertThrows(UnsupportedOperationException.class, () -> scoreboard.updateScore(match, 1, -1));
    }
}