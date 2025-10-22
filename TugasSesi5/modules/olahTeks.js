function hitungKarakter(teks) {
  return teks.length;
}

function ubahKeHurufBesar(teks) {
  return teks.toUpperCase();
}

function ubahKeHurufKecil(teks) {
  return teks.toLowerCase();
}

module.exports = { hitungKarakter, ubahKeHurufBesar, ubahKeHurufKecil };
