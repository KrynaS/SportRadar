package dev.kryna;

import java.util.ArrayList;

public class Scoreboard {

    ArrayList<Match> matches = new ArrayList<>();

    public void startMatch(String homeTeam, String awayTeam) {
        matches.add(new Match(homeTeam, awayTeam, 0, 0));
    }
}
