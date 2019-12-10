package models.players;

import common.ConstantMessages;
import models.cards.interfaces.Card;
import models.players.interfaces.Player;
import repositories.CardRepositoryImpl;
import repositories.interfaces.CardRepository;

public abstract class BasePlayer implements Player {
    private String username;
    private int health;
    private CardRepository cardRepository;
    private boolean isDead;



    protected BasePlayer(CardRepository cardRepository, String username, int health) {
        this.setUsername(username);
        this.setHealth(health);
        this.cardRepository = cardRepository;
        this.isDead = false;
    }


    public void setUsername(String username) {
        if(username == null || username.equals("")){
            throw new IllegalArgumentException("Player's username cannot be null or an empty string.");
        }

        this.username = username;
    }

    @Override
    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int healthPoints) {
        if(healthPoints < 0){
            this.health = 0;
            throw new IllegalArgumentException("Player's health bonus cannot be less than zero.");
        }

        this.health = healthPoints;
    }

    @Override
    public boolean isDead() {
        if(this.health <= 0){
            return true;
        }

        return false;
    }

    @Override
    public void takeDamage(int damagePoints) {
        if(damagePoints < 0){
            throw new IllegalArgumentException("Damage points cannot be less than zero.");
        }
        this.health -= damagePoints;
    }

    @Override
    public int getTotalDamage(){
        int sum = 0;

        for (Card card: this.cardRepository.getCards()) {
            sum += card.getDamagePoints();
        }
        return sum;
    }

    @Override
    public int getTotalHealth(){
        int sum = 0;

        for (Card card: this.cardRepository.getCards()) {
            sum += card.getHealthPoints();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format(ConstantMessages.PLAYER_REPORT_INFO, this.getUsername()
        , this.getHealth(), this.cardRepository.getCount()));
        sb.append(System.lineSeparator());

        for (Card card:this.cardRepository.getCards()) {
            sb.append(card.toString());
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }


}
