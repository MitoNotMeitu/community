create table notification
(
    id         bigint auto_increment,
    notifier   bigint            not null,
    receiver   bigint            not null,
    outerId    bigint            not null,
    type       INTEGER           not null,
    gmt_create bigint            not null,
    status     INTEGER default 0 not null,
    constraint notification_pk
        primary key (id)
);

