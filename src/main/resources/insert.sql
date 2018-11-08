DELETE FROM categories;


INSERT INTO "categories" (id, id_parent, category) VALUES
(1,null,'Бытовая техника');
INSERT INTO "categories" (id, id_parent, category) VALUES
(2,null,'Телефоны');
INSERT INTO "categories" (id, id_parent, category) VALUES
(3,null,'Компьютеры');
INSERT INTO "categories" (id, id_parent, category) VALUES
(4,null,'Оргтехника');


INSERT INTO "categories" (id, id_parent, category) VALUES
(5,1,'Холодильники');
INSERT INTO "categories" (id, id_parent, category) VALUES
(6,1,'Стиральные машины');
INSERT INTO "categories" (id, id_parent, category) VALUES
(7,1,'Газовые плиты');

INSERT INTO "categories" (id, id_parent, category) VALUES
(8,2,'Мобильные телефоны');
INSERT INTO "categories" (id, id_parent, category) VALUES
(9,2,'Смартфоны');

INSERT INTO "categories" (id, id_parent, category) VALUES
(10,3,'Системные блоки');
INSERT INTO "categories" (id, id_parent, category) VALUES
(11,3,'Мониторы');
INSERT INTO "categories" (id, id_parent, category) VALUES
(12,3,'Ноутбуки');

INSERT INTO "categories" (id, id_parent, category) VALUES
(13,4,'Принтеры');
INSERT INTO "categories" (id, id_parent, category) VALUES
(14,4,'Сканеры');
INSERT INTO "categories" (id, id_parent, category) VALUES
(15,4,'МФУ');


