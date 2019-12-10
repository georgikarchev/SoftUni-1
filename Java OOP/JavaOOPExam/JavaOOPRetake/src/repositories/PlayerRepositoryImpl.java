package repositories;

import common.ConstantMessages;
import models.players.interfaces.Player;
import repositories.interfaces.PlayerRepository;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerRepositoryImpl implements PlayerRepository {
    private Map<String, Player> playerMap;

    public PlayerRepositoryImpl() {
        this.playerMap = new LinkedHashMap<>();
    }

    @Override
    public Map<String, Player> getPlayerMap() {
        return playerMap;
    }

    @Override
    public int getCount() {
        return this.playerMap.size();
    }

    @Override
    public List<Player> getPlayers() {
        return new ArrayList<>(this.playerMap.values());
    }

    @Override
    public void add(Player player) {
        if(player == null){
            throw new IllegalArgumentException("Player cannot be null");
        }else if(this.playerMap.containsKey(player.getUsername())){
            throw new IllegalArgumentException(String.format("Player %s already exists!",
                    player.getUsername()));
        }

        this.playerMap.put(player.getUsername(), player);
    }

    @Override
    public boolean remove(Player player) {
        if(player == null){
            throw  new IllegalArgumentException("Player cannot be null");
        }

        if(this.playerMap.containsKey(player.getUsername())){
            this.playerMap.remove(player.getUsername());
            return true;
        }

        return false;
    }

    @Override
    public Player find(String name) {
            return this.playerMap.get(name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Player player: playerMap.values()) {
            sb.append(player.toString());
            sb.append(ConstantMessages.DEFAULT_REPORT_SEPARATOR);
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
