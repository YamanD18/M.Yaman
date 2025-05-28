from modul.utils import load_data, save_data

FILEPATH = 'data/calon.json'

def tambah_calon(id, nama, visi):
    data = load_data(FILEPATH)
    if any(c['id'] == id for c in data):
        return False
    data.append({"id": id, "nama": nama, "visi": visi, "jumlah_suara": 0})
    save_data(FILEPATH, data)
    return True

def get_calon(id):
    data = load_data(FILEPATH)
    return next((c for c in data if c['id'] == id), None)

def tambah_suara(id):
    data = load_data(FILEPATH)
    for c in data:
        if c['id'] == id:
            c['jumlah_suara'] += 1
            break
    save_data(FILEPATH, data)

def semua_calon():
    return load_data(FILEPATH)

def calon_terbanyak():
    data = load_data(FILEPATH)
    return max(data, key=lambda x: x['jumlah_suara'], default=None)