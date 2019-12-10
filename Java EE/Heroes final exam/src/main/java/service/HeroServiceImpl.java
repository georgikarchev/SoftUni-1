package service;

import domain.entities.Hero;
import domain.models.service.HeroServiceModel;
import org.modelmapper.ModelMapper;
import repository.HeroRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class HeroServiceImpl implements HeroService {
    private final HeroRepository heroRepository;
    private final ModelMapper modelMapper;
    private

    @Inject
    HeroServiceImpl(HeroRepository heroRepository, ModelMapper modelMapper) {
        this.heroRepository = heroRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public HeroServiceModel getHeroByName(String name) {
        return this.modelMapper.map(this.heroRepository.findByUsername(name), HeroServiceModel.class);
    }

    @Override
    public HeroServiceModel getHeroById(String id) {
        return this.modelMapper.map(this.heroRepository.findById(id), HeroServiceModel.class);
    }

    @Override
    public HeroServiceModel createHero(HeroServiceModel heroServiceModel) {
        return this.modelMapper.map(
                this.heroRepository
                        .save(this.modelMapper.map(heroServiceModel, Hero.class)),
                HeroServiceModel.class);
    }

    @Override
    public List<HeroServiceModel> getAllHeroes() {
        return this.heroRepository.findAll()
                .stream()
                .map(x -> this.modelMapper.map(x, HeroServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<HeroServiceModel> getAllHeroesForHome() {
        return this.heroRepository.findAllForHome()
                .stream()
                .map(x -> this.modelMapper.map(x, HeroServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        this.heroRepository.delete(id);
    }
}
