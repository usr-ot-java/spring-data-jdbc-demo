create table categories (
    id bigserial primary key,
    title varchar(255)
);

create table authors (
    id bigserial primary key,
    full_name varchar(255)
);

create table books (
    id bigserial primary key,
    title varchar(255),
    genre varchar(255),
    author_id bigint,
    foreign key (author_id) references authors (id)
);

create table books_details (
    id bigserial primary key,
    book_id bigint,
    description varchar(255),
    foreign key (book_id) references books (id)
);

create table books_reviews (
    id bigserial primary key,
    book_id bigint,
    author varchar(255),
    review text,
    rate smallint,
    created_at timestamp with time zone default now(),
    foreign key (book_id) references books (id)
);

insert into categories (title) values ('Категория 1'), ('Категория 2'), ('Категория 3');

insert into authors (full_name) values ('Толкиен'), ('Роулинг'), ('Сандерсон'), ('Азимов');

insert into books (title, author_id, genre) values
  ('Властелин колец: Братство кольца', 1, 'FANTASY'),
  ('Гарри Поттер и Философский камень', 2, 'FANTASY'),
  ('Рожденный туманом: Пепел и сталь', 3, 'FANTASY'),
  ('Рожденный туманом: Источник вознесения', 3, 'FANTASY'),
  ('Рожденный туманом: Герой веков', 3, 'FANTASY'),
  ('Архив Буресвета: Путь королей', 3, 'FANTASY'),
  ('Академия', 4, 'SCIFI');

insert into books_details (book_id, description) values
  (1, 'Книга про Властелина колец'),
  (2, 'Книга про Гарри Поттера'),
  (3, 'Книга про Рожденного туманом'),
  (4, 'Книга про Рожденного туманом'),
  (5, 'Книга про Рожденного туманом'),
  (6, 'Книга про Архив Буресвета'),
  (7, 'Книга про Академию. Основная трилогия');

insert into books_reviews (book_id, author, review, rate) values
  (1, 'Анонимный автор', 'Хорошая книга', 10),
  (1, 'Секретный автор', 'Интересный сюжет', 7),
  (2, 'Маг', 'Очень много магии', 8),
  (3, 'Маг', 'Очень много магии', 7);
