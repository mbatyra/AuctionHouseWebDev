create sequence user_role_seq;

create table user_role
(
  id   bigint  default nextval('user_role_seq') not null
    constraint user_role_pkey
    primary key,
  role varchar(25) not null
);

alter table user_role
  owner to postgres;

create sequence users_seq;

create table users
(
  id           bigint default nextval('users_seq') not null
    constraint users_pkey
    primary key,
  login        varchar(50)  not null
    constraint ulogin
    unique,
  password     varchar(128) not null,
  role_id      bigint       not null,
  constraint fk_role_id foreign key (role_id)
    references user_role(id)
);

alter table users owner to postgres;

create sequence auction_seq;
create table auction
(
    id  bigint default nextval('auction_seq') not null
        constraint auction_pkey
            primary key,
    description varchar(250) not null,
    accepted boolean      default false not null,
    start_price bigint not null,
    actual_price bigint not null,
    buy_out_price bigint,
    user_id bigint constraint fk_user_id references users not null
);

alter table auction
    owner to postgres;

create sequence bid_seq;
create table bid
(
    id  bigint default nextval('bid_seq') not null
        constraint bid_pkey
            primary key,
    bid_price bigint not null,
    user_id      bigint       not null,
    constraint fk_user_id foreign key (user_id)
        references users(id),
    auction_id      bigint       not null,
    constraint fk_auction_id foreign key (auction_id)
        references auction(id)
);

alter table bid
    owner to postgres;


insert into user_role (role) values ('ROLE_admin'), ('ROLE_user');
insert into users (login, password, role_id) VALUES ('admin', '$2a$10$NceITHsXMF2oe/UdF8eTVes6yo3nlv8ewUhfrIM.TLkuMdrtgAgyi', 1);
insert into users (login, password, role_id) VALUES ('user1', '$2a$10$NceITHsXMF2oe/UdF8eTVes6yo3nlv8ewUhfrIM.TLkuMdrtgAgyi', 2);
insert into users (login, password, role_id) VALUES ('user2', '$2a$10$NceITHsXMF2oe/UdF8eTVes6yo3nlv8ewUhfrIM.TLkuMdrtgAgyi', 2);

--Haslo123$
