package com.example.musicprojectjpa.persistence.model.general;

import com.example.musicprojectjpa.persistence.model.business.general.Emotion;
import com.example.musicprojectjpa.persistence.model.business.general.Note;
import com.example.musicprojectjpa.persistence.model.business.specific.Instrument;
import com.example.musicprojectjpa.persistence.model.business.specific.MusicType;
import com.example.musicprojectjpa.persistence.model.business.specific.SheetMusic;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.Access;
import javax.persistence.AccessType;
import java.util.Collection;
import java.util.Set;

@Setter
@Getter
@Access(AccessType.FIELD)
public class User extends org.springframework.security.core.userdetails.User {

    private final int id;

    private Set<Emotion> emotion;

    private Set<Instrument> instruments;

    private Set<MusicType> musicTypes;

    private Set<Note> notes;

    private Set<SheetMusic> sheetMusics;

    public User(int id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
    }

    public User(int id, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
    }
}
