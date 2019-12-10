package web.beans;

import domain.models.binding.HeroCreateBindingModel;
import domain.models.service.HeroServiceModel;
import org.modelmapper.ModelMapper;
import service.HeroService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CreateHeroBean  extends BaseBean{
    private HeroCreateBindingModel heroCreateBindingModel;
    private HeroService heroService;
    private ModelMapper modelMapper;

    public CreateHeroBean() {
    }

    @Inject
    public CreateHeroBean(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }


    @PostConstruct
    public void init() {
        this.heroCreateBindingModel = new HeroCreateBindingModel();
    }

    public HeroCreateBindingModel getHeroCreateBindingModel() {
        return heroCreateBindingModel;
    }

    public void setHeroCreateBindingModel(HeroCreateBindingModel heroCreateBindingModel) {
        this.heroCreateBindingModel = heroCreateBindingModel;
    }

    public void createHero() {
        this.heroService.createHero(
                this.modelMapper.map(this.heroCreateBindingModel, HeroServiceModel.class));

        this.redirect("/home");
    }
}
