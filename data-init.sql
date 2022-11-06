DROP DATABASE IF EXISTS x_order;
CREATE DATABASE x_order DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
DROP DATABASE IF EXISTS x_product;
CREATE DATABASE x_product DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
DROP DATABASE IF EXISTS x_account;
CREATE DATABASE x_account DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS x_order.orders;
CREATE TABLE x_order.orders
(
    id               INT(11) NOT NULL AUTO_INCREMENT,
    user_id          INT(11)        DEFAULT NULL,
    product_id       INT(11)        DEFAULT NULL,
    pay_amount       INT(11)        DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;

insert into x_order.orders (id,user_id,product_id,pay_amount) values (1,1,1,1999);
insert into x_order.orders (id,user_id,product_id,pay_amount) values (2,1,2,376);
insert into x_order.orders (id,user_id,product_id,pay_amount) values (3,2,3,112);

DROP TABLE IF EXISTS x_product.products;
CREATE TABLE x_product.products
(
    id               INT(11) NOT NULL AUTO_INCREMENT,
    name             VARCHAR(20),
    stock            INT(11)  DEFAULT NULL,
    price            INT(11)  DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;


INSERT INTO x_product.products (id,name,price,stock) VALUES (1,'显示器', 1999,4); # 插入一条产品的库存
INSERT INTO x_product.products (id,name,price,stock) VALUES (2,'键盘', 188,5);
INSERT INTO x_product.products (id,name,price,stock) VALUES (3,'充电宝', 56,6);

DROP TABLE IF EXISTS x_account.accounts;
CREATE TABLE x_account.accounts
(
    id               INT(11) NOT NULL AUTO_INCREMENT,
    name            VARCHAR(20),
    balance          DOUBLE   DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB AUTO_INCREMENT = 1  DEFAULT CHARSET = utf8;

INSERT INTO  x_account.accounts (id,name,balance) values (1,'John',200);
INSERT INTO  x_account.accounts (id,name,balance) values (2,'Tom',300);



CREATE TABLE x_order.undo_log
(
    id            BIGINT(20)   NOT NULL AUTO_INCREMENT,
    branch_id     BIGINT(20)   NOT NULL,
    xid           VARCHAR(100) NOT NULL,
    context       VARCHAR(128) NOT NULL,
    rollback_info LONGBLOB     NOT NULL,
    log_status    INT(11)      NOT NULL,
    log_created   DATETIME     NOT NULL,
    log_modified  DATETIME     NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY ux_undo_log (xid, branch_id)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;

CREATE TABLE x_product.undo_log
(
    id            BIGINT(20)   NOT NULL AUTO_INCREMENT,
    branch_id     BIGINT(20)   NOT NULL,
    xid           VARCHAR(100) NOT NULL,
    context       VARCHAR(128) NOT NULL,
    rollback_info LONGBLOB     NOT NULL,
    log_status    INT(11)      NOT NULL,
    log_created   DATETIME     NOT NULL,
    log_modified  DATETIME     NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY ux_undo_log (xid, branch_id)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;

CREATE TABLE x_account.undo_log
(
    id            BIGINT(20)   NOT NULL AUTO_INCREMENT,
    branch_id     BIGINT(20)   NOT NULL,
    xid           VARCHAR(100) NOT NULL,
    context       VARCHAR(128) NOT NULL,
    rollback_info LONGBLOB     NOT NULL,
    log_status    INT(11)      NOT NULL,
    log_created   DATETIME     NOT NULL,
    log_modified  DATETIME     NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY ux_undo_log (xid, branch_id)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;
