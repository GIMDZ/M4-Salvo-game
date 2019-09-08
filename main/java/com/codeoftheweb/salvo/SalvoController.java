package com.codeoftheweb.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


@RestController
@RequestMapping("/api")
public class SalvoController {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GamePlayerRepository gamePlayerRepository;

    @RequestMapping("/games")   //Devuelve un list con todos los games
    public List<Object> getGameList(){
        return gameRepository
                .findAll()
                .stream()
                .map(game -> makeGameDTO(game))
                .collect(Collectors.toList());
                }

    //Devuelve un map con los atributos de un game específico
    private Map<String, Object> makeGameDTO(Game game){
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", game.getId());
        dto.put("creationDate", game.getCreationDate());
        dto.put("gamePlayers", getGamePlayerList(game.getGamePlayers()));
        //dto.put("scores", game.getScores().stream());
        return dto;
    }

    //Devuelve un list con todos los gamePlayer de un game
    private List<Object>getGamePlayerList(List<GamePlayer>gamePlayers){
        return gamePlayers
                .stream()
                .map(gamePlayer -> makeGamePlayerDTO(gamePlayer))
                .collect(Collectors.toList());
    }

    //Devuelve un Map con los atributos de un gamePlayer específico
    private Map<String, Object> makeGamePlayerDTO(GamePlayer gamePlayer){
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id",gamePlayer.getId());
        dto.put("player", gamePlayer.getPlayer().makePlayerDTO());
        return dto;
    }

    //Devuelve un Map con los atributos de un Ship específico
    private Map<String, Object> makeShipDTO(Ship ship){
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("type", ship.getShipType());
        dto.put("locations", ship.getLocations());
        return dto;
    }

    //Devuelve un Map con los atributos de un Salvo específico
    private Map<String, Object> makeSalvoDTO(Salvo salvo){
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("turn", salvo.getTurn());
        dto.put("salvoes", salvo.getSalvoLocations());
        return dto;
    }

    //Devuelve un list con un game
    @RequestMapping("/game_view/{gamePlayerId}")
    public Map<String,Object> getGameView(@PathVariable Long gamePlayerId) {

        GamePlayer gamePlayer = gamePlayerRepository.getOne(gamePlayerId);
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", gamePlayerId);
        dto.put("gamePlayers", gamePlayer.getGame().getGamePlayers()
                                                    .stream()
                                                    .map(gamePlayer1 -> makeGamePlayerDTO(gamePlayer1))
                                                    .collect(toList()));
        dto.put("ships", gamePlayer.getShips().stream()
                .map(ship -> makeShipDTO(ship))
                .collect(toList()));

        dto.put("salvoes", gamePlayer.getSalvos().stream()
          .map(salvo -> makeSalvoDTO(salvo))
          .collect(toList()));
        return dto;
    }

    private Map<String, Object> makeLeaderBoardDTO(Player player){
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        List<GamePlayer> gamePlayerList = player.getGamePlayers();
        Set<Score> scores = player.getScores();

        List<Double> listOfPoints = scores.stream()
                .map(score -> score.getScore())
                .collect(toList());

        dto.put("id", player.getId());
        dto.put("name", player.getUserName());
        dto.put("totalScore", listOfPoints);

        return dto;
    }


}