
create sequence canvas_seq start with 1 increment by 50;
create sequence point_seq start with 1 increment by 50;
create sequence tags_seq start with 1 increment by 50;
create sequence user_profile_seq start with 1 increment by 50;
create table canvas
(
    canvas_id    integer                     not null,
    created      timestamp(6) with time zone not null,
    user_id      bigint                      not null,
    external_key UUID                        not null unique,
    name         varchar(255)                not null unique,
    primary key (canvas_id)
);
create table point
(
    x        integer not null,
    y        integer not null,
    point_id bigint  not null,
    tag_id   bigint  not null,
    primary key (point_id)
);
create table tags
(
    canvas_id    integer                     not null,
    color        integer                     not null,
    stroke       integer                     not null,
    style        integer                     not null,
    created      timestamp(6) with time zone not null,
    tag_id       bigint                      not null,
    user_id      bigint                      not null,
    external_key UUID                        not null unique,
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
alter table canvas
    add constraint FKo5kw2gmav3f169wk0yvephwy9 foreign key (user_id) references user_profile;
alter table point
    add constraint FKapwnx67qe7kc43nl28nyqqy7d foreign key (tag_id) references tags;
alter table tags
    add constraint FK5x3x9cphvh3h9revmld3flm9y foreign key (canvas_id) references canvas;
alter table tags
    add constraint FKbv8mcqy80jc0qjtqu3tbcg6ed foreign key (user_id) references user_profile;
