package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;


@Entity

public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private Double score;
    private Date endDate;

    //Relacion para DB

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gamePlayer_id")
    private GamePlayer gamePlayer;

    //Constructor
    public Score() { }

    public Score(Game game, Player player, Double score){
        this.game = game;
        this.player = player;
        this.score = score;
        this.endDate = new Date();
    }

    //Getters

    public Game getGame() { return game;}

    public Date getEndDate() {
        return endDate;
    }

    public Double getScore() {
        return score;
    }

    public Player getPlayer() {
        return player;
    }

    public long getId() {
        return id;
    }

    //Setters

    public void setGame(Game game) {
        this.game = game;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
