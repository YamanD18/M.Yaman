from modul.pemilih import jumlah_pemilih, jumlah_sudah_memilih
from modul.calon import calon_terbanyak

def hitung_statistik():
    total = jumlah_pemilih()
    sudah = jumlah_sudah_memilih()
    persen = (sudah / total * 100) if total else 0
    pemenang = calon_terbanyak()
    return {
        "total_pemilih": total,
        "sudah_memilih": sudah,
        "partisipasi": persen,
        "pemenang": pemenang
    }