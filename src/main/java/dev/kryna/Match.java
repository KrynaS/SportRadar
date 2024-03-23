package dev.kryna;

import java.sql.Timestamp;

public class Match {

    private final String homeTeam;
    private final String awayTeam;

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    private int homeScore;
    private int awayScore;

    public Match(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
    }
}
