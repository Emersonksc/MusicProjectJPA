package com.example.musicprojectjpa.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MusicType {

    private short id;

    private String type;

    private LocalDateTime timeCreated;

    private LocalDateTime timeModified;

}
