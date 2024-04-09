CREATE TABLE Products
(
    id          INTEGER PRIMARY KEY,
    name        VARCHAR(20),
    description VARCHAR(255),
    price       INTEGER,
    city        VARCHAR(25),
    author_name VARCHAR(30)
);
INSERT INTO products

CREATE TABLE Images
(
    id INTEGER PRIMARY KEY,
    name VARCHAR(64),
    orig_file_name VARCHAR(64),
    size INTEGER,
    content_type VARCHAR(64),
    is_preview_image BIT,
    bytes BYTEA,
    product_id INTEGER,
    FOREIGN KEY (product_id) REFERENCES Products (id)
);
