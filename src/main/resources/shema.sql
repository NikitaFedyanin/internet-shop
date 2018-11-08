DROP TABLE products_orders;
DROP TABLE product_categories;
DROP TABLE orders;
DROP TABLE users;
DROP TABLE status;
DROP TABLE products;
DROP TABLE categories;


CREATE TABLE "users"
(
 "id"              SERIAL NOT NULL,
 "name"            VARCHAR(100) NOT NULL ,
 "adress"          VARCHAR(255) NOT NULL ,
 "kind_of_payment" VARCHAR(45) NOT NULL ,

PRIMARY KEY ("id")
);

CREATE TABLE "products"
(
 "id"          SERIAL NOT NULL ,
 "name"        VARCHAR(45) NOT NULL ,
 "description" VARCHAR(255) NOT NULL ,
 "price"       INTEGER NOT NULL ,
 "articale"  INTEGER NOT NULL ,
 "warehouse"   INTEGER NOT NULL ,
PRIMARY KEY ("id")
);

CREATE TABLE "categories"
(

 "id"        SERIAL NOT NULL ,
 "id_parent" INTEGER ,
 "category"  VARCHAR(45) NOT NULL ,

PRIMARY KEY ("id"),
CONSTRAINT categories_fk0 FOREIGN KEY ("id_parent") REFERENCES "categories" ("id")
);

CREATE TABLE "status"
(
 "id"      SERIAL NOT NULL ,
 "name"    VARCHAR(45) NOT NULL ,
 "sysname" VARCHAR(45) NOT NULL ,

PRIMARY KEY ("id")
);

CREATE TABLE "orders"
(
 "id"         SERIAL NOT NULL ,
 "date"       DATE NOT NULL ,
 "user_id"    INTEGER NOT NULL ,
 "price"      INTEGER NOT NULL ,
 "status_id"    INTEGER NOT NULL ,

PRIMARY KEY ("id"),
CONSTRAINT "FK_83" FOREIGN KEY  ("user_id") REFERENCES "users" ("id"),
CONSTRAINT "FK_86" FOREIGN KEY("status_id") REFERENCES "status" ("id")
);




CREATE TABLE "product_categories"
(
 "id"         SERIAL NOT NULL ,
 "id_category" INTEGER NOT NULL ,
 "id_product"        INTEGER NOT NULL ,

PRIMARY KEY ("id"),
CONSTRAINT "FK_45" FOREIGN KEY ("id_product") REFERENCES "products" ("id"),
CONSTRAINT "FK_49" FOREIGN KEY("id_category") REFERENCES "categories" ("id")
);

CREATE TABLE "products_orders"
(
 "id"         SERIAL NOT NULL ,
  "id_order"   INTEGER NOT NULL ,
 "id_product" INTEGER NOT NULL ,


PRIMARY KEY ("id"),
CONSTRAINT "FK_94" FOREIGN KEY  ("id_product") REFERENCES "products" ("id"),
CONSTRAINT "FK_97" FOREIGN KEY ("id_order") REFERENCES "orders" ("id")
);




