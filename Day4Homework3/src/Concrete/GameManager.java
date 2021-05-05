package Concrete;

import Abstract.GameService;
import Entities.Customer;
import Entities.Game;

import java.util.ArrayList;
import java.util.List;

public class GameManager implements GameService {
    List<Game> games = new ArrayList<Game>();
    @Override
    public void addGame(Game game) {
        System.out.println("Game added : "+game.getName());
        games.add(game);
    }

    @Override
    public void addGame(Game[] _games) {
        for(Game game : _games)
        {
            System.out.println("Game added : "+game.getName());
            games.add(game);
        }
    }


    @Override
    public void deleteGame(Game game) {
        System.out.println("Game deleted : "+game.getName());
        games.remove(game);
    }

    @Override
    public void getGames() {
        System.out.println("Games");
        System.out.println("----------------------------");
        for (Game game:games) {
            System.out.println("Game name : "+game.getName());
            System.out.println("Game type : "+game.getType());
            System.out.println("Game price : "+game.getPrice() + " TRY");
            System.out.println("----------------------------");
        }
    }

    @Override
    public void updateGame(Game game,String gameName,String gameType , double gamePrice) {
        game.setName(gameName);
        game.setType(gameType);
        game.setPrice(gamePrice);
        System.out.println("Game modified : "+game.getName());
    }
}
