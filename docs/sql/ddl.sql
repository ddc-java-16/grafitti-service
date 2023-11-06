create sequence canvas_seq start with 1 increment by 50;
create table canvas
(
    canvas_id bigint not null,
    primary key (canvas_id)
);
