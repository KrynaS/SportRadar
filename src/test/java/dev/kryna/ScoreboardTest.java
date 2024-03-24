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
    void startMatch_addSecondMatchForSameTeam() {
        scoreboard.startMatch("homeTeam", "awayTeam");
        assertThrows(RuntimeException.class, () -> scoreboard.startMatch("homeTeam", "awayTeam2"));
        assertEquals(1, scoreboard.getMatches().size());
    }

    @Test
    void startMatch_addRemovedTeamInNewMatch() {
        Match match = scoreboard.startMatch("homeTeam", "awayTeam");
        scoreboard.finishMatch(match);
        assertDoesNotThrow(() -> scoreboard.startMatch("homeTeam", "awayTeam2"));
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
        assertThrows(RuntimeException.class, () -> scoreboard.updateScore(match, 1, -1));
    }

    @Test
    void finishMatch() {
        Match match = scoreboard.startMatch("homeTeam", "awayTeam");
        Match match2 = scoreboard.startMatch("homeTeam2", "awayTeam2");
        assertEquals(2, scoreboard.getMatches().size());
        scoreboard.finishMatch(match);
        assertEquals(1, scoreboard.getMatches().size());
        assertFalse(scoreboard.getMatches().contains(match));
    }

    @Test
    void getScores() throws InterruptedException {

        Match match1 = scoreboard.startMatch("homeTeam1", "awayTeam1");
        Match match2 = scoreboard.startMatch("homeTeam2", "awayTeam2");
        Thread.sleep(50);
        Match match3 = scoreboard.startMatch("homeTeam3", "awayTeam3");
        Match match4 = scoreboard.startMatch("homeTeam4", "awayTeam4");
        scoreboard.updateScore(match4, 4, 4);
        scoreboard.updateScore(match3, 2, 2);
        scoreboard.updateScore(match2, 2, 2);
        scoreboard.updateScore(match1, 1, 1);

        String summary = scoreboard.getSummary();

        String expectedSummary = """
                    homeTeam4 4 - awayTeam4 4
                    homeTeam3 2 - awayTeam3 2
                    homeTeam2 2 - awayTeam2 2
                    homeTeam1 1 - awayTeam1 1""";

        assertEquals(expectedSummary, summary);
    }
}