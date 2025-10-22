function cmKeMeter(cm) {
  return cm / 100;
}

function meterKeKm(meter) {
  return meter / 1000;
}

function celsiusKeFahrenheit(celsius) {
  return (celsius * 9/5) + 32;
}

module.exports = { cmKeMeter, meterKeKm, celsiusKeFahrenheit };