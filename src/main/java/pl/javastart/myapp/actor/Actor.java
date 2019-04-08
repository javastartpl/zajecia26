package pl.javastart.myapp.actor;

import pl.javastart.myapp.Role;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "actor")
    private Set<Role> movieActors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getMovieActors() {
        return movieActors;
    }

    public void setMovieActors(Set<Role> movieActors) {
        this.movieActors = movieActors;
    }
}
