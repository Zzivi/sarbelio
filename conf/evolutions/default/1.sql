# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table ingredient (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_ingredient primary key (id))
;

create sequence ingredient_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists ingredient;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists ingredient_seq;

