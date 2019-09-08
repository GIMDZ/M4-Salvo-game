package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity

public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    //Variables

    private long id;
    private Date creationDate;
    //Relacion para DB
    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    private List<GamePlayer> gamePlayers;

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    private Set<Score> scores;

    //Constructor
    public Game() {

    }

    public Game(Date creationDate) {
        this.creationDate = creationDate;

    }

    //getters


    public List<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public Date getCreationDate() {
        return creationDate;
    }
    public long getId() {
        return id;
    }

    public Set<Score> getScores() {
        return scores;
    }

    //setters

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }
}
