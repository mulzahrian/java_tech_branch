CREATE PROCEDURE InsertDataIntoTableC()
BEGIN
    
    INSERT INTO TABLE_C (ID, CARDNUMBER, ISS, ACQ, DEST, STATUS_A, STATUS_ISS, STATUS_ACQ, STATUS_DEST)
    SELECT ID, CARDNUMBER, ISS, ACQ, DEST, STATUS, NULL, NULL, NULL
    FROM TABLE_A;

    INSERT INTO TABLE_C (ID, CARDNUMBER, ISS, ACQ, DEST, STATUS_A, STATUS_ISS, STATUS_ACQ, STATUS_DEST)
    SELECT ID, CARDNUMBER, ISS, ACQ, DEST, STATUS, SOURCE, NULL, NULL
    FROM TABLE_B;
DELIMITER ;