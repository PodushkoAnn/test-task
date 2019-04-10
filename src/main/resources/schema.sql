create table CAR (
  id IDENTITY primary key,
  brand VARCHAR2(150),
  model VARCHAR2(200),
  power DOUBLE,
  year_of_issue YEAR,
  assessed_value DEC(20)
);

create table AIRPLANE (
  id IDENTITY primary key,
  brand VARCHAR2(150),
  model VARCHAR2(200),
  manufacturer VARCHAR2(500),
  year_of_issue YEAR,
  fuel_capacity INT,
  seats INT,
  assessed_value DEC(20)
);

create table VALUE (
  id IDENTITY primary key,
  object_type VARCHAR (100),
  external_id INT,
  assessed_value DEC(20),
  assessment_date DATE,
);

-- create table VALUE (
--   id IDENTITY primary key,
--   airplane_id INT,
--   car_id INT,
--   assessed_value DEC(20),
--   assessment_date DATE,
--   foreign key (airplane_id) references AIRPLANE (id),
--   foreign key (car_id) references CAR (id)
-- );