insert into customer(customer_id, customer_name, customer_email_id, customer_phone_no, customer_address) values(100001,'Vishal Thapa','vishal@gmail.com','7365907119','Kolkata');
insert into customer(customer_id, customer_name, customer_email_id, customer_phone_no, customer_address) values(100002,'Bharat Thapa','bharat@gmail.com','9874561231','Siliguri');
insert into customer(customer_id, customer_name, customer_email_id, customer_phone_no, customer_address) values(100003,'Vivek Kumar','vivek@gmail.com','4567891232','Darjeeling');
insert into customer(customer_id, customer_name, customer_email_id, customer_phone_no, customer_address) values(100004,'Mahima Kohli','mahima@gmail.com','1569891232','Hyderabad');
insert into customer(customer_id, customer_name, customer_email_id, customer_phone_no, customer_address) values(100005,'Adyasha Jena','adyasha@gmail.com','3698891232','Bhubaneswaar');
insert into customer(customer_id, customer_name, customer_email_id, customer_phone_no, customer_address) values(100006,'Pradaap S S','pradaap@gmail.com','6985891232','Banglore');
insert into customer(customer_id, customer_name, customer_email_id, customer_phone_no, customer_address) values(100007,'Vivek Kumar','vivek@gmail.com','4567891232','Darjeeling');
insert into customer(customer_id, customer_name, customer_email_id, customer_phone_no, customer_address) values(100008,'Vivek Kumar','vivek@gmail.com','4567891232','Darjeeling');

 

 

 


insert into trutime(trutime_product_id,trutime_product_name,max_trutime_eligible,interest_rate,tenure,collateral_type) values(1001,'Home Trutime',1500000,12.5,36,'REAL_ESTATE');
insert into trutime(trutime_product_id,trutime_product_name,max_trutime_eligible,interest_rate,tenure,collateral_type) values(1002,'Home Trutime',1000000,13.5,30,'CASH_DEPOSIT');
insert into trutime(trutime_product_id,trutime_product_name,max_trutime_eligible,interest_rate,tenure,collateral_type) values(1003,'Car Trutime',700000,11.5,30,'REAL_ESTATE');
insert into trutime(trutime_product_id,trutime_product_name,max_trutime_eligible,interest_rate,tenure,collateral_type) values(1004,'Car Trutime',500000,12,24,'CASH_DEPOSIT');
insert into trutime(trutime_product_id,trutime_product_name,max_trutime_eligible,interest_rate,tenure,collateral_type) values(1005,'Education Trutime',500000,12,24,'CASH_DEPOSIT');
insert into trutime(trutime_product_id,trutime_product_name,max_trutime_eligible,interest_rate,tenure,collateral_type) values(1006,'Medical Trutime',500000,12,24,'REAL_ESTATE');
insert into trutime(trutime_product_id,trutime_product_name,max_trutime_eligible,interest_rate,tenure,collateral_type) values(1007,'Home Trutime',500000,12,24,'CASH_DEPOSIT');
insert into trutime(trutime_product_id,trutime_product_name,max_trutime_eligible,interest_rate,tenure,collateral_type) values(1008,'Medical Trutime',500000,12,24,'CASH_DEPOSIT');

 

 

 


insert into customertrutime(trutime_id,trutime_product_id,customer_id,trutime_principal,tenure,interest,emi,collateral_id) values(1,1001,100001,6000000,12.5,36,65000,NULL);
insert into customertrutime(trutime_id,trutime_product_id,customer_id,trutime_principal,tenure,interest,emi,collateral_id) values(2,1002,100002,4500000,13.5,30,55000,NULL);
insert into customertrutime(trutime_id,trutime_product_id,customer_id,trutime_principal,tenure,interest,emi,collateral_id) values(3,1003,100003,3500000,11.5,30,30000,NULL);
insert into customertrutime(trutime_id,trutime_product_id,customer_id,trutime_principal,tenure,interest,emi,collateral_id) values(4,1004,100004,6500000,10.5,32,44000,NULL);
insert into customertrutime(trutime_id,trutime_product_id,customer_id,trutime_principal,tenure,interest,emi,collateral_id) values(5,1005,100005,3000000,11.9,35,30000,NULL);
insert into customertrutime(trutime_id,trutime_product_id,customer_id,trutime_principal,tenure,interest,emi,collateral_id) values(6,1006,100006,5500000,11.5,34,52000,NULL);
insert into customertrutime(trutime_id,trutime_product_id,customer_id,trutime_principal,tenure,interest,emi,collateral_id) values(7,1007,100007,3300000,12.4,40,36000,NULL);
insert into customertrutime(trutime_id,trutime_product_id,customer_id,trutime_principal,tenure,interest,emi,collateral_id) values(8,1008,100008,3900000,11.5,30,30000,NULL);