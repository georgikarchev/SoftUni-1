package repositories.interfaces;

import models.players.interfaces.Player;

import java.util.List;
import java.util.Map;

public interface PlayerRepository {
    int getCount();

    List<Player> getPlayers();

    void add(Player player);

    boolean remove(Player player);

    Player find(String name);

    Map<String, Player> getPlayerMap();
}
