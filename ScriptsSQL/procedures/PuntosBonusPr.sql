-----------------------------------
--PUNTOS BONUS
-----------------------------------

--Create
DELIMITER $$
CREATE PROCEDURE sp_puntos_bonus_insert (
    OUT p_id INT,
    IN p_puntos_canjeables INT,
    IN p_descuento INT
)
BEGIN
INSERT INTO puntos_bonus (
    puntos_canjeables, descuento
)
VALUES (
           p_puntos_canjeables, p_descuento
       );
SET p_id = LAST_INSERT_ID();
END$$
DELIMITER ;

--Read
DELIMITER $$
CREATE PROCEDURE sp_puntos_bonus_findById (
    IN p_idPuntos_bonus INT
)
BEGIN
SELECT
    idPuntos_bonus, puntos_canjeables, descuento
FROM puntos_bonus
WHERE idPuntos_bonus = p_idPuntos_bonus;
END$$
DELIMITER ;

--Update
DELIMITER $$
CREATE PROCEDURE sp_puntos_bonus_update (
    IN p_idPuntos_bonus INT,
    IN p_puntos_canjeables INT,
    IN p_descuento INT
)
BEGIN
UPDATE puntos_bonus
SET
    puntos_canjeables = p_puntos_canjeables,
    descuento = p_descuento
WHERE idPuntos_bonus = p_idPuntos_bonus;
END$$
DELIMITER ;

--Delete
DELIMITER $$
CREATE PROCEDURE sp_puntos_bonus_delete (
    IN p_idPuntos_bonus INT
)
BEGIN
DELETE FROM puntos_bonus
WHERE idPuntos_bonus = p_idPuntos_bonus;
END$$
DELIMITER ;

--ListAll
DELIMITER $$
CREATE PROCEDURE sp_puntos_bonus_listAll ()
BEGIN
SELECT
    idPuntos_bonus, puntos_canjeables, descuento
FROM puntos_bonus;
END$$
DELIMITER ;
