
    create table `administrator` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `announcement` (
       `id` integer not null,
        `version` integer not null,
        `moment` datetime(6),
        `more_info` varchar(255),
        `text` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `anonymous` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `application` (
       `id` integer not null,
        `version` integer not null,
        `answer` varchar(255),
        `mandatory_justification` varchar(255),
        `moment` datetime(6),
        `password` varchar(255),
        `protegido` varchar(255),
        `qualifications` varchar(255),
        `reference` varchar(255),
        `skills` varchar(255),
        `statement` varchar(255),
        `status` varchar(255),
        `job_id` integer not null,
        `worker_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `auditor` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `responsability_statement` varchar(255),
        `firm` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `auditor_request` (
       `id` integer not null,
        `version` integer not null,
        `firm` varchar(255),
        `statement` varchar(255),
        `status` integer,
        `user_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `auditrecord` (
       `id` integer not null,
        `version` integer not null,
        `body` varchar(255),
        `final_mode` bit not null,
        `moment` datetime(6),
        `title` varchar(255),
        `auditor_id` integer not null,
        `job_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `authenticated` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `challenge` (
       `id` integer not null,
        `version` integer not null,
        `deadline` datetime(6),
        `description` varchar(255),
        `goal_bronze` varchar(255),
        `goal_gold` varchar(255),
        `goal_silver` varchar(255),
        `reward_bronze_amount` double precision,
        `reward_bronze_currency` varchar(255),
        `reward_gold_amount` double precision,
        `reward_gold_currency` varchar(255),
        `reward_silver_amount` double precision,
        `reward_silver_currency` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `companyrecord` (
       `id` integer not null,
        `version` integer not null,
        `ceo` varchar(255),
        `description` varchar(255),
        `email` varchar(255),
        `incorporated` bit not null,
        `name` varchar(255),
        `phone` varchar(255),
        `sector` varchar(255),
        `stars` integer,
        `web` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `configuration` (
       `id` integer not null,
        `version` integer not null,
        `spam_threshold` double precision,
        `spam_words` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `consumer` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `dashboard` (
       `id` integer not null,
        `version` integer not null,
        `answer_ratio` float,
        `jobs_ratio` float,
        `protected_ratio` float,
        primary key (`id`)
    ) engine=InnoDB;

    create table `duty` (
       `id` integer not null,
        `version` integer not null,
        `description` varchar(255),
        `percentage` double precision,
        `title` varchar(255),
        `job_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `employer` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `investorrecords` (
       `id` integer not null,
        `version` integer not null,
        `name` varchar(255),
        `sector` varchar(255),
        `stars` integer,
        `statement` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `job` (
       `id` integer not null,
        `version` integer not null,
        `deadline` datetime(6),
        `description` varchar(255),
        `final_mode` bit not null,
        `more_info` varchar(255),
        `reference` varchar(255),
        `salary_amount` double precision,
        `salary_currency` varchar(255),
        `title` varchar(255),
        `employer_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `message` (
       `id` integer not null,
        `version` integer not null,
        `body` varchar(255),
        `moment` datetime(6),
        `tags` varchar(255),
        `title` varchar(255),
        `message_thread_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `message_thread` (
       `id` integer not null,
        `version` integer not null,
        `moment` datetime(6),
        `title` varchar(255),
        `owner_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `offer` (
       `id` integer not null,
        `version` integer not null,
        `deadline` datetime(6),
        `moment` datetime(6),
        `money_max_amount` double precision,
        `money_max_currency` varchar(255),
        `money_min_amount` double precision,
        `money_min_currency` varchar(255),
        `text` varchar(255),
        `ticker` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `participates_in` (
       `id` integer not null,
        `version` integer not null,
        `participant_id` integer not null,
        `thread_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `provider` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `requests` (
       `id` integer not null,
        `version` integer not null,
        `deadline` datetime(6),
        `moment` datetime(6),
        `reward_amount` double precision,
        `reward_currency` varchar(255),
        `text` varchar(255),
        `ticker` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `requisito` (
       `id` integer not null,
        `version` integer not null,
        `more_info` varchar(255),
        `text` varchar(255),
        `job_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `user_account` (
       `id` integer not null,
        `version` integer not null,
        `enabled` bit not null,
        `identity_email` varchar(255),
        `identity_name` varchar(255),
        `identity_surname` varchar(255),
        `password` varchar(255),
        `username` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `worker` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `qualifications` varchar(255),
        `skills` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `xxxx1` (
       `id` integer not null,
        `version` integer not null,
        `more_info` varchar(255),
        `text` varchar(255),
        `job_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `hibernate_sequence` (
       `next_val` bigint
    ) engine=InnoDB;

    insert into `hibernate_sequence` values ( 1 );
create index IDXnhikaa2dj3la6o2o7e9vo01y0 on `announcement` (`moment`);
create index IDXdwumdwpjcwdk1mef9ua69yc2p on `application` (`reference`);

    alter table `application` 
       add constraint UK_ct7r18vvxl5g4c4k7aefpa4do unique (`reference`);
create index IDXr9ok0mijxo79e2biupolm5v85 on `auditor` (`firm`);

    alter table `auditor_request` 
       add constraint UK_emf8dnwjroe97odrlcsuk1nwo unique (`user_id`);
create index IDX473gmos37c8jkvb2b9t753q0i on `auditrecord` (`final_mode`);
create index IDXnr284tes3x8hnd3h716tmb3fr on `challenge` (`deadline`);
create index IDXl5b4yjfrl81yhfahb12r3fofp on `companyrecord` (`name`);
create index IDX4wi5b8uhexxn82hfv30od89cd on `configuration` (`spam_words`);
create index IDXuojinocjhspe71r200ye4svp on `consumer` (`company`);
create index IDXqm67mgqcgcacn4vyv1p4ws8ln on `employer` (`company`);
create index IDXr9kc03vaq2k507xnie0nfu80h on `investorrecords` (`sector`);
create index IDXfdmpnr8o4phmk81sqsano16r on `job` (`deadline`);

    alter table `job` 
       add constraint UK_7jmfdvs0b0jx7i33qxgv22h7b unique (`reference`);
create index IDXeq5fhm2b5j1q3ex9vhpmvlwg0 on `message` (`moment`);
create index IDXkyl36hj4o9e0butj9mrwv291d on `message_thread` (`moment`);
create index IDXq2o9psuqfuqmq59f0sq57x9uf on `offer` (`deadline`);
create index IDX5ryg86pl6nbhrnuralgx5agqv on `provider` (`company`);
create index IDXmly5kwrpgadjkxv5t5dgw36hr on `requests` (`deadline`);

    alter table `requests` 
       add constraint UK_5v1h0kdr8vcps4i9e55k5gnc8 unique (`ticker`);

    alter table `requisito` 
       add constraint UK_61mus8vhxm4xdaaq7qyrfaml0 unique (`job_id`);

    alter table `user_account` 
       add constraint UK_castjbvpeeus0r8lbpehiu0e4 unique (`username`);
create index IDXcl5stpa9341w7cquov0wexc9a on `worker` (`qualifications`);

    alter table `xxxx1` 
       add constraint UK_i2qt665lplguvu6lvrlntdf5q unique (`job_id`);

    alter table `administrator` 
       add constraint FK_2a5vcjo3stlfcwadosjfq49l1 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `anonymous` 
       add constraint FK_6lnbc6fo3om54vugoh8icg78m 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `application` 
       add constraint `FKoa6p4s2oyy7tf80xwc4r04vh6` 
       foreign key (`job_id`) 
       references `job` (`id`);

    alter table `application` 
       add constraint `FKmbjdoxi3o93agxosoate4sxbt` 
       foreign key (`worker_id`) 
       references `worker` (`id`);

    alter table `auditor` 
       add constraint FK_clqcq9lyspxdxcp6o4f3vkelj 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `auditor_request` 
       add constraint `FKkn8ax54577bh95khvuyoapv0c` 
       foreign key (`user_id`) 
       references `user_account` (`id`);

    alter table `auditrecord` 
       add constraint `FKditgyx355sc4ye86w7tj22cq6` 
       foreign key (`auditor_id`) 
       references `auditor` (`id`);

    alter table `auditrecord` 
       add constraint `FKa5p4w0gnuwmtb07juvrg8ptn6` 
       foreign key (`job_id`) 
       references `job` (`id`);

    alter table `authenticated` 
       add constraint FK_h52w0f3wjoi68b63wv9vwon57 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `consumer` 
       add constraint FK_6cyha9f1wpj0dpbxrrjddrqed 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `duty` 
       add constraint `FKs2uoxh4i5ya8ptyefae60iao1` 
       foreign key (`job_id`) 
       references `job` (`id`);

    alter table `employer` 
       add constraint FK_na4dfobmeuxkwf6p75abmb2tr 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `job` 
       add constraint `FK3rxjf8uh6fh2u990pe8i2at0e` 
       foreign key (`employer_id`) 
       references `employer` (`id`);

    alter table `message` 
       add constraint `FKn5adlx3oqjna7aupm8gwg3fuj` 
       foreign key (`message_thread_id`) 
       references `message_thread` (`id`);

    alter table `message_thread` 
       add constraint `FKljabur1weonvmg511atm2ql6` 
       foreign key (`owner_id`) 
       references `authenticated` (`id`);

    alter table `participates_in` 
       add constraint `FKp8dubhjpvwx0mgn144chnj2ya` 
       foreign key (`participant_id`) 
       references `authenticated` (`id`);

    alter table `participates_in` 
       add constraint `FKm2o4n01mrot8y5d0nu0vbio7` 
       foreign key (`thread_id`) 
       references `message_thread` (`id`);

    alter table `provider` 
       add constraint FK_b1gwnjqm6ggy9yuiqm0o4rlmd 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `requisito` 
       add constraint `FKdpyv3jqwtksicvkwm7bhdswhk` 
       foreign key (`job_id`) 
       references `job` (`id`);

    alter table `worker` 
       add constraint FK_l5q1f33vs2drypmbdhpdgwfv3 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `xxxx1` 
       add constraint `FKivqoqgqubr8hn5quyvcmi324` 
       foreign key (`job_id`) 
       references `job` (`id`);
