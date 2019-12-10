package web.beans;

import domain.models.service.HeroServiceModel;
import service.HeroService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class HeroListBean {
    private  HeroService heroService;
    private List<HeroServiceModel> heroes;


    public HeroListBean() {
    }

    @Inject
    public HeroListBean(HeroService heroService) {
        this.heroService = heroService;
    }

    @PostConstruct
    public void init() {
        this.setHeroes(this.heroService.getAllHeroesForHome());
        this.getHeroes().forEach(x -> x.setClassHero(x.getClassHero().toLowerCase()));
    }


    public List<HeroServiceModel> getHeroes() {
        return this.heroes;
    }

    public void setHeroes(List<HeroServiceModel> heroes) {
        this.heroes = heroes;
    }
}
