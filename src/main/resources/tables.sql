-- Tabla franquicia
CREATE TABLE franquicia (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Tabla sucursal
CREATE TABLE sucursal (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    franquicia_id INT NOT NULL,
    FOREIGN KEY (franquicia_id) REFERENCES franquicia(id) ON DELETE CASCADE
);

-- Tabla producto
CREATE TABLE producto (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    cantidad_stock INT NOT NULL CHECK (cantidad_stock >= 0),
    sucursal_id INT NOT NULL,
    FOREIGN KEY (sucursal_id) REFERENCES sucursal(id) ON DELETE CASCADE
);