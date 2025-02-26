import com.fasterxml.jackson.annotation.JsonProperty;

public class IPLMatch {
    private String team1;
    private String team2;
    private String playerOfTheMatch;
    private int matchNumber;

    // Getters and Setters
    @JsonProperty("team1")
    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    @JsonProperty("team2")
    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    @JsonProperty("playerOfTheMatch")
    public String getPlayerOfTheMatch() {
        return playerOfTheMatch;
    }

    public void setPlayerOfTheMatch(String playerOfTheMatch) {
        this.playerOfTheMatch = playerOfTheMatch;
    }

    @JsonProperty("matchNumber")
    public int getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }
}
