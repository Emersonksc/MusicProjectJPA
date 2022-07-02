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
@Entity(name = "SheetMusic1")
@Table(name = "sheet_music")
public class SheetMusic extends AbstractAuditable<User, Integer> implements Serializable {
    private static final long serialVersionUID = 747340847721953265L;

    @Column(name = "sheet_url", length = 256)
    private String sheetUrl;

    @ManyToMany
    @JoinTable(name = "music_sheet_music",
            joinColumns = @JoinColumn(name = "sheet_music_id"),
            inverseJoinColumns = @JoinColumn(name = "music_id"))
    private Set<Music> music = new LinkedHashSet<>();


}