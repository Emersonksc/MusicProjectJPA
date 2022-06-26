package com.example.musicprojectjpa.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Instrument {

    private int id;

    private String name;

    private LocalDateTime timeCreated;

    private LocalDateTime timeModified;
}
