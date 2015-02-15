  CREATE TABLE VOL (
  VOL_ID INT PRIMARY KEY NOT NULL,
  VOL_NAME VARCHAR(50) NOT NULL,
  LAST_NAME VARCHAR(30) NOT NULL,
  USERNAME VARCHAR(30) NOT NULL,
  EMAIL VARCHAR(30) NOT NULL,
  CITY VARCHAR(30) NOT NULL,
  BIRTHDAY DATE,
  EXP INT DEFAULT '0' NOT NULL,
  LVL INT DEFAULT '0' NOT NULL,
  DATE_CREATED DATE NOT NULL
  );
  
  CREATE TABLE ONG (
  ONG_ID INT NOT NULL PRIMARY KEY,
  ONG_NAME VARCHAR(50) NOT NULL,
  DESCRIPTION VARCHAR(500) NOT NULL,
  ADDRESS VARCHAR(150),
  CV INT NOT NULL, -- Requiere cv para inscribirse 0 NO 1 SI
  DATE_CREATED DATE NOT NULL
  );
  
  CREATE TABLE EVNT (
  EVNT_ID INT PRIMARY KEY NOT NULL,
  EVNT_NAME VARCHAR(50) NOT NULL,
  EVNT_DATE DATE NOT NULL,
  EVNT_TIME VARCHAR(5) NOT NULL,
  ONG_ID INT NOT NULL,
  DESCRIPTION VARCHAR(500) NOT NULL,
  ADDRESS VARCHAR(100) NOT NULL,
  LAT VARCHAR(12) DEFAULT NULL,
  LNG VARCHAR(12) DEFAULT NULL
  );
  
  CREATE TABLE ONG_VOL (
  ONG_ID INT NOT NULL,
  VOL_ID INT NOT NULL
  );
  
  CREATE TABLE EVNT_VOL (
  EVNT_ID INT NOT NULL,
  VOL_ID INT NOT NULL
  );
  
  
  ALTER TABLE EVNT ADD CONSTRAINT EVNT_ONG_FK FOREIGN KEY ( ONG_ID ) REFERENCES ONG ( ONG_ID );
  
  ALTER TABLE ONG_VOL ADD CONSTRAINT ONG_VOL_ONG_FK FOREIGN KEY ( ONG_ID ) REFERENCES ONG ( ONG_ID );
  ALTER TABLE ONG_VOL ADD CONSTRAINT ONG_VOL_VOL_FK FOREIGN KEY ( VOL_ID ) REFERENCES VOL ( VOL_ID );
  
  ALTER TABLE EVNT_VOL ADD CONSTRAINT EVNT_VOL_EVNT_FK FOREIGN KEY ( EVNT_ID ) REFERENCES EVNT ( EVNT_ID );
  ALTER TABLE EVNT_VOL ADD CONSTRAINT EVNT_VOL_VOL_FK FOREIGN KEY ( VOL_ID ) REFERENCES VOL( VOL_ID );