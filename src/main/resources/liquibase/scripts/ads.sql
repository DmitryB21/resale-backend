-- liquibase formatted sql

-- changeset dblyukherov:1

CREATE TABLE IF NOT EXISTS ads(
    id              SERIAL PRIMARY KEY,
    title           VARCHAR (100) NOT NULL,
    description     TEXT,
    price           INTEGER NOT NULL

    );