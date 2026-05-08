USE `ticket_flow`;

-- -----------------------------------------------------
-- PROCEDURES PARA CAPA DE USUARIO
-- -----------------------------------------------------
DELIMITER //
CREATE PROCEDURE SP_INSERTAR_USUARIO(OUT p_idUsuario INT, IN p_dni VARCHAR(45), IN p_nombre VARCHAR(45),
    IN p_apellido_paterno VARCHAR(45), IN p_apellido_materno VARCHAR(45), IN p_telefono VARCHAR(45),
    IN p_correo_electronico VARCHAR(45), IN p_contrasena VARCHAR(45), IN p_fecha_registro DATE,
    IN p_fecha_nacimiento DATE, IN p_idDistrito INT, IN p_idEstado INT, IN p_tipo INT
)
BEGIN
    INSERT INTO usuario (dni, nombre, apellido_paterno, apellido_materno, telefono, 
                         correo_electronico, contrasena, fecha_registro, fecha_nacimiento, 
                         idDistrito, idEstado)
    VALUES (p_dni, p_nombre, p_apellido_paterno, p_apellido_materno, p_telefono, 
            p_correo_electronico, p_contrasena, p_fecha_registro, p_fecha_nacimiento, 
            p_idDistrito, p_idEstado);
    
    SET p_idUsuario = LAST_INSERT_ID();
    
    INSERT INTO usuario_X_tipo (idUsuario, idTipo_usuario)
    VALUES (p_idUsuario, p_tipo);
    
END //

CREATE PROCEDURE SP_LEER_USUARIO(IN p_idUsuario INT)
BEGIN
    SELECT 
        u.*,                               
        e.idEstado_usuario,                
        e.estado AS nombre_estado,         
        tu.idTipo_usuario,                 
        tu.nombre AS nombre_tipo_usuario  
    FROM usuario u
    INNER JOIN estado_usuario e ON u.idEstado = e.idEstado_usuario
    INNER JOIN usuario_x_tipo uxt ON u.idUsuario = uxt.idUsuario
    INNER JOIN tipo_usuario tu ON uxt.idTipo_usuario = tu.idTipo_usuario
    WHERE u.idUsuario = p_idUsuario;
END //

CREATE PROCEDURE SP_ACTUALIZAR_USUARIO(
    IN p_idUsuario INT,
    IN p_dni VARCHAR(45),
    IN p_nombre VARCHAR(45),
    IN p_apellido_paterno VARCHAR(45),
    IN p_apellido_materno VARCHAR(45),
    IN p_telefono VARCHAR(45),
    IN p_correo_electronico VARCHAR(45),
    IN p_contrasena VARCHAR(45),
    IN p_fecha_nacimiento DATE,
    IN p_idDistrito INT,
    IN p_idEstado INT
)
BEGIN
    UPDATE usuario SET 
        dni = p_dni, nombre = p_nombre, apellido_paterno = p_apellido_paterno,
        apellido_materno = p_apellido_materno, telefono = p_telefono,
        correo_electronico = p_correo_electronico, contrasena = p_contrasena,
        fecha_nacimiento = p_fecha_nacimiento, idDistrito = p_idDistrito, idEstado = p_idEstado
    WHERE idUsuario = p_idUsuario;
END //

CREATE PROCEDURE SP_ELIMINAR_USUARIO(IN p_idUsuario INT)
BEGIN
    -- Asumiendo que en la tabla estado_usuario existe el nombre 'ELIMINADO'
    UPDATE usuario 
    SET idEstado = (SELECT idEstado_usuario FROM estado_usuario WHERE estado = 'ELIMINADO' LIMIT 1)
    WHERE idUsuario = p_idUsuario;
END //

CREATE PROCEDURE SP_LISTAR_USUARIOS()
BEGIN
    SELECT * FROM usuario;
    SELECT 
        u.*,                               
        e.idEstado_usuario,                
        e.estado AS nombre_estado,         
        tu.idTipo_usuario,                 
        tu.nombre AS nombre_tipo_usuario  
    FROM usuario u
    INNER JOIN estado_usuario e ON u.idEstado = e.idEstado_usuario
    INNER JOIN usuario_x_tipo uxt ON u.idUsuario = uxt.idUsuario
    INNER JOIN tipo_usuario tu ON uxt.idTipo_usuario = tu.idTipo_usuario;
END //
-- -----------------------------------------------------------
CREATE PROCEDURE SP_LEER_TIPO_USUARIO(IN p_idTipoUsuario INT)
BEGIN
    SELECT * FROM tipo_usuario WHERE idTipo_usuario = p_idTipoUsuario;
END //

CREATE PROCEDURE SP_LEER_TIPO_USUARIO_X_TIPO(IN p_TipoUsuario VARCHAR(45))
BEGIN
    SELECT * FROM tipo_usuario t WHERE t.nombre = p_TipoUsuario;
END //
-- -----------------------------------------------------------
CREATE PROCEDURE SP_LEER_ESTADO_USUARIO(IN p_idEstadoUsuario INT)
BEGIN
    SELECT * FROM estado_usuario WHERE idEstado_usuario = p_idEstadoUsuario;
END //
-- -------------------------------------------------------------------
CREATE PROCEDURE SP_INSERTAR_CLIENTE(IN p_id_usuario int, IN p_puntos_bonus INT)
BEGIN
    INSERT INTO cliente (idCliente, puntos_bonus)
    VALUES (p_id_usuario, p_puntos_bonus);
END //
-- -----------------------------------------------------------------------------
CREATE PROCEDURE SP_INSERTAR_ANFITRION(IN p_id_usuario INT, IN p_razon VARCHAR(45), IN p_ruc VARCHAR(45),
	IN p_cuenta VARCHAR(45), IN p_idBanco INT)
BEGIN
    INSERT INTO anfitrion (idAnfitrion, razon_social, ruc, cuenta_bancaria, idBanco)
    VALUES (p_id_usuario, p_razon, p_ruc, p_cuenta, p_idBanco);
END //

DELIMITER ;


-- -----------------------------------------------------
-- PROCEDURES PARA CAPA DE UBICACION
-- -----------------------------------------------------

DELIMITER //
CREATE PROCEDURE SP_INSERTAR_REGION(
    OUT p_idRegion INT,
    IN p_nombre VARCHAR(45)
)
BEGIN
    INSERT INTO region (nombre) VALUES (p_nombre);
    SET p_idRegion = LAST_INSERT_ID();
END //

CREATE PROCEDURE SP_LEER_REGION(
    IN p_idRegion INT
)
BEGIN
    SELECT idRegion, nombre 
    FROM region 
    WHERE idRegion = p_idRegion;
END //

CREATE PROCEDURE SP_ACTUALIZAR_REGION(
    IN p_idRegion INT,
    IN p_nombre VARCHAR(45)
)
BEGIN
    UPDATE region 
    SET nombre = p_nombre 
    WHERE idRegion = p_idRegion;
END //

CREATE PROCEDURE SP_ELIMINAR_REGION(
    IN p_idRegion INT
)
BEGIN
    DELETE FROM region WHERE idRegion = p_idRegion;
END //

CREATE PROCEDURE SP_LISTAR_REGIONES()
BEGIN
    SELECT idRegion, nombre FROM region;
END //

-- --------------------------------------------------------

CREATE PROCEDURE SP_INSERTAR_DISTRITO(OUT p_idDistrito INT, IN p_nombre VARCHAR(45), IN p_idRegion INT)
BEGIN
    INSERT INTO distrito (nombre, idRegion) VALUES (p_nombre, p_idRegion);
    SET p_idDistrito = LAST_INSERT_ID();
END //

CREATE PROCEDURE SP_LEER_DISTRITO(IN p_idDistrito INT)
BEGIN
    SELECT d.idDistrito, d.nombre AS nombre_distrito, r.idRegion, r.nombre AS nombre_region
    FROM distrito d
    INNER JOIN region r ON d.idRegion = r.idRegion
    WHERE d.idDistrito = p_idDistrito;
END //

CREATE PROCEDURE SP_BUSCAR_DISTRITO_POR_NOMBRE(
    IN p_nombre VARCHAR(45)
)
BEGIN
    SELECT d.idDistrito, d.nombre AS nombre_distrito, r.idRegion, r.nombre AS nombre_region
    FROM distrito d
    INNER JOIN region r ON d.idRegion = r.idRegion
    WHERE d.nombre = p_nombre
    LIMIT 1;
END //

CREATE PROCEDURE SP_LISTAR_DISTRITOS()
BEGIN
    SELECT d.idDistrito, d.nombre AS nombre_distrito, r.idRegion, r.nombre AS nombre_region
    FROM distrito d
    INNER JOIN region r ON d.idRegion = r.idRegion;
END //

CREATE PROCEDURE SP_ACTUALIZAR_DISTRITO(
    IN p_idDistrito INT,
    IN p_nombre VARCHAR(45),
    IN p_idRegion INT
)
BEGIN
    UPDATE distrito 
    SET nombre = p_nombre, 
        idRegion = p_idRegion
    WHERE idDistrito = p_idDistrito;
END //

-- DELETE (Físico, ya que Region no suele tener estado "Eliminado" a menos que lo requieras)
CREATE PROCEDURE SP_ELIMINAR_DISTRITO(
    IN p_idDistrito INT
)
BEGIN
    DELETE FROM distrito WHERE idDistrito = p_idDistrito;
END //

DELIMITER ;

-- -----------------------------------------------------
-- PROCEDURES PARA CAPA DE BANCO
-- -----------------------------------------------------

DELIMITER //

CREATE PROCEDURE SP_LEER_BANCO(IN p_idBancoo INT)
BEGIN
    SELECT * FROM banco;
END //

DELIMITER ;


