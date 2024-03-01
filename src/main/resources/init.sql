USE customer_reward;
TRUNCATE TABLE customer;
TRUNCATE TABLE transaction;

INSERT INTO customer (name)
    VALUE ('Alice');

INSERT INTO customer (name)
    VALUE ('Bob');

INSERT INTO transaction (datetime, amount)
    VALUE ()