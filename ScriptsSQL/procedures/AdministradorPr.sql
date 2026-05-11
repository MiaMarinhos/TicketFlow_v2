-----------------------------------
--ADMINISTRADOR
-----------------------------------
--Create
DELIMITER $$

CREATE PROCEDURE sp_crear_administrador(
    IN p_idAdministrador INT,
    IN p_codigo VARCHAR(45),
    IN p_nombre VARCHAR(45),
    IN p_apellido_paterno VARCHAR(45),
    IN p_apellido_materno VARCHAR(45),
    IN p_dni VARCHAR(45),
    IN p_contrasena VARCHAR(45)
)
BEGIN

INSERT INTO administrador(
    idAdministrador,
    codigo,
    nombre,
    apellido_paterno,
    apellido_materno,
    dni,
    contrasena
)
VALUES(
          p_idAdministrador,
          p_codigo,
          p_nombre,
          p_apellido_paterno,
          p_apellido_materno,
          p_dni,
          p_contrasena
      );

END$$

DELIMITER ;

--Read
DELIMITER $$

CREATE PROCEDURE USP_LEER_ADMINISTRADOR(
    IN p_idAdministrador INT
)
BEGIN
SELECT
    idAdministrador,
    codigo,
    nombre,
    apellido_paterno,
    apellido_materno,
    dni,
    contrasena
FROM administrador
WHERE idAdministrador = p_idAdministrador;
END$$

DELIMITER ;

--Update
DELIMITER $$

CREATE PROCEDURE USP_ACTUALIZAR_ADMINISTRADOR(
    IN p_idAdministrador INT,
    IN p_codigo VARCHAR(45),
    IN p_nombre VARCHAR(45),
    IN p_apellido_paterno VARCHAR(45),
    IN p_apellido_materno VARCHAR(45),
    IN p_dni VARCHAR(45),
    IN p_contrasena VARCHAR(45)
)
BEGIN

UPDATE administrador
SET
    codigo = p_codigo,
    nombre = p_nombre,
    apellido_paterno = p_apellido_paterno,
    apellido_materno = p_apellido_materno,
    dni = p_dni,
    contrasena = p_contrasena
WHERE idAdministrador = p_idAdministrador;

END$$

DELIMITER ;

--Delete
DELIMITER $$

CREATE PROCEDURE USP_ELIMINAR_ADMINISTRADOR(
    IN p_idAdministrador INT
)
BEGIN

DELETE FROM administrador
WHERE idAdministrador = p_idAdministrador;

END$$

DELIMITER ;


--ListAll
DELIMITER $$

CREATE PROCEDURE USP_LISTAR_ADMINISTRADORES()
BEGIN

SELECT
    idAdministrador,
    codigo,
    nombre,
    apellido_paterno,
    apellido_materno,
    dni,
    contrasena
FROM administrador;

END$$

DELIMITER ;
