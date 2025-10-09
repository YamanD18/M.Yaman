// Program Pengecekan Nomor Punggung Pemain PERSEGI FC

// Input nomor punggung
let nomor = 77;
let posisi = []; // untuk menampung posisi yang cocok

// a. Nomor genap → Target Attacker
if (nomor % 2 === 0) {
  posisi.push("Target Attacker");

  // b. Nomor genap antara 50–100 → Captain Team
  if (nomor >= 50 && nomor <= 100) {
    posisi.push("Captain Team");
  }
}

// c. Nomor ganjil → Defender
if (nomor % 2 !== 0) {
  posisi.push("Defender");

  // d. Nomor ganjil lebih dari 90 → Playmaker
  if (nomor > 90) {
    posisi.push("Playmaker");
  }

  // e. Nomor ganjil kelipatan 3 dan 5 → Keeper
  if (nomor % 3 === 0 && nomor % 5 === 0) {
    posisi.push("Keeper");
  }
}

// Output hasil
if (posisi.length > 0) {
  console.log(`Nomor punggung ${nomor} dapat berfungsi sebagai: ${posisi.join(", ")}`);
} else {
  console.log(`Nomor punggung ${nomor} tidak memiliki posisi khusus.`);
}
