package com.example.musicprojectjpa.persistence.model.business.general;

import com.example.musicprojectjpa.persistence.model.business.specific.Music;
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
@Entity(name = "Emotion")
@Table(name = "emotion")
public class Emotion extends AbstractAuditable<User, Short> implements Serializable {
    private static final long serialVersionUID = -8044361103882563712L;

    @Column(name = "name", length = 30)
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "emotion_musics",
            joinColumns = @JoinColumn(name = "emotion_id"),
            inverseJoinColumns = @JoinColumn(name = "musics_id"))
    private Set<Music> musics = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Emotion)) return false;
        if (!super.equals(o)) return false;

        Emotion emotion = (Emotion) o;

        if (!name.equals(emotion.name)) return false;
        return musics.equals(emotion.musics);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + musics.hashCode();
        return result;
    }
}