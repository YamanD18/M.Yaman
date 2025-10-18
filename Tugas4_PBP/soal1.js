let studentsScore = [
  { name: 'Andi', score: 90 },
  { name: 'Rudi', score: 80 },
  { name: 'Dira', score: 100 }
];


let nilaiTertinggi = studentsScore[0];

for (let i = 1; i < studentsScore.length; i++) {
  if (studentsScore[i].score > nilaiTertinggi.score) {
    nilaiTertinggi = studentsScore[i];
  }
}

console.log(`Siswa dengan nilai tertinggi adalah ${nilaiTertinggi.name} dengan nilai ${nilaiTertinggi.score}`);
