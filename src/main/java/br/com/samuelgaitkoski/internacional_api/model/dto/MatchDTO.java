package br.com.samuelgaitkoski.internacional_api.model.dto;

public class MatchDTO {
    
    private int id;
    private String opponentTeam;
    private String stadium;
    private String winner;
    private String scoreboard;
    private String championship;


    public MatchDTO(int id, String opponentTeam, String stadium, String winner, String scoreboard, 
    String championship) {
        this.id = id;
        this.opponentTeam = opponentTeam;
        this.stadium = stadium;
        this.winner = winner;
        this.scoreboard = scoreboard;
        this.championship = championship;
    }

    public MatchDTO() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpponentTeam() {
        return this.opponentTeam;
    }

    public void setOpponentTeam(String opponentTeam) {
        this.opponentTeam = opponentTeam;
    }

    public String getStadium() {
        return this.stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getWinner() {
        return this.winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getScoreboard() {
        return this.scoreboard;
    }

    public void setScoreboard(String scoreboard) {
        this.scoreboard = scoreboard;
    }

    public String getChampionship() {
        return this.championship;
    }

    public void setChampionship(String championship) {
        this.championship = championship;
    }
    
}
