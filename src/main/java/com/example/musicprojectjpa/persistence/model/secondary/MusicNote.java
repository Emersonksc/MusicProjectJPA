package com.example.musicprojectjpa.persistence.model;

import java.time.LocalDateTime;

public class MusicNote {
    private int id;
    private String sheetUrl;
    private LocalDateTime timeCreated;
    private LocalDateTime timeModified;

    private int musicId;
}
