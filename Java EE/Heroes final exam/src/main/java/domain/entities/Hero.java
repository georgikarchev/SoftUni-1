package domain.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "heroes")
public class Hero {
    private String id;
    private String name;
    private String classHero;
    private int level;

    public Hero() {
    }

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(
            name = "uuid-string",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false,  updatable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "class_hero", nullable = false,  updatable = false)
    public String getClassHero() {
        return classHero;
    }

    public void setClassHero(String classHero) {
        this.classHero = classHero;
    }

    @Column(name = "level", nullable = false,  updatable = false)
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
