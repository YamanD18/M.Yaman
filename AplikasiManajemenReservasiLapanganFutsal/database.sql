-- =====================================================
-- DATABASE
-- =====================================================

DROP DATABASE IF EXISTS db_reservasi_futsal;
CREATE DATABASE db_reservasi_futsal;
USE db_reservasi_futsal;

-- =====================================================
-- TABEL LAPANGAN
-- =====================================================

CREATE TABLE lapangan (
    id_lapangan INT AUTO_INCREMENT PRIMARY KEY,
    nama_lapangan VARCHAR(50) NOT NULL,
    jenis_lapangan VARCHAR(30) NOT NULL,
    harga_per_jam DOUBLE NOT NULL,
    status_lapangan VARCHAR(20) NOT NULL
);

-- =====================================================
-- TABEL RESERVASI
-- =====================================================

CREATE TABLE reservasi (
    id_reservasi INT AUTO_INCREMENT PRIMARY KEY,
    id_lapangan INT,
    nama_pelanggan VARCHAR(100),
    tanggal DATE,
    jam_mulai TIME,
    durasi INT,
    total_bayar DOUBLE,

    CONSTRAINT fk_lapangan
    FOREIGN KEY(id_lapangan)
    REFERENCES lapangan(id_lapangan)
);

-- =====================================================
-- TABEL LOG
-- =====================================================

CREATE TABLE log_reservasi(
    id_log INT AUTO_INCREMENT PRIMARY KEY,
    aktivitas VARCHAR(255),
    waktu TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =====================================================
-- DATA AWAL
-- =====================================================

INSERT INTO lapangan
(nama_lapangan,jenis_lapangan,harga_per_jam,status_lapangan)
VALUES
('Lapangan A','Sintetis',120000,'Tersedia'),
('Lapangan B','Vinyl',150000,'Tersedia'),
('Lapangan C','Rumput',100000,'Tersedia');

-- =====================================================
-- VIEW
-- =====================================================

CREATE VIEW v_laporan_reservasi AS

SELECT

r.id_reservasi,
l.nama_lapangan,
l.jenis_lapangan,
r.nama_pelanggan,
r.tanggal,
r.jam_mulai,
r.durasi,
r.total_bayar

FROM reservasi r

JOIN lapangan l

ON r.id_lapangan=l.id_lapangan;

-- =====================================================
-- FUNCTION
-- =====================================================

DELIMITER $$

CREATE FUNCTION hitung_total_bayar
(
harga DOUBLE,
lama INT
)

RETURNS DOUBLE
DETERMINISTIC

BEGIN

RETURN harga*lama;

END$$

DELIMITER ;

-- =====================================================
-- STORED PROCEDURE
-- =====================================================

DELIMITER $$

CREATE PROCEDURE tambah_reservasi(

IN p_id_lapangan INT,
IN p_nama VARCHAR(100),
IN p_tanggal DATE,
IN p_jam TIME,
IN p_durasi INT

)

BEGIN

DECLARE harga DOUBLE;
DECLARE total DOUBLE;

SELECT harga_per_jam

INTO harga

FROM lapangan

WHERE id_lapangan=p_id_lapangan;

SET total=hitung_total_bayar(harga,p_durasi);

INSERT INTO reservasi(

id_lapangan,
nama_pelanggan,
tanggal,
jam_mulai,
durasi,
total_bayar

)

VALUES(

p_id_lapangan,
p_nama,
p_tanggal,
p_jam,
p_durasi,
total

);

END$$

DELIMITER ;

-- =====================================================
-- TRIGGER
-- =====================================================

DELIMITER $$

CREATE TRIGGER tr_log_reservasi

AFTER INSERT

ON reservasi

FOR EACH ROW

BEGIN

INSERT INTO log_reservasi(aktivitas)

VALUES(

CONCAT
(
'Reservasi baru oleh ',
NEW.nama_pelanggan,
' pada ',
NEW.tanggal
)

);

END$$

DELIMITER ;

-- =====================================================
-- TEST
-- =====================================================

CALL tambah_reservasi
(
1,
'Yaman',
'2026-07-06',
'18:00:00',
2
);

SELECT * FROM lapangan;

SELECT * FROM reservasi;

SELECT * FROM v_laporan_reservasi;

SELECT * FROM log_reservasi;