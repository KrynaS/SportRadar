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
    void startMatch(){
        scoreboard.startMatch("homeTeam", "awayTeam");
        assertEquals(1, scoreboard.matches.size());
    }

}