// Program Analisa Anggota Sindikat Mafia

// Input data
let nama =  "M.Yaman"
let umur =  41
let tempat = "Nevada"
let tabungan = 100000000

// Logika pengecekan
if (umur > 40 && ["Nevada", "New York", "Havana"].includes(tempat) && tabungan > 10000000) {
  console.log(`${nama} kemungkinan adalah seorang anggota mafia dengan pangkat Don.`);
} 
else if (umur >= 25 && umur <= 40 && ["New Jersey", "Manhattan", "Nevada"].includes(tempat) && tabungan >= 1000000 && tabungan <= 2000000) {
  console.log(`${nama} kemungkinan adalah seorang anggota mafia dengan pangkat Underboss.`);
} 
else if (umur >= 18 && umur <= 24 && ["California", "Detroit", "Boston"].includes(tempat) && tabungan < 1000000) {
  console.log(`${nama} kemungkinan adalah seorang anggota mafia dengan pangkat Capo.`);
} 
else {
  console.log(`${nama} tidak mencurigakan.`);
}
