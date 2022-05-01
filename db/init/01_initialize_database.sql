create
database slick_sample;

\c slick_sample;

create table users
(
    id         varchar                  not null
        constraint users_pk primary key,
    created_at timestamp with time zone not null
);

create table genders
(
    id   SERIAL      not null
        constraint genders_pk primary key,
    name varchar(20) not null
);

insert into genders(name)
values ('MALE');

insert into genders(name)
values ('FEMALE');

create table user_profiles
(
    id            varchar      not null
        constraint user_profiles_pk primary key,
    user_id       varchar      not null
        constraint fk_user_profiles_user_id_users
            references users (id),
    name          varchar(100) not null,
    email         varchar(255) not null,
    gender_id     int          not null
        constraint fk_user_profiles_gender_id_genders
            references genders (id),
    date_of_birth date         not null
);

create table user_memos
(
    id      varchar not null
        constraint user_memos_pk primary key,
    user_id varchar not null
        constraint fk_user_memos_user_id_users
            references users (id),
    memo    text    not null
);
