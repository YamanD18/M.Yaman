const readline = require('readline-sync');
const kalkulator = require('./modules/kalkulator');
const olahTeks = require('./modules/olahTeks');
const tanggalInfo = require('./modules/tanggalInfo');
const konversiSatuan = require('./modules/konversiSatuan');

console.log("=== Aplikasi Modularisasi Node.js ===");

let lanjut = true;

while (lanjut) {
  console.log(`
1. Kalkulator
2. Olah Teks
3. Info Tanggal & Waktu
4. Konversi Satuan
0. Keluar
`);

  const pilihan = readline.question("Pilih menu (0-4): ");

  switch (pilihan) {
    case "1":
      console.log("\n=== Modul Kalkulator ===");
      const a = parseFloat(readline.question("Masukkan angka pertama: "));
      const b = parseFloat(readline.question("Masukkan angka kedua: "));
      console.log(`
                    Hasil Penjumlahan: ${kalkulator.tambah(a, b)}
                    Hasil Pengurangan: ${kalkulator.kurang(a, b)}
                    Hasil Perkalian: ${kalkulator.kali(a, b)}
                    Hasil Pembagian: ${kalkulator.bagi(a, b)}
                    `);
      break;

    case "2":
      console.log("\n=== Modul Olah Teks ===");
      const teks = readline.question("Masukkan teks: ");
      console.log(`
                Jumlah karakter: ${olahTeks.hitungKarakter(teks)}
                Huruf besar: ${olahTeks.ubahKeHurufBesar(teks)}
                Huruf kecil: ${olahTeks.ubahKeHurufKecil(teks)}
                `);
      break;

    case "3":
      console.log("\n=== Modul Info Tanggal & Waktu ===");
      console.log(`Tanggal sekarang: ${tanggalInfo.getTanggalSekarang()}`);
      console.log(`Waktu sekarang: ${tanggalInfo.getWaktuSekarang()}\n`);
      break;

    case "4":
      console.log("\n=== Modul Konversi Satuan ===");
      const cm = parseFloat(readline.question("Masukkan panjang (cm): "));
      const meter = parseFloat(readline.question("Masukkan jarak (meter): "));
      const celsius = parseFloat(readline.question("Masukkan suhu (°C): "));
      console.log(`
            ${cm} cm = ${konversiSatuan.cmKeMeter(cm)} meter
            ${meter} meter = ${konversiSatuan.meterKeKm(meter)} km
            ${celsius}°C = ${konversiSatuan.celsiusKeFahrenheit(celsius)}°F
            `);
      break;

    case "0":
      lanjut = false;
      console.log("\nTerima kasih telah menggunakan aplikasi ini!");
      break;

    default:
      console.log("\nPilihan tidak valid, coba lagi!");
  }
}