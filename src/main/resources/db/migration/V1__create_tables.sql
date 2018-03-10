CREATE TABLE file_asset
(
  id                 BIGSERIAL NOT NULL
    CONSTRAINT file_asset_pkey
    PRIMARY KEY,
  created_date_time  TIMESTAMP,
  expiring_date_time TIMESTAMP,
  file_name          VARCHAR(255),
  hash               VARCHAR(255),
  name               VARCHAR(255)
);

