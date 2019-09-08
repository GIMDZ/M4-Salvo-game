package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Salvo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "gamePlayer_id")
  private GamePlayer gamePlayer;

  private int turn;

  @ElementCollection
  @Column(name = "location")
  Set<String> salvoLocations = new HashSet<>();

  //Constructor

  public Salvo() {}

  public Salvo (GamePlayer gamePlayer, int turn, Set<String> salvoLocations) {
    this.gamePlayer = gamePlayer;
    this.turn = turn;
    this.salvoLocations = salvoLocations;
  }

  //getters

  public Long getId() {
    return id;
  }

  public GamePlayer getGamePlayer() {
    return gamePlayer;
  }

  public int getTurn() {
    return turn;
  }

  public Set<String> getSalvoLocations() {
    return salvoLocations;
  }

  //setters

  public void setGamePlayer(GamePlayer gamePlayer) {
    this.gamePlayer = gamePlayer;
  }

  public void setTurn(int turn) {
    this.turn = turn;
  }

  public void setSalvoLocations(Set<String> salvoLocations) {
    this.salvoLocations = salvoLocations;
  }

}

