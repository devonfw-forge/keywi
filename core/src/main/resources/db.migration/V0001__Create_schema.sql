CREATE TABLE KeyList(
  id                  NUMBER(19) NOT NULL,
  modificationCounter INTEGER NOT NULL,
  businessKey         VARCHAR2(60 CHAR) NOT NULL,
  name                VARCHAR2(60 CHAR) NOT NULL,
  description         VARCHAR2(2000 CHAR),
  categoryKeyList     NUMBER(19),
  categoryOptional    NUMBER(1) NOT NULL,
  complex             NUMBER(1) NOT NULL,
  systemList          NUMBER(1) NOT NULL,
  tree                NUMBER(1) NOT NULL,
  permission          NUMBER(19),
  valueRegexp         VARCHAR2(200 CHAR),
  orderingField       VARCHAR(10 CHAR),
  CONSTRAINT PK_KeyList_id PRIMARY KEY (id),
  CONSTRAINT UC_KeyList_businessKey UNIQUE (businessKey),
  CONSTRAINT FK_KeyList_categoryKeyList FOREIGN KEY (categoryKeyList) REFERENCES KeyList(id)
);
COMMENT ON TABLE KeyList is 'Schlüsselliste: Sammlung von Einträgen (KEYLISTENTRY)';
COMMENT ON COLUMN KeyList.id is 'Primärschlüssel';
COMMENT ON COLUMN KeyList.modificationCounter is 'Versionszähler für optimistische Sperre (wird bei jeder Änderung hochgezählt)';
COMMENT ON COLUMN KeyList.businessKey is 'Eindeutiger fachlicher Schlüssel';
COMMENT ON COLUMN KeyList.name is 'Anzeigename der Schlüsselliste';
COMMENT ON COLUMN KeyList.description is 'Beschreibung der Schlüsselliste (z.B. als Erläuterung in Tooltips, optional)';
COMMENT ON COLUMN KeyList.categoryKeyList is 'ID der Schlüsselliste, die als Kategorie verwendet wird (optional)';
COMMENT ON COLUMN KeyList.categoryOptional is 'Flag ob die Kategorie optional ist (keine Relevanz, wenn categoryKeyList nicht gesetzt ist)';
COMMENT ON COLUMN KeyList.complex is 'Flag ob die Schlüsselliste komplex ist';
COMMENT ON COLUMN KeyList.systemList is 'Flag ob die Schlüsselliste eine Systemliste ist, die besondere Rechte zur vollständigen Bearbeitung erfordert';
COMMENT ON COLUMN KeyList.tree is 'Flag ob die Schlüsselliste hierarchisch ist (Baumstruktur)';
COMMENT ON COLUMN KeyList.valueRegexp is 'Das ist ein Regulär Ausdruck für den Wert (Value) in Schlüssellisten-Enträge';
COMMENT ON COLUMN KeyList.orderingField is 'Das Feld (Spalte) nach dem die Einträge sortiert werden sollen.';
