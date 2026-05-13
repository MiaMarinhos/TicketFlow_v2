-----------------------------------
--EVENTO
-----------------------------------
--Create


--Read


--Update


--Delete


--ListAll

--Buscar Por Titulo
DELIMITER $$

CREATE PROCEDURE SP_BUSCAR_EVENTO_TITULO(
    IN p_titulo VARCHAR(100)
)
BEGIN

SELECT
    e.*
FROM evento e
WHERE e.titulo LIKE CONCAT('%', p_titulo, '%');

END$$

DELIMITER ;

-- Filtrar Por Estado

DELIMITER $$

CREATE PROCEDURE SP_FILTRAR_EVENTO_ESTADO(
    IN p_idEstadoEvento INT
)
BEGIN

SELECT *
FROM evento
WHERE idEstado_evento = p_idEstadoEvento;

END$$

DELIMITER ;

--Aprobar evento
DELIMITER $$

CREATE PROCEDURE SP_APROBAR_EVENTO(
    IN p_idEvento INT
)
BEGIN

UPDATE evento
SET idEstado_publicacion = 2
WHERE idEvento = p_idEvento;

END$$

DELIMITER ;

-- Rechazar Evento
DELIMITER $$

CREATE PROCEDURE SP_RECHAZAR_EVENTO(
    IN p_idEvento INT
)
BEGIN

UPDATE evento
SET idEstado_publicacion = 3
WHERE idEvento = p_idEvento;

END$$

DELIMITER ;

-- Eliminar Evento como Estado
DELIMITER $$

CREATE PROCEDURE SP_ELIMINAR_EVENTO(
    IN p_idEvento INT
)
BEGIN

UPDATE evento
SET idEstado_evento = 3
WHERE idEvento = p_idEvento;

END$$

DELIMITER ;

