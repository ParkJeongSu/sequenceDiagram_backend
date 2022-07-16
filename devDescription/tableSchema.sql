-- 모델러 계정 생성 테스트

alter session set "_ORACLE_SCRIPT"=true;

create user modeler1 identified by modeler1;

grant create session to modeler1;

grant connect, resource, DBA to modeler1;

alter user modeler1 default tablespace users quota unlimited on users;

-- objectDefinition
CREATE TABLE SequenceDefinition
(
    ID NUMBER,
    SEQUENCEMENUNAME VARCHAR2(40),
    DIAGRAMTEXT VARCHAR2(4000)
);

ALTER TABLE SequenceDefinition ADD CONSTRAINT SequenceDefinition_pk PRIMARY KEY (ID);

COMMENT ON
TABLE SequenceDefinition IS '시퀀시다이어그램정의';

COMMENT ON
COLUMN SequenceDefinition.ID IS '시퀀스아이디';

COMMENT ON
COLUMN SequenceDefinition.SEQUENCEMENUNAME IS '시퀀스명';

COMMENT ON
COLUMN SequenceDefinition.DIAGRAMTEXT IS '시퀀스다이어그램텍스트';


CREATE TABLE MessageDefinition
(
    ID NUMBER,
    MESSAGENAME VARCHAR2(40),
    EXAMPLEMESSAGECONTENT VARCHAR2(4000),
    MESSAGEDESCRIPTION VARCHAR2(4000)
);

ALTER TABLE MessageDefinition ADD CONSTRAINT MessageDefinition_pk PRIMARY KEY (ID);

COMMENT ON
TABLE MessageDefinition IS '메시지정의';

COMMENT ON
COLUMN MessageDefinition.ID IS '메시지아이디';

COMMENT ON
COLUMN MessageDefinition.MESSAGENAME IS '메시지명';

COMMENT ON
COLUMN MessageDefinition.EXAMPLEMESSAGECONTENT IS '예시메시지';

COMMENT ON
COLUMN MessageDefinition.MESSAGEDESCRIPTION IS '메시지설명';