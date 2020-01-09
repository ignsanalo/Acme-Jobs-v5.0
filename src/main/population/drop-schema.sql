
    alter table `administrator` 
       drop 
       foreign key FK_2a5vcjo3stlfcwadosjfq49l1;

    alter table `anonymous` 
       drop 
       foreign key FK_6lnbc6fo3om54vugoh8icg78m;

    alter table `application` 
       drop 
       foreign key `FKoa6p4s2oyy7tf80xwc4r04vh6`;

    alter table `application` 
       drop 
       foreign key `FKmbjdoxi3o93agxosoate4sxbt`;

    alter table `auditor` 
       drop 
       foreign key FK_clqcq9lyspxdxcp6o4f3vkelj;

    alter table `auditor_request` 
       drop 
       foreign key `FKkn8ax54577bh95khvuyoapv0c`;

    alter table `auditrecord` 
       drop 
       foreign key `FKditgyx355sc4ye86w7tj22cq6`;

    alter table `auditrecord` 
       drop 
       foreign key `FKa5p4w0gnuwmtb07juvrg8ptn6`;

    alter table `authenticated` 
       drop 
       foreign key FK_h52w0f3wjoi68b63wv9vwon57;

    alter table `consumer` 
       drop 
       foreign key FK_6cyha9f1wpj0dpbxrrjddrqed;

    alter table `duty` 
       drop 
       foreign key `FKs2uoxh4i5ya8ptyefae60iao1`;

    alter table `employer` 
       drop 
       foreign key FK_na4dfobmeuxkwf6p75abmb2tr;

    alter table `job` 
       drop 
       foreign key `FK3rxjf8uh6fh2u990pe8i2at0e`;

    alter table `message` 
       drop 
       foreign key `FKn5adlx3oqjna7aupm8gwg3fuj`;

    alter table `message_thread` 
       drop 
       foreign key `FKljabur1weonvmg511atm2ql6`;

    alter table `participates_in` 
       drop 
       foreign key `FKp8dubhjpvwx0mgn144chnj2ya`;

    alter table `participates_in` 
       drop 
       foreign key `FKm2o4n01mrot8y5d0nu0vbio7`;

    alter table `provider` 
       drop 
       foreign key FK_b1gwnjqm6ggy9yuiqm0o4rlmd;

    alter table `requisito` 
       drop 
       foreign key `FKdpyv3jqwtksicvkwm7bhdswhk`;

    alter table `worker` 
       drop 
       foreign key FK_l5q1f33vs2drypmbdhpdgwfv3;

    alter table `xxxx1` 
       drop 
       foreign key `FKivqoqgqubr8hn5quyvcmi324`;

    drop table if exists `administrator`;

    drop table if exists `announcement`;

    drop table if exists `anonymous`;

    drop table if exists `application`;

    drop table if exists `auditor`;

    drop table if exists `auditor_request`;

    drop table if exists `auditrecord`;

    drop table if exists `authenticated`;

    drop table if exists `challenge`;

    drop table if exists `companyrecord`;

    drop table if exists `configuration`;

    drop table if exists `consumer`;

    drop table if exists `dashboard`;

    drop table if exists `duty`;

    drop table if exists `employer`;

    drop table if exists `investorrecords`;

    drop table if exists `job`;

    drop table if exists `message`;

    drop table if exists `message_thread`;

    drop table if exists `offer`;

    drop table if exists `participates_in`;

    drop table if exists `provider`;

    drop table if exists `requests`;

    drop table if exists `requisito`;

    drop table if exists `user_account`;

    drop table if exists `worker`;

    drop table if exists `xxxx1`;

    drop table if exists `hibernate_sequence`;
