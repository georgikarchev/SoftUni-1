package web.beans;


import domain.models.service.HeroServiceModel;
import service.HeroService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class HeroDetailBean {
    private HeroService heroService;

    public HeroDetailBean() {
    }

    @Inject
    public HeroDetailBean(HeroService heroService) {
        this.heroService = heroService;
    }

    public HeroServiceModel getHero(String id) {
        return this.heroService.getHeroById(id);
    }
}
