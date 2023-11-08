create sequence canvas_seq start with 1 increment by 50;
create table canvas
(
    canvas_id bigint not null,
    primary key (canvas_id)
);
create sequence canvas_seq start with 1 increment by 50;
create sequence tags_seq start with 1 increment by 50;
create sequence user_profile_seq start with 1 increment by 50;
create table canvas
(
    canvas_id integer                     not null,
    user_id   integer                     not null,
    created   timestamp(6) with time zone not null,
    bitmap    varchar(255),
    user_name varchar(255),
    primary key (canvas_id)
);
create table tags
(
    canvas_id integer                     not null,
    tag_id    integer                     not null,
    created   timestamp(6) with time zone not null,
    bitmap    varchar(255),
    primary key (tag_id)
);
create table user_profile
(
    created         timestamp(6) with time zone not null,
    modified        timestamp(6) with time zone not null,
    user_profile_id bigint                      not null,
    external_key    UUID                        not null unique,
    oauth_key       varchar(30)                 not null unique,
    display_name    varchar(255),
    primary key (user_profile_id)
);
