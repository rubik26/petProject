CREATE TABLE products (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255),
                          description TEXT,
                          price INT,
                          city VARCHAR(255),
                          preview_image_id INT,
                          data_created TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()
);


CREATE TABLE images (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255),
                        orig_file_name VARCHAR(255),
                        size BIGINT,
                        content_type VARCHAR(255),
                        is_preview_image BOOLEAN,
                        bytes BYTEA,
                        product_id INT NOT NULL,
                        FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);
