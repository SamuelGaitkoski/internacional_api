package br.com.samuelgaitkoski.internacional_api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (columnDefinition = "varchar(20) not null") 
    private String opponentTeam;
    @Column (columnDefinition = "varchar(30) not null") 
    private String stadium;
    @Column (columnDefinition = "varchar(30) not null") 
    private String winner;
    @Column (columnDefinition = "varchar(7) not null") 
    private String scoreboard;
    @Column (columnDefinition = "varchar(50) not null") 
    private String championship;


    public Match(int id, String opponentTeam, String stadium, String winner, String scoreboard, 
    String championship) {
        this.id = id;
        this.opponentTeam = opponentTeam;
        this.stadium = stadium;
        this.winner = winner;
        this.scoreboard = scoreboard;
        this.championship = championship;
    }

    public Match() {
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
