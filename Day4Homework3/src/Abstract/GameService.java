package Abstract;

import Entities.Game;

public interface GameService {
    void addGame(Game game);
    void addGame(Game[] _games);
    void deleteGame(Game game);
    void getGames();
    void updateGame(Game game,String gameName,String gameType , double gamePrice);
}
