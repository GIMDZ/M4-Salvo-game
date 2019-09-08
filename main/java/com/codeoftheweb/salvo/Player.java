package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity

public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String userName;

    //Relacion para DB

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    private List<GamePlayer> gamePlayers;
    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    private Set<Score> scores;

    //Constructor
    public Player() { }

    public Player(String user) {
        this.userName = user;

    }
    //Getters
    public long getId() {
        return id;
    }

    public List<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public String getUserName() {
        return userName;
    }

    public Set<Score> getScores() {
        return scores;
    }

    //Setters

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }

    //Salida
    public String toString() {
        return userName;
    }

    //Devuelve un Map con todos los atributos de un player específico
    public Map<String, Object> makePlayerDTO(){
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", this.getId());
        dto.put("userName", this.getUserName());
        return dto;
    }

}
