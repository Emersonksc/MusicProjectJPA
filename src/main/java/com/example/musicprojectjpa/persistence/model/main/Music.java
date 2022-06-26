package com.example.musicprojectjpa.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Table;

import java.util.ArrayList;

/**
 * @author Emersonksc
 * Article POJO for ORM in persistence layer
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(appliesTo = "music")
public class Music {

//  Do I use Int or Integer as the ID type？
//  id is snowflake ID

    private int id;
    private String musicUrl;
    private String sheetUrl;
    private String name;
    private int score;

    private int muiscTypeId;
    private int albunId;
    private int authorId;



}