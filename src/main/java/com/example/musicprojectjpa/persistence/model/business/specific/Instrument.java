package com.example.musicprojectjpa.persistence.model.business.specific;

import com.example.musicprojectjpa.persistence.model.general.User;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = "Instrument")
@Table(name = "instrument")
public class Instrument extends AbstractAuditable<User, Short> implements Serializable {
    private static final long serialVersionUID = -4564977796597341329L;

    @Column(name = "name", length = 50, nullable = false)
    private String name;


    @ManyToMany(mappedBy = "instruments", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Set<Music> musics = new LinkedHashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instrument)) return false;
        if (!super.equals(o)) return false;

        Instrument that = (Instrument) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return musics != null ? musics.equals(that.musics) : that.musics == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (musics != null ? musics.hashCode() : 0);
        return result;
    }
}