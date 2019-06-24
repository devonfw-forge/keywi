-- *** KeyItem (Items of a KeyList) ***
CREATE TABLE KeyItem (
  id                  BIGINT NOT NULL GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
  modificationCounter INTEGER NOT NULL,
  business_key        VARCHAR (255),
  name                VARCHAR (255),
  comment             VARCHAR (4096),
  disabled            BOOLEAN,
  value               VARCHAR (255),
  keyList             BIGINT NOT NULL,
  CONSTRAINT PK_KeyItem PRIMARY KEY(id),
  CONSTRAINT FK_KeyItem_keyList FOREIGN KEY(keyList) REFERENCES KeyList(id),
  CONSTRAINT UK_KeyItem_key UNIQUE(business_key, keyList)
);