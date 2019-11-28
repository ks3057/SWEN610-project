package com.webcheckers.appl;

import com.webcheckers.helper.Tuple;
import com.webcheckers.model.Game;
import com.webcheckers.model.Human;
import lombok.Data;

import java.util.*;

@Data
public class WebCheckersController {

    //number of games being played
    public static int numberOfGames;
    //map of username and game
    private Map<String, Game> userGame = new HashMap<>();
    //users waiting for game {will not be more than one}
    private Queue<Human> usersWaiting = new LinkedList<>();
    //map of game wrt gameid
    private Map<Integer, Game> allGames = new HashMap();
    //list of all users
    private List<Human> allUsers = new ArrayList<>();
    //check if user's game has started. this will be set to true when the opponent gets assigned
    private Map<String, Boolean> gameStarted = new HashMap<>();


    public Tuple getOpponent(String username){
        if(usersWaiting.isEmpty()) return null;
        if(usersWaiting.peek().getUserName().equals(username)) return null;
        Human h = usersWaiting.poll();
        //set to true because their games have started
        gameStarted.put(h.getUserName(), true);
        gameStarted.put(username, true);
        return new Tuple(h, userGame.get(h.getUserName()));
    }

    public void addPlayerAndGame(Tuple t){
        //add player to wait list
        allUsers.add(t.human);
        usersWaiting.add(t.human);
        gameStarted.put(t.human.getUserName(), false);
        userGame.put(t.human.getUserName(), t.game);
        allGames.put(t.game.getGameID(), t.game);
        numberOfGames++;
    }

    public void addPlayerToGame(Human human, int gameid){
        //add second player to the game
        Game game = allGames.get(gameid);
        game.setPlayerTwo(human);
        allGames.put(gameid, game);
        userGame.put(human.getUserName(), game);
    }

    public boolean playerHasGame(String username){
        return gameStarted.get(username);
    }





}
