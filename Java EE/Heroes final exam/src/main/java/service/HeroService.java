package service;

import domain.models.service.HeroServiceModel;

import java.util.List;

public interface HeroService {
    HeroServiceModel getHeroByName(String name);
    HeroServiceModel getHeroById(String id);
    HeroServiceModel createHero(HeroServiceModel heroServiceModel);
    List<HeroServiceModel> getAllHeroes();
    List<HeroServiceModel> getAllHeroesForHome();
    void delete(String id);
}
