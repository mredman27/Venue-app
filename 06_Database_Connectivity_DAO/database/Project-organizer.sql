drop table if exists employee;
drop table if exists department;
drop table if exists project;


CREATE TABLE employee
(
        employee_Id serial,
        job_Title varchar(64) not null,
        last_Name varchar(40) not null,
        first_Name varchar(40) not null,
        birth_Date date not null,
        gender bpchar(1) not null,
        hire_Date date not null,
        department_Id int not null,
        
        constraint pk_employee primary key (employee_Id)
        
);


CREATE TABLE department
(
        department_Id serial,
        department_Name varchar(64) not null,
        employee_Id int not null,
        
        constraint pk_department primary key (department_Id)
        

);


CREATE TABLE project
(
        project_Id serial,
        project_Name varchar(64) not null,
        start_Date date not null,
        employee_Id int not null,
        
        constraint pk_project primary key (project_Id)
        
);

INSERT INTO employee (job_Title, last_Name, first_Name, birth_Date, gender, hire_Date, department_Id)
VALUES 
        ('boss', 'Redman', 'Molly', '1980-05-15', 'F', '2020-05-20', '1'),
        ('manager', 'Smith', 'Suzy', '1977-05-15', 'F', '2020-05-20', '1'),
        ('associate', 'Brown', 'Jimmy', '1979-05-15', 'F', '2020-05-20', '2'),
        ('associate', 'Love', 'Hattie', '1995-05-15', 'F', '2020-05-20', '2'),
        ('associate', 'Heart', 'Jane', '1965-05-15', 'F', '2020-05-20', '2'),
        ('associate', 'Joplin', 'Janis', '1960-05-15', 'F', '2020-05-20', '3'),
        ('associate', 'Jones', 'Jackson', '1998-05-15', 'F', '2020-05-20', '3'),
        ('associate', 'Fall', 'Farrah', '1980-05-15', 'F', '2020-05-20', '3');
        

--INSERT INTO department (department_Id, department_Name, employee_Id)
--VALUES 
--        ('1', 'Black', '1'),
--        ('1', 'Black', '2'),       --I kept getting an error while trying to INSERT
--        ('2', 'Purple', '3'),      --duplicate key value
--        ('2', 'Purple', '4'),      --ran out of time trying to figure out, i will fix and resubmit
--        ('2', 'Purple', '5'),
--        ('3', 'Blue', '6'),
--        ('3', 'Blue', '7'),
--        ('3', 'Blue', '8');

--INSERT INTO project (project_Id, project_Name, start_Date, employee_Id)
--VALUES
--        ('001', 'big_stuff', '2020-05-20', '1'),
--        ('001', 'big_stuff', '2020-05-20', '2'),
--       ('002', 'medium_stuff', '2020-05-20', '3'),
--        ('002', 'medium_stuff', '2020-05-20', '4'),
--        ('003', 'small_stuff', '2020-05-20', '5'),
--        ('003', 'small_stuff', '2020-05-20', '6'),
--        ('004', 'tiny_stuff', '2020-05-20', '7'),
--        ('004', 'tiny_stuff', '2020-05-20', '8');