drop table if exists user_entity;

CREATE TABLE public.user_entity (
    id bigint not null PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);