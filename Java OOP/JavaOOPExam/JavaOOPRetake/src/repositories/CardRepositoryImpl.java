package repositories;

import models.cards.interfaces.Card;
import repositories.interfaces.CardRepository;

import java.util.*;
import java.util.stream.Collectors;

public class CardRepositoryImpl implements CardRepository {
    private Map<String, Card> cardMap;

    public CardRepositoryImpl() {
        this.cardMap = new LinkedHashMap<>();
    }

    @Override
    public Map<String, Card> getCardMap() {
        return cardMap;
    }

    @Override
    public int getCount() {
        return this.cardMap.size();
    }

    @Override
    public List<Card> getCards() {
        return new ArrayList<>(this.cardMap.values());
    }

    @Override
    public void add(Card card) {
        if(card == null){
            throw new IllegalArgumentException("Card cannot be null!");
        }else if(this.cardMap.containsKey(card.getName())){
            throw new IllegalArgumentException(String.format("Card %s already exists!",
                    card.getName()));
        }

        this.cardMap.put(card.getName(), card);
    }

    @Override
    public boolean remove(Card card) {
        if(card == null){
            throw  new IllegalArgumentException("Card cannot be null!");
        }

        if(this.cardMap.containsKey(card.getName())){
            this.cardMap.remove(card.getName());
            return true;
        }

        return false;
    }

    @Override
    public Card find(String name) {
        return this.cardMap.get(name);
    }
}
