USE `ticket_flow`;
-----------------------------------
--COMPRA
-----------------------------------
--Create
DELIMETER //
CREATE PROCEDURE CREAR_COMPRA(
    IN p_idCompras INT,
    IN p_entradas_compradas INT,
    IN p_fecha_compra DATE,
    IN p_metodo_pago VARCHAR(45),
    IN p_hora_compra TIME,
    IN p_monto_parcial DOUBLE,
    IN p_monto_total DOUBLE,
    IN p_idPuntos_bonus INT,
    IN p_idCliente INT,
    IN p_idEvento INT,
    IN p_idEstado INT
)
BEGIN
    INSERT INTO compras(
        idCompras,
        entradas_compradas,
        fecha_compra,
        metodo_pago,
        hora_compra,
        monto_parcial,
        monto_total,
        idPuntos_bonus,
        idCliente,
        idEvento,
        idEstado
    )
    VALUES(
        p_idCompras,
        p_entradas_compradas,
        p_fecha_compra,
        p_metodo_pago,
        p_hora_compra,
        p_monto_parcial,
        p_monto_total,
        p_idPuntos_bonus,
        p_idCliente,
        p_idEvento,
        p_idEstado
   );
END //
DELIMETER;

--Read


--Update


--Delete


--ListAll

