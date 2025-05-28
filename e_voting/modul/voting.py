from modul.pemilih import get_pemilih, set_sudah_memilih
from modul.calon import get_calon, tambah_suara

def proses_voting(id_pemilih, id_calon):
    pemilih = get_pemilih(id_pemilih)
    if not pemilih:
        return "ID Pemilih tidak ditemukan."
    if pemilih["sudah_memilih"]:
        return "Pemilih sudah pernah memilih."
    calon = get_calon(id_calon)
    if not calon:
        return "ID Calon tidak ditemukan."

    tambah_suara(id_calon)
    set_sudah_memilih(id_pemilih)
    return "Voting berhasil."