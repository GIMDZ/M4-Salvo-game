package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity

public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String shipType;

    //Relacion para DB
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gamePlayer_id")
    private GamePlayer gamePlayer;

    //Para la location
    @ElementCollection
    @Column(name="location")
    private Set<String> locations = new HashSet<>();

    //Constructor
    public Ship() { }

    public Ship(String shipType, GamePlayer gamePlayer, Set<String> locations) {
        this.shipType = shipType;
        this.gamePlayer = gamePlayer;
        this.locations = locations;

    }
    //Getters
    public long getId() {
        return id;
    }

    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public Set<String> getLocations() {
        return locations;
    }

    public String getShipType() {
        return shipType;
    }


    //Setters
    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public void setLocations(Set<String> locations) {
        this.locations = locations;
    }

    //Salida
    public String toString() {
        return shipType;
    }

}
