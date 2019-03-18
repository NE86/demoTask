create sequence hibernate_sequence start 1 increment 1;

create table user_info (
    id int8 not null,
    name varchar(2048),
    age int8,
    text varchar(2048),
    primary key (id)
);
