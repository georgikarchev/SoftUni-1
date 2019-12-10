package repositories.interfaces;

import models.cards.interfaces.Card;
import java.util.List;
import java.util.Map;

public interface CardRepository {
    int getCount();

    List<Card> getCards();

    void add(Card card);

    boolean remove(Card card);

    Card find(String name);

    Map<String, Card> getCardMap();
}
