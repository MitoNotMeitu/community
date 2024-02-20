create table question
(
    id            INTEGER auto_increment,
    title         varchar(50),
    description   text,
    gmt_create    bigint,
    gmt_modified  bigint,
    creator       INTEGER,
    comment_count INTEGER default 0,
    view_count    INTEGER default 0,
    like_count    INTEGER default 0,
    tag           varchar(256),
    constraint question_pk
        primary key (id)
);

