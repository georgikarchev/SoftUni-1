package domain.models.service;

public class HeroServiceModel {
    private String id;
    private String name;
    private String classHero;
    private int level;

    public HeroServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassHero() {
        return classHero;
    }

    public void setClassHero(String classHero) {
        this.classHero = classHero;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
