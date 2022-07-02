package com.example.musicprojectjpa.persistence.model.general;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@AllArgsConstructor
@NoArgsConstructor
@Data
public final class Authority {

    private int id;

    private SimpleGrantedAuthority authority;
}
