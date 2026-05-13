-----------------------------------
--USUARIO
-----------------------------------
--Create


--Read


--Update


--Delete


--ListAll

--BuscarPorNombre
DELIMITER $$

CREATE PROCEDURE SP_BUSCAR_USUARIO_NOMBRE(
    IN p_nombre VARCHAR(45)
)
BEGIN

SELECT
    u.*,
    uxt.idTipo_usuario
FROM usuario u
         INNER JOIN usuario_x_tipo uxt
                    ON u.idUsuario = uxt.idUsuario
WHERE u.nombre LIKE CONCAT('%', p_nombre, '%');

END$$

DELIMITER ;

--Filtrar Por Tipo
DELIMITER $$

CREATE PROCEDURE SP_FILTRAR_USUARIO_TIPO(
    IN p_idTipo_usuario INT
)
BEGIN
SELECT
    u.*,
    uxt.idTipo_usuario
FROM usuario u
         INNER JOIN usuario_x_tipo uxt
                    ON u.idUsuario = uxt.idUsuario
WHERE uxt.idTipo_usuario = p_idTipo_usuario;
END$$

DELIMITER ;

--Filtrar Por Estado
DELIMITER $$

CREATE PROCEDURE SP_FILTRAR_USUARIO_ESTADO(
    IN p_idEstado INT
)
BEGIN

SELECT
    u.*,
    uxt.idTipo_usuario
FROM usuario u
         INNER JOIN usuario_x_tipo uxt
                    ON u.idUsuario = uxt.idUsuario
WHERE u.idEstado = p_idEstado;

END$$

DELIMITER ;

--Bloquear Usuario
DELIMITER $$

CREATE PROCEDURE SP_BLOQUEAR_USUARIO(
    IN p_idUsuario INT
)
BEGIN

UPDATE usuario
SET idEstado = 2
WHERE idUsuario = p_idUsuario;

END$$

DELIMITER ;

--DesbloquearUsuario
DELIMITER $$

CREATE PROCEDURE SP_DESBLOQUEAR_USUARIO(
    IN p_idUsuario INT
)
BEGIN

UPDATE usuario
SET idEstado = 1
WHERE idUsuario = p_idUsuario;

END$$

DELIMITER ;

-----------------------------------
--CLIENTE
-----------------------------------
--Create


--Read


--Update


--Delete


--ListAll


-----------------------------------
--ANFITRION
-----------------------------------
--Create


--Read


--Update


--Delete


--ListAll

