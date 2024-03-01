CREATE TABLE `customer`(
    `id` bigint PRIMARY KEY ,
    `name` varchar(255) NOT NULL
);
CREATE TABLE `transaction`(
    `id` bigint AUTO_INCREMENT PRIMARY KEY ,
    `customer_id` bigint NOT NULL ,
    `datetime` datetime NOT NULL ,
    `amount` bigint,
    CONSTRAINT c_fk
        FOREIGN KEY (customer_id) REFERENCES customer(id)
);
