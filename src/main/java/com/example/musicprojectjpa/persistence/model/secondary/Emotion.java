package com.example.musicprojectjpa.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author Emersonksc
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(appliesTo = "music_emotion")
//When do I use an embedded object?
//Why do I consider it a new table not embedded the musicNote class. For scalability, because the emotion is not an attachment
// to musicNote.

public class Emotion {
    @Id
    private short id;
    @Column(name = "emotion")
    private String emotion;
    // TODO: 2022/06/22 Why do you use LocalDateTime?
    @Column(name = "gmt_created")
    private LocalDateTime timeCreated;
    @Column(name = "gmt_created")
    private LocalDateTime timeModified;

}
