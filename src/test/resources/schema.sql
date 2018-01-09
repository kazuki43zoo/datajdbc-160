CREATE TABLE IF NOT EXISTS todo (
    id IDENTITY
    ,title VARCHAR NOT NULL
    ,details VARCHAR
    ,finished BOOLEAN NOT NULL
);