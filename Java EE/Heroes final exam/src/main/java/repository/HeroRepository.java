package repository;

import domain.entities.Hero;

import java.util.List;

public interface HeroRepository extends GenericRepository<Hero, String>  {
    Hero findByUsername(String username);
    List<Hero> findAllForHome();
    void delete(String id);
}
