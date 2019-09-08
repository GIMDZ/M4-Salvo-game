package com.codeoftheweb.salvo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import java.util.*;

@SpringBootApplication
public class SalvoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalvoApplication.class, args);
    }

    //Players
    @Bean
    public CommandLineRunner initData(PlayerRepository playerRepository, GameRepository gameRepository,
                                      GamePlayerRepository gamePlayerRepository, ShipRepository shipRepository,
                                      SalvoRepository salvoRepository, ScoreRepository scoreRepository) {
        return (args) -> {

            // Save Player

            Player player1 = new Player("j.bauer@ctu.gov");
            playerRepository.save(player1);
            Player player2 = new Player("c.obrian@ctu.gov");
            playerRepository.save(player2);
            Player player3 = new Player("kim_bauer@gmail.com");
            playerRepository.save(player3);
            Player player4 = new Player("t.almeida@ctu.gov");
            playerRepository.save(player4);

            //Games

            Date gameCreationDate1 = new Date();
            Game game1 = new Game(gameCreationDate1);
            gameRepository.save(game1);
            Date gameCreationDate2 = gameCreationDate1.from(gameCreationDate1.toInstant().plusSeconds(3600));
            Game game2 = new Game(gameCreationDate2);
            gameRepository.save(game2);
            Date gameCreationDate3 = gameCreationDate2.from(gameCreationDate2.toInstant().plusSeconds(3600));
            Game game3 = new Game(gameCreationDate3);
            gameRepository.save(game3);
            Date gameCreationDate4 = gameCreationDate3.from(gameCreationDate3.toInstant().plusSeconds(3600));
            Game game4 = new Game(gameCreationDate4);
            gameRepository.save(game4);
            Date gameCreationDate5 = gameCreationDate4.from(gameCreationDate4.toInstant().plusSeconds(3600));
            Game game5 = new Game(gameCreationDate5);
            gameRepository.save(game5);
            Date gameCreationDate6 = gameCreationDate5.from(gameCreationDate5.toInstant().plusSeconds(3600));
            Game game6 = new Game(gameCreationDate6);
            gameRepository.save(game6);
            Date gameCreationDate7 = gameCreationDate6.from(gameCreationDate6.toInstant().plusSeconds(3600));
            Game game7 = new Game(gameCreationDate7);
            gameRepository.save(game7);
            Date gameCreationDate8 = gameCreationDate7.from(gameCreationDate7.toInstant().plusSeconds(3600));
            Game game8 = new Game(gameCreationDate8);
            gameRepository.save(game8);

            //GamePlayer

            Date gamePlayerCreationDate1 = new Date();
            GamePlayer gamePlayer1 = new GamePlayer(game1, player1, gamePlayerCreationDate1);
            gamePlayerRepository.save(gamePlayer1);
            Date gamePlayerCreationDate2 = new Date();
            GamePlayer gamePlayer2 = new GamePlayer(game1, player2, gamePlayerCreationDate2);
            gamePlayerRepository.save(gamePlayer2);
            Date gamePlayerCreationDate3 = new Date();
            GamePlayer gamePlayer3 = new GamePlayer(game2, player1, gamePlayerCreationDate3);
            gamePlayerRepository.save(gamePlayer3);
            Date gamePlayerCreationDate4 = new Date();
            GamePlayer gamePlayer4 = new GamePlayer(game2, player2, gamePlayerCreationDate4);
            gamePlayerRepository.save(gamePlayer4);
            Date gamePlayerCreationDate5 = new Date();
            GamePlayer gamePlayer5 = new GamePlayer(game3, player2, gamePlayerCreationDate5);
            gamePlayerRepository.save(gamePlayer5);
            Date gamePlayerCreationDate6 = new Date();
            GamePlayer gamePlayer6 = new GamePlayer(game3, player4, gamePlayerCreationDate6);
            gamePlayerRepository.save(gamePlayer6);
            Date gamePlayerCreationDate7 = new Date();
            GamePlayer gamePlayer7 = new GamePlayer(game4, player2, gamePlayerCreationDate7);
            gamePlayerRepository.save(gamePlayer7);
            Date gamePlayerCreationDate8 = new Date();
            GamePlayer gamePlayer8 = new GamePlayer(game4, player1, gamePlayerCreationDate8);
            gamePlayerRepository.save(gamePlayer8);
            Date gamePlayerCreationDate9 = new Date();
            GamePlayer gamePlayer9 = new GamePlayer(game5, player4, gamePlayerCreationDate9);
            gamePlayerRepository.save(gamePlayer9);
            Date gamePlayerCreationDate10 = new Date();
            GamePlayer gamePlayer10 = new GamePlayer(game5, player1, gamePlayerCreationDate10);
            gamePlayerRepository.save(gamePlayer10);
            Date gamePlayerCreationDate11 = new Date();
            GamePlayer gamePlayer11 = new GamePlayer(game6, player3, gamePlayerCreationDate11);
            gamePlayerRepository.save(gamePlayer11);
			/*Date gamePlayerCreationDate12 = new Date();
			GamePlayer gamePlayer12 = new GamePlayer(game6, player1, gamePlayerCreationDate12);
			gamePlayerRepository.save(gamePlayer12);*/
            Date gamePlayerCreationDate13 = new Date();
            GamePlayer gamePlayer13 = new GamePlayer(game7, player4, gamePlayerCreationDate13);
            gamePlayerRepository.save(gamePlayer13);
			/*Date gamePlayerCreationDate14 = new Date();
			GamePlayer gamePlayer14 = new GamePlayer(game7, player1, gamePlayerCreationDate14);
			gamePlayerRepository.save(gamePlayer14);*/
            Date gamePlayerCreationDate15 = new Date();
            GamePlayer gamePlayer15 = new GamePlayer(game8, player3, gamePlayerCreationDate15);
            gamePlayerRepository.save(gamePlayer15);
            Date gamePlayerCreationDate16 = new Date();
            GamePlayer gamePlayer16 = new GamePlayer(game8, player4, gamePlayerCreationDate16);
            gamePlayerRepository.save(gamePlayer16);


            //Ships

            //Ship Locations
            Set<String> locationShip1 = new HashSet(Arrays.asList("H2", "H3", "H4"));
            Set<String> locationShip2 = new HashSet(Arrays.asList("E1", "F1", "G1"));
            Set<String> locationShip3 = new HashSet(Arrays.asList("B4", "B5"));
            Set<String> locationShip4 = new HashSet(Arrays.asList("B5", "C5", "D5"));
            Set<String> locationShip5 = new HashSet(Arrays.asList("F1", "F2"));
            Set<String> locationShip7 = new HashSet(Arrays.asList("C6", "C7"));
            Set<String> locationShip8 = new HashSet(Arrays.asList("A2", "A3", "A4"));
            Set<String> locationShip9 = new HashSet(Arrays.asList("G6", "H6"));

            //Game 1 player 1

            Ship ship1 = new Ship("Destroyer", gamePlayer1, locationShip1);
            shipRepository.save(ship1);
            Ship ship2 = new Ship("Submarine", gamePlayer1, locationShip2);
            shipRepository.save(ship2);
            Ship ship3 = new Ship("Patrol Boat", gamePlayer1, locationShip3);
            shipRepository.save(ship3);

            //Game 1 player 2

            Ship ship4 = new Ship("Destroyer", gamePlayer2, locationShip4);
            shipRepository.save(ship4);
            Ship ship5 = new Ship("Patrol Boat", gamePlayer2, locationShip5);
            shipRepository.save(ship5);

            //Game 2 player 1

            Ship ship6 = new Ship("Destroyer", gamePlayer3, locationShip4);
            shipRepository.save(ship6);
            Ship ship7 = new Ship("Patrol Boat", gamePlayer3, locationShip7);
            shipRepository.save(ship7);

            //Game 2 player 2

            Ship ship8 = new Ship("Submarine", gamePlayer4, locationShip8);
            shipRepository.save(ship8);
            Ship ship9 = new Ship("Patrol Boat", gamePlayer4, locationShip9);
            shipRepository.save(ship9);

            //Game 3 player 1

            Ship ship10 = new Ship("Destroyer", gamePlayer5, locationShip4);
            shipRepository.save(ship10);
            Ship ship11 = new Ship("Patrol Boat", gamePlayer5, locationShip7);
            shipRepository.save(ship11);

            //Game 3 player 2

            Ship ship12 = new Ship("Submarine", gamePlayer6, locationShip8);
            shipRepository.save(ship12);
            Ship ship13 = new Ship("Patrol Boat", gamePlayer6, locationShip9);
            shipRepository.save(ship13);

            //Game 4 player 1

            Ship ship14 = new Ship("Destroyer", gamePlayer7, locationShip4);
            shipRepository.save(ship14);
            Ship ship15 = new Ship("Patrol Boat", gamePlayer7, locationShip7);
            shipRepository.save(ship15);

            //Game 4 player 2

            Ship ship16 = new Ship("Submarine", gamePlayer8, locationShip8);
            shipRepository.save(ship16);
            Ship ship17 = new Ship("Patrol Boat", gamePlayer8, locationShip9);
            shipRepository.save(ship17);

            //Game 5 player 1

            Ship ship18 = new Ship("Destroyer", gamePlayer9, locationShip4);
            shipRepository.save(ship18);
            Ship ship19 = new Ship("Patrol Boat", gamePlayer9, locationShip7);
            shipRepository.save(ship15);

            //Game 5 player 2

            Ship ship20 = new Ship("Submarine", gamePlayer10, locationShip8);
            shipRepository.save(ship20);
            Ship ship21 = new Ship("Patrol Boat", gamePlayer10, locationShip9);
            shipRepository.save(ship21);

            //Game 6 player 1

            Ship ship22 = new Ship("Destroyer", gamePlayer11, locationShip4);
            shipRepository.save(ship22);
            Ship ship23 = new Ship("Patrol Boat", gamePlayer11, locationShip7);
            shipRepository.save(ship23);

            //Game 8 player 1

            Ship ship24 = new Ship("Destroyer", gamePlayer15, locationShip4);
            shipRepository.save(ship24);
            Ship ship25 = new Ship("Patrol Boat", gamePlayer15, locationShip7);
            shipRepository.save(ship25);

            //Game 8 player 2

            Ship ship26 = new Ship("Submarine", gamePlayer16, locationShip8);
            shipRepository.save(ship26);
            Ship ship27 = new Ship("Patrol Boat", gamePlayer16, locationShip9);
            shipRepository.save(ship27);

            //SALVOS

            Set<String> salvoLocation1 = new HashSet(Arrays.asList("B5", "C5", "F1"));
            Set<String> salvoLocation2 = new HashSet(Arrays.asList("B4", "B5", "B6"));
            Set<String> salvoLocation3 = new HashSet(Arrays.asList("F2", "D5"));
            Set<String> salvoLocation4 = new HashSet(Arrays.asList("E1", "H3", "A2"));
            Set<String> salvoLocation5 = new HashSet(Arrays.asList("A2", "A4", "G6"));
            Set<String> salvoLocation6 = new HashSet(Arrays.asList("B5", "D5", "C7"));
            Set<String> salvoLocation7 = new HashSet(Arrays.asList("A3", "H6"));
            Set<String> salvoLocation8 = new HashSet(Arrays.asList("C5", "C6"));
            Set<String> salvoLocation9 = new HashSet(Arrays.asList("G6", "H6", "A4"));
            Set<String> salvoLocation10 = new HashSet(Arrays.asList("H1", "H2", "H3"));
            Set<String> salvoLocation11 = new HashSet(Arrays.asList("A2", "A3", "D8"));
            Set<String> salvoLocation12 = new HashSet(Arrays.asList("E1", "F2", "G3"));
            Set<String> salvoLocation13 = new HashSet(Arrays.asList("A3", "A4", "F7"));
            Set<String> salvoLocation14 = new HashSet(Arrays.asList("B5", "C6", "H1"));
            Set<String> salvoLocation15 = new HashSet(Arrays.asList("A2", "G6", "H6"));
            Set<String> salvoLocation16 = new HashSet(Arrays.asList("C5", "C7", "D5"));
            Set<String> salvoLocation17 = new HashSet(Arrays.asList("A1", "A2", "A3"));
            Set<String> salvoLocation18 = new HashSet(Arrays.asList("B5", "B6", "C7"));
            Set<String> salvoLocation19 = new HashSet(Arrays.asList("G6", "G7", "G8"));
            Set<String> salvoLocation20 = new HashSet(Arrays.asList("C6", "D6", "E6"));
            Set<String> salvoLocation21 = new HashSet(Arrays.asList("H1", "H8"));

            //Game 1

            Salvo salvo1 = new Salvo(gamePlayer1, 1, salvoLocation1);
            salvoRepository.save(salvo1);
            Salvo salvo2 = new Salvo(gamePlayer2, 1, salvoLocation2);
            salvoRepository.save(salvo2);
            Salvo salvo3 = new Salvo(gamePlayer1, 2, salvoLocation3);
            salvoRepository.save(salvo3);
            Salvo salvo4 = new Salvo(gamePlayer2, 2, salvoLocation4);
            salvoRepository.save(salvo4);

            //Game 2

            Salvo salvo5 = new Salvo(gamePlayer3, 1, salvoLocation5);
            salvoRepository.save(salvo5);
            Salvo salvo6 = new Salvo(gamePlayer4, 1, salvoLocation6);
            salvoRepository.save(salvo6);
            Salvo salvo7 = new Salvo(gamePlayer3, 2, salvoLocation7);
            salvoRepository.save(salvo7);
            Salvo salvo8 = new Salvo(gamePlayer4, 2, salvoLocation8);
            salvoRepository.save(salvo8);

            //Game 3

            Salvo salvo9 = new Salvo(gamePlayer5, 1, salvoLocation9);
            salvoRepository.save(salvo9);
            Salvo salvo10 = new Salvo(gamePlayer6, 1, salvoLocation10);
            salvoRepository.save(salvo10);
            Salvo salvo11 = new Salvo(gamePlayer5, 2, salvoLocation11);
            salvoRepository.save(salvo11);
            Salvo salvo12 = new Salvo(gamePlayer6, 2, salvoLocation12);
            salvoRepository.save(salvo12);

            //Game 4

            Salvo salvo13 = new Salvo(gamePlayer7, 1, salvoLocation13);
            salvoRepository.save(salvo13);
            Salvo salvo14 = new Salvo(gamePlayer8, 1, salvoLocation14);
            salvoRepository.save(salvo14);
            Salvo salvo15 = new Salvo(gamePlayer7, 2, salvoLocation15);
            salvoRepository.save(salvo15);
            Salvo salvo16 = new Salvo(gamePlayer8, 2, salvoLocation16);
            salvoRepository.save(salvo16);

            //Game 5

            Salvo salvo17 = new Salvo(gamePlayer9, 1, salvoLocation17);
            salvoRepository.save(salvo17);
            Salvo salvo18 = new Salvo(gamePlayer10, 1, salvoLocation18);
            salvoRepository.save(salvo18);
            Salvo salvo19 = new Salvo(gamePlayer9, 2, salvoLocation19);
            salvoRepository.save(salvo19);
            Salvo salvo20 = new Salvo(gamePlayer10, 2, salvoLocation20);
            salvoRepository.save(salvo20);
            Salvo salvo21 = new Salvo(gamePlayer10, 3, salvoLocation21);
            salvoRepository.save(salvo21);

            //SCORES

            float win = 1;
            float tie = (float) 0.5;
            float lose = 0;

            Score score1 = new Score(game1, player1, win, date);
            Score score2 = new Score(game1, player2, lose, date);
            Score score3 = new Score(game2, player2, tie, date);
            Score score4 = new Score(game2, player3, tie, date);
            Score score5 = new Score(game3, player3, win, date);
            Score score6 = new Score(game3, player1, lose, date);
            scoreRepository.save(score1);
            scoreRepository.save(score2);
            scoreRepository.save(score3);
            scoreRepository.save(score4);
            scoreRepository.save(score5);
            scoreRepository.save(score6);

            //scoreG1P1 score game 1 player 1
            //Game1
            Score scoreG1P1 = new Score(game1, player1, 1.0);
            scoreRepository.save(scoreG1P1);
            Score scoreG1P2 = new Score(game1, player2, 0.0);
            scoreRepository.save(scoreG1P2);

            //Game2
            Score scoreG2P1 = new Score(game2, player1, 0.5);
            scoreRepository.save(scoreG2P1);
            Score scoreG2P2 = new Score(game2, player2, 0.5);
            scoreRepository.save(scoreG2P2);

            //Game3
            Score scoreG3P1 = new Score(game3, player1, 1.0);
            scoreRepository.save(scoreG3P1);
            Score scoreG3P2 = new Score(game3, player2, 0.0);
            scoreRepository.save(scoreG3P2);

            //Game4
            Score scoreG4P1 = new Score(game4, player1, 0.5);
            scoreRepository.save(scoreG4P1);
            Score scoreG4P2 = new Score(game4, player2, 0.5);
            scoreRepository.save(scoreG4P2);

        };
    }
}