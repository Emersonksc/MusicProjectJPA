
CREATE TABLE emotion
(
    id                 SMALLINT    NOT NULL,
    created_by         INT         NULL,
    created_date       datetime    NULL,
    last_modified_by   INT         NULL,
    last_modified_date datetime    NULL,
    name               VARCHAR(30) NULL,
    CONSTRAINT pk_emotion PRIMARY KEY (id)
);

CREATE TABLE emotion_musics
(
    emotion_id SMALLINT NOT NULL,
    musics_id  INT      NOT NULL,
    CONSTRAINT pk_emotion_musics PRIMARY KEY (emotion_id, musics_id)
);

CREATE TABLE instrument
(
    id                 SMALLINT    NOT NULL,
    created_by         INT         NULL,
    created_date       datetime    NULL,
    last_modified_by   INT         NULL,
    last_modified_date datetime    NULL,
    name               VARCHAR(50) NOT NULL,
    CONSTRAINT pk_instrument PRIMARY KEY (id)
);

CREATE TABLE music
(
    id   INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(100)       NOT NULL,
    url  VARCHAR(256)       NOT NULL,
    CONSTRAINT pk_music PRIMARY KEY (id)
);

CREATE TABLE music_instrument
(
    instrument_id SMALLINT NOT NULL,
    music_id      INT      NOT NULL,
    CONSTRAINT pk_music_instrument PRIMARY KEY (instrument_id, music_id)
);

CREATE TABLE music_music_type
(
    music_id      INT      NOT NULL,
    music_type_id SMALLINT NOT NULL,
    CONSTRAINT pk_music_music_type PRIMARY KEY (music_id, music_type_id)
);

CREATE TABLE music_sheet_music
(
    music_id       INT NOT NULL,
    sheet_music_id INT NOT NULL,
    CONSTRAINT pk_music_sheet_music PRIMARY KEY (music_id, sheet_music_id)
);

CREATE TABLE music_type
(
    id                 SMALLINT    NOT NULL,
    created_by         INT         NULL,
    created_date       datetime    NULL,
    last_modified_by   INT         NULL,
    last_modified_date datetime    NULL,
    name               VARCHAR(30) NOT NULL,
    CONSTRAINT pk_music_type PRIMARY KEY (id)
);

CREATE TABLE note
(
    id                 INT           NOT NULL,
    created_by         INT           NULL,
    created_date       datetime      NULL,
    last_modified_by   INT           NULL,
    last_modified_date datetime      NULL,
    note               VARCHAR(2000) NULL,
    music_id           INT           NULL,
    CONSTRAINT pk_note PRIMARY KEY (id)
);

CREATE TABLE sheet_music
(
    id                 INT          NOT NULL,
    created_by         INT          NULL,
    created_date       datetime     NULL,
    last_modified_by   INT          NULL,
    last_modified_date datetime     NULL,
    sheet_url          VARCHAR(256) NULL,
    CONSTRAINT pk_sheet_music PRIMARY KEY (id)
);

ALTER TABLE note
    ADD CONSTRAINT FK_NOTE_ON_MUSIC FOREIGN KEY (music_id) REFERENCES music (id);

ALTER TABLE emotion_musics
    ADD CONSTRAINT fk_emomus_on_emotion FOREIGN KEY (emotion_id) REFERENCES emotion (id);

ALTER TABLE emotion_musics
    ADD CONSTRAINT fk_emomus_on_music FOREIGN KEY (musics_id) REFERENCES music (id);

ALTER TABLE music_instrument
    ADD CONSTRAINT fk_musins_on_instrument FOREIGN KEY (instrument_id) REFERENCES instrument (id);

ALTER TABLE music_instrument
    ADD CONSTRAINT fk_musins_on_music FOREIGN KEY (music_id) REFERENCES music (id);

ALTER TABLE music_music_type
    ADD CONSTRAINT fk_musmustyp_on_music FOREIGN KEY (music_id) REFERENCES music (id);

ALTER TABLE music_music_type
    ADD CONSTRAINT fk_musmustyp_on_music_type FOREIGN KEY (music_type_id) REFERENCES music_type (id);

ALTER TABLE music_sheet_music
    ADD CONSTRAINT fk_musshemus_on_music FOREIGN KEY (music_id) REFERENCES music (id);

ALTER TABLE music_sheet_music
    ADD CONSTRAINT fk_musshemus_on_sheet_music FOREIGN KEY (sheet_music_id) REFERENCES sheet_music (id);

    create table authority (
       id integer not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table emotion 
       add column created_by_id integer;

    alter table emotion 
       add column last_modified_by_id integer;

    alter table emotion 
       add column user_id integer not null;

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB;

    insert into hibernate_sequence values ( 1 );

    alter table instrument 
       add column created_by_id integer;

    alter table instrument 
       add column last_modified_by_id integer;

    alter table instrument 
       add column user_id integer not null;

    alter table music_type 
       add column created_by_id integer;

    alter table music_type 
       add column last_modified_by_id integer;

    alter table music_type 
       add column user_id integer not null;

    alter table note 
       add column created_by_id integer;

    alter table note 
       add column last_modified_by_id integer;

    alter table note 
       add column user_id integer not null;

    alter table sheet_music 
       add column created_by_id integer;

    alter table sheet_music 
       add column last_modified_by_id integer;

    alter table sheet_music 
       add column user_id integer not null;

    create table user (
       id integer not null,
        password varchar(255),
        enabled bit,
        primary key (id)
    ) engine=InnoDB;

    create table user_authority (
       user_id integer not null,
        authority_id integer not null,
        primary key (user_id, authority_id)
    ) engine=InnoDB;

    alter table emotion 
       add constraint FKb9tvajc7evyx6jj2jrwpd8ux9 
       foreign key (created_by_id) 
       references user (id);

    alter table emotion 
       add constraint FKj8nfkh3clo00ll59gyodkmg4m 
       foreign key (last_modified_by_id) 
       references user (id);

    alter table emotion 
       add constraint FKsi20n9shb9iik3bw13yb4y2py 
       foreign key (user_id) 
       references user (id);

    alter table instrument 
       add constraint FKodctwpbqfau8k1ajkmmeyyh7i 
       foreign key (created_by_id) 
       references user (id);

    alter table instrument 
       add constraint FK9cejf22c0kfngvdvh4dpllfa0 
       foreign key (last_modified_by_id) 
       references user (id);

    alter table instrument 
       add constraint FK4b391w3k1vnyqey4x7msukei6 
       foreign key (user_id) 
       references user (id);

    alter table music_type 
       add constraint FKo8bq52dud9w6md0a5csn039a6 
       foreign key (created_by_id) 
       references user (id);

    alter table music_type 
       add constraint FKc2ugek8qnpsa0ilaxmkooxj2b 
       foreign key (last_modified_by_id) 
       references user (id);

    alter table music_type 
       add constraint FK1mig32qsgsn3hct5w3rfhde5f 
       foreign key (user_id) 
       references user (id);

    alter table note 
       add constraint FKmgskgty7exr04uckybhwtontj 
       foreign key (created_by_id) 
       references user (id);

    alter table note 
       add constraint FKi62u95jyyvnowwyq8n1vwkm22 
       foreign key (last_modified_by_id) 
       references user (id);

    alter table note 
       add constraint FKmoddtnuw3yy6ct34xnw6u0boh 
       foreign key (user_id) 
       references user (id);

    alter table sheet_music 
       add constraint FKoyrtll2unjehg0fbwm85li7mx 
       foreign key (created_by_id) 
       references user (id);

    alter table sheet_music 
       add constraint FKmwf8mcajnfhnjskvau84xoao6 
       foreign key (last_modified_by_id) 
       references user (id);

    alter table sheet_music 
       add constraint FKtnpcvl45snt48uqulsg77m8kk 
       foreign key (user_id) 
       references user (id);

    alter table user_authority 
       add constraint FKgvxjs381k6f48d5d2yi11uh89 
       foreign key (authority_id) 
       references authority (id);

    alter table user_authority 
       add constraint FKpqlsjpkybgos9w2svcri7j8xy 
       foreign key (user_id) 
       references user (id);
