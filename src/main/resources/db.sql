-- CREATE TABLE `Counters` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `count` int(11) NOT NULL DEFAULT '1',
--   `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
--   `updatedAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
--   PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8


/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/6/25 3:22:25                            */
/*==============================================================*/


drop table if exists activity;

drop table if exists activity_application;

drop table if exists certification;

drop index uq_open_id on user;

drop table if exists user;

/*==============================================================*/
/* Table: activity                                              */
/*==============================================================*/
create table activity
(
    activity_id          varchar(50) not null,
    publier_user_id      varchar(50),
    start_date           date not null,
    end_date             date not null,
    required_num         int,
    required_type        varchar(50),
    contact_name         varchar(50),
    contact_phone        varchar(50),
    application_table    varchar(50) not null,
    primary key (activity_id)
);

/*==============================================================*/
/* Table: activity_application                                  */
/*==============================================================*/
create table activity_application
(
    activity_application_id varchar(50) not null,
    user_id              varchar(50),
    activity_id          varchar(50),
    application_table    varchar(50) not null,
    name                 varchar(50) not null,
    phone                varchar(50) not null,
    time                 datetime not null,
    state                int not null,
    primary key (activity_application_id)
);

/*==============================================================*/
/* Table: certification                                         */
/*==============================================================*/
create table certification
(
    certification_id     varchar(50) not null,
    user_id              varchar(50),
    picture_url          varchar(50),
    state                int not null,
    time                 time not null,
    认证信息描述               varchar(50) not null,
    primary key (certification_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
    user_id              varchar(50) not null,
    open_id              varchar(50) not null,
    state                int not null,
    primary key (user_id)
);

/*==============================================================*/
/* Index: uq_open_id                                            */
/*==============================================================*/
create unique index uq_open_id on user
    (
     open_id
        );

alter table activity add constraint FK_Reference_1 foreign key (publier_user_id)
    references user (user_id) on delete restrict on update restrict;

alter table activity_application add constraint FK_Reference_2 foreign key (user_id)
    references user (user_id) on delete restrict on update restrict;

alter table activity_application add constraint FK_Reference_3 foreign key (activity_id)
    references activity (activity_id) on delete restrict on update restrict;

alter table certification add constraint FK_Reference_4 foreign key (user_id)
    references user (user_id) on delete restrict on update restrict;

