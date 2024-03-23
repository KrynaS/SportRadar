package dev.kryna;

import java.util.ArrayList;

public class Scoreboard {

    public ArrayList<Match> getMatches() {
        return matches;
    }

    private final ArrayList<Match> matches = new ArrayList<>();

    public Match startMatch(String homeTeam, String awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        matches.add(match);
        return match;
    }

    public void updateScore(Match match, int homeScore, int awayScore) {
        if(homeScore < 0 || awayScore < 0) {
            throw new RuntimeException("Scores cannot be negative");
        }
        match.setHomeScore(homeScore);
        match.setAwayScore(awayScore);
    }

    public void finishMatch(Match match) {
        matches.remove(match);
    }
}
