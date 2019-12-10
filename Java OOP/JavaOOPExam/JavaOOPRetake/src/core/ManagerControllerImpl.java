package core;

import common.ConstantMessages;
import core.interfaces.ManagerController;
import models.battleFields.BattleFieldImpl;
import models.battleFields.interfaces.Battlefield;
import models.cards.MagicCard;
import models.cards.TrapCard;
import models.cards.interfaces.Card;
import models.players.Advanced;
import models.players.Beginner;
import models.players.interfaces.Player;
import repositories.CardRepositoryImpl;
import repositories.PlayerRepositoryImpl;
import repositories.interfaces.CardRepository;
import repositories.interfaces.PlayerRepository;


public class ManagerControllerImpl implements ManagerController {
    private CardRepository cardRepository;
    private PlayerRepository playerRepository;
    private Battlefield battlefield;

    public ManagerControllerImpl() {
       this.cardRepository = new CardRepositoryImpl();
       this.playerRepository= new PlayerRepositoryImpl();
       this.battlefield = new BattleFieldImpl();
    }

    @Override
    public String addPlayer(String type, String username) {
        try {
            if (type.equals("Beginner")) {
                Player player = new Beginner(new CardRepositoryImpl(),username);
                playerRepository.add(player);
            } else {
                Player player = new Advanced(new CardRepositoryImpl(),username);
                playerRepository.add(player);
            }

            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER, type, username);

        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }

    @Override
    public String addCard(String type, String name) {
        try {
            Card card;

            if(type.equals("Magic")){
                card = new MagicCard(name);
                cardRepository.add(card);
            }else {
                card = new TrapCard(name);
                cardRepository.add(card);
            }

            return  String.format(ConstantMessages.SUCCESSFULLY_ADDED_CARD, type, name);
        }catch (IllegalArgumentException ex){
            return ex.getMessage();
        }

    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        try{


                    Card cardToAdd = this.cardRepository.getCardMap().get(cardName);
                    this.playerRepository.getPlayerMap().get(username).getCardRepository().add(cardToAdd);

            return  String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_WITH_CARDS, cardName, username);

        }catch (IllegalArgumentException ex){
            return ex.getMessage();
        }

    }

    @Override
    public String fight(String attackUser, String enemyUser) {
        try{
            Player attackPlayer = this.playerRepository.getPlayerMap().get(attackUser);
            Player enemyPlayer = this.playerRepository.getPlayerMap().get(enemyUser);
            battlefield.fight(attackPlayer, enemyPlayer);


            if(attackPlayer.getHealth() < 0){
                attackPlayer.setHealth(0);
            }else if(enemyPlayer.getHealth() < 0){
                enemyPlayer.setHealth(0);
            }
            return  String.format(ConstantMessages.FIGHT_INFO,
                    this.playerRepository.getPlayerMap().get(attackUser).getHealth(),
                    this.playerRepository.getPlayerMap().get(enemyUser).getHealth());
        }catch (IllegalArgumentException ex){
            return ex.getMessage();
        }
    }

    @Override
    public String report() {
        return playerRepository.toString();
    }
}
