package dev.kryna;

import java.util.ArrayList;
import java.util.Collections;

public class Scoreboard {

    public ArrayList<Match> getMatches() {
        return matches;
    }

    private final ArrayList<Match> matches = new ArrayList<>();

    private final ArrayList<String> teamsPlaying = new ArrayList<>();

    public Match startMatch(String homeTeam, String awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        checkTeamsPlaying(homeTeam, awayTeam);
        addTeamsPlaying(homeTeam, awayTeam);
        matches.add(match);
        return match;
    }

    private void addTeamsPlaying(String team1, String team2) {
        teamsPlaying.add(team1);
        teamsPlaying.add(team2);
    }

    private void removeTeamsPlaying(String team1, String team2) {
        teamsPlaying.remove(team1);
        teamsPlaying.remove(team2);
    }

    private void checkTeamsPlaying(String team1, String team2) {
        if(teamsPlaying.contains(team1) || teamsPlaying.contains(team2)) {
            throw new RuntimeException("At least one team already playing");
        }
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
        removeTeamsPlaying(match.getHomeTeam(), match.getAwayTeam());
    }

    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        Collections.sort(matches);
        for(Match m : matches) {
            sb.append(m.toString());
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}
