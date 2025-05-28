from modul.utils import load_data, save_data

FILEPATH = 'data/pemilih.json'

def tambah_pemilih(id, nama, jurusan):
    data = load_data(FILEPATH)
    if any(p['id'] == id for p in data):
        return False
    data.append({"id": id, "nama": nama, "jurusan": jurusan, "sudah_memilih": False})
    save_data(FILEPATH, data)
    return True

def get_pemilih(id):
    data = load_data(FILEPATH)
    return next((p for p in data if p['id'] == id), None)

def set_sudah_memilih(id):
    data = load_data(FILEPATH)
    for p in data:
        if p['id'] == id:
            p['sudah_memilih'] = True
            break
    save_data(FILEPATH, data)

def jumlah_pemilih():
    return len(load_data(FILEPATH))

def jumlah_sudah_memilih():
    return len([p for p in load_data(FILEPATH) if p['sudah_memilih']])