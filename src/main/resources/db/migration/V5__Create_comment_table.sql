create table comment
(
    id           bigint auto_increment,
    parentId     bigint  not null,
    type         INTEGER not null,
    commentator  INTEGER not null,
    gmt_create   bigint  not null,
    gmt_modified bigint  not null,
    like_count   bigint default 0,
    constraint comment_pk
        primary key (id)
);