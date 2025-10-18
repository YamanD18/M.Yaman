var motoGP = [
  {
    circuit: 'Losail',
    location: 'Qatar',
    winner: {
      firstName: 'Andrea',
      lastName: 'Dovizioso',
      country: 'Italy'
    }
  },
  {
    circuit: 'Autodromo',
    location: 'Argentina',
    winner: {
      firstName: 'Cal',
      lastName: 'Crutchlow',
      country: 'UK'
    }
  },
  {
    circuit: 'De Jerez',
    location: 'Spain',
    winner: {
      firstName: 'Valentino',
      lastName: 'Rossi',
      country: 'Italy'
    }
  },
  {
    circuit: 'Mugello',
    location: 'Italy',
    winner: {
      firstName: 'Andrea',
      lastName: 'Dovizioso',
      country: 'Italy'
    }
  }
];

let daftarJuara = {};

motoGP.forEach(event => {
  let country = event.winner.country;
  let winnerData = {
    name: `${event.winner.firstName} ${event.winner.lastName}`,
    winLocation: `${event.circuit}, ${event.location}`
  };

  if (!daftarJuara[country]) {
    daftarJuara[country] = {
      winningRacers: [winnerData],
      totalWin: 1
    };
  } 

  else {
    daftarJuara[country].winningRacers.push(winnerData);
    daftarJuara[country].totalWin++;
  }
});

console.log(JSON.stringify(daftarJuara, null, 2));