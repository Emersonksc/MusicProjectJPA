package com.example.musicprojectjpa.persistence.model.business.general;

import com.example.musicprojectjpa.persistence.model.business.specific.Music;
import com.example.musicprojectjpa.persistence.model.general.User;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = "Note")
@Table(name = "note")
public class Note extends AbstractAuditable<User, Integer> implements Serializable {
    private static final long serialVersionUID = -434079233056200457L;

    @Column(name = "note", length = 2000)
    private String note;


    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "music_id")
    private Music music;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Note note = (Note) o;
        return getId() != null && Objects.equals(getId(), note.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}