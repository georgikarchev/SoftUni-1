package repository;

import domain.entities.Hero;
import domain.entities.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class HeroRepositoryImpl extends BaseRepository implements HeroRepository{
    @Inject
    protected HeroRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Hero findByUsername(String username) {
        return this.executeTransaction((em) -> (Hero) em.createNativeQuery("SELECT * FROM heroes WHERE name = '" + username + "'", Hero.class)
                .getSingleResult());
    }

    @Override
    public List<Hero> findAllForHome() {
        return this.executeTransaction((em) -> em.createNativeQuery("SELECT * FROM heroes h ORDER BY h.level desc ", Hero.class)
                .getResultList());
    }
    @Override
    public void delete(String id) {
        this.executeTransaction((em) -> {
            em.createNativeQuery("DELETE FROM heroes WHERE id='" + id + "'").executeUpdate();
            return null;
        });
    }

    @Override
    public Hero save(Hero hero) {
        return this.executeTransaction((em) -> {
            em.persist(hero);
            return hero;
        });
    }

    @Override
    public List<Hero> findAll() {
        return this.executeTransaction((em) -> em.createNativeQuery("SELECT * FROM heroes", Hero.class)
                .getResultList());
    }

    @Override
    public Hero findById(String s) {
        return this.executeTransaction((em) -> (Hero) em.createNativeQuery("SELECT * FROM heroes WHERE id = '" + s + "'", Hero.class)
                .getSingleResult());
    }
}
