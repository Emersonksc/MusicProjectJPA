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
@Entity(name = "MusicType")
@Table(name = "music_type")
public class MusicType extends AbstractAuditable<User, Short> implements Serializable {
    private static final long serialVersionUID = -5118124020308262596L;

    @Column(name = "name", nullable = false, length = 30)
    private String name;


    @ManyToMany(mappedBy = "musicTypes", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Set<Music> music = new LinkedHashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MusicType)) return false;
        if (!super.equals(o)) return false;

        MusicType musicType = (MusicType) o;

        if (name != null ? !name.equals(musicType.name) : musicType.name != null) return false;
        return music != null ? music.equals(musicType.music) : musicType.music == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (music != null ? music.hashCode() : 0);
        return result;
    }
}