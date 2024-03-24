package dev.kryna;

import java.sql.Timestamp;
import java.time.Instant;

public class Match implements Comparable<Match> {

    private final String homeTeam;
    private final String awayTeam;
    private int homeScore;
    private int awayScore;
    private final Timestamp startTime;

    public Match(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
        this.startTime = Timestamp.from(Instant.now());
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public String toString() {
        return homeTeam + " " + homeScore + " - " + awayTeam + " " + awayScore;
    }

    @Override
    public int compareTo(Match m) {
        if (this.homeScore + this.awayScore > m.homeScore + m.awayScore) {
            return -1;
        } else if (this.homeScore + this.awayScore < m.homeScore + m.awayScore) {
            return 1;
        } else {
            if (this.startTime.before(m.startTime)) {
                return 1;
            } else if (this.startTime.after(m.startTime)) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}
