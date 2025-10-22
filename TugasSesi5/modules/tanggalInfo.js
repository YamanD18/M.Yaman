function getTanggalSekarang() {
  return new Date().toLocaleDateString('id-ID');
}

function getWaktuSekarang() {
  return new Date().toLocaleTimeString('id-ID');
}

module.exports = { getTanggalSekarang, getWaktuSekarang };
