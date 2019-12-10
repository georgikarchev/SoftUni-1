package models.battleFields;

import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.players.interfaces.Player;

public class BattleFieldImpl implements Battlefield {
    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {
        if(attackPlayer.isDead() || enemyPlayer.isDead()){
            throw new IllegalArgumentException("Player is dead!");
        }

        makeChangesIfItsBeginner(attackPlayer);
        makeChangesIfItsBeginner(enemyPlayer);

        attackPlayer.setHealth(attackPlayer.getHealth() + attackPlayer.getTotalHealth());
        enemyPlayer.setHealth(enemyPlayer.getHealth() + enemyPlayer.getTotalHealth());

        while(!(attackPlayer.isDead() || enemyPlayer.isDead())){
            enemyPlayer.takeDamage(attackPlayer.getTotalDamage());

            if(!(enemyPlayer.isDead())){
                attackPlayer.takeDamage(enemyPlayer.getTotalDamage());
            }
        }




    }

    private void makeChangesIfItsBeginner(Player player){
        if(player.getClass().getSimpleName().equals("Beginner")){
            player.setHealth(player.getHealth() + 40);

            for (Card card: player.getCardRepository().getCards()) {
                card.setDamagePoints(card.getDamagePoints() + 30);
            }
        }
    }
}
