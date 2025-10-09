// Sistem Penerimaan Calon Programmer

// Input nilai
let nilaiCoding = 88
let nilaiInterview =  "B" 

// Variabel hasil coding dan interview
let hasilCoding;
let hasilInterview;

// Menentukan hasil tes coding
if (nilaiCoding > 80) {
  hasilCoding = "LOLOS";
} else if (nilaiCoding >= 60 && nilaiCoding <= 80) {
  hasilCoding = "DIPERTIMBANGKAN";
} else {
  hasilCoding = "GAGAL";
}

// Menentukan hasil tes interview
if (nilaiInterview === "A" || nilaiInterview === "B") {
  hasilInterview = "LOLOS";
} else {
  hasilInterview = "GAGAL";
}

// Menentukan hasil akhir
if ((hasilCoding === "LOLOS" || hasilCoding === "DIPERTIMBANGKAN") && hasilInterview === "LOLOS") {
  console.log("Selamat Kamu Berhasil Menjadi Calon Programmer!");
} else {
  console.log("Maaf Kamu Belum Berhasil Menjadi Calon Programmer.");
}
