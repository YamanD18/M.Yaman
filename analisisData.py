import random
import numpy as np
import pandas as pd

JENIS_KELAMIN = ['Laki-laki', 'Perempuan']
STATUS_BELAJAR = ['Rajin', 'Cukup', 'Malas']
KOTA = ['Jakarta', 'Bandung', 'Surabaya', 'Medan', 'Yogyakarta']
JURUSAN = ['IPA', 'IPS', 'Bahasa']
STATUS_LULUS = [0, 1]  # 0 = Tidak lulus, 1 = Lulus

def generate_data(jumlah=1000):
    data = []
    for i in range(1, jumlah + 1):
        siswa = {
            'id': i,
            'usia': random.randint(15, 20),
            'jenis_kelamin': random.choice(JENIS_KELAMIN),
            'kota': random.choice(KOTA),
            'jurusan': random.choice(JURUSAN),
            'status_belajar': random.choice(STATUS_BELAJAR),
            'nilai_ujian': random.randint(0, 100),
            'absensi': random.randint(0, 100),
            'ekstrakurikuler': random.choice(['Aktif', 'Tidak Aktif']),
            'lulus': random.choice(STATUS_LULUS)
        }
        data.append(siswa)
    return pd.DataFrame(data)

def tampilkan_statistik_numerik(df):
    print("Statistik Usia Siswa:")
    print("  Rata-rata:", df['usia'].mean())
    print("  Usia Minimum:", df['usia'].min(), "Maksimum:", df['usia'].max())

    print("\nStatistik Nilai Ujian:")
    print("  Rata-rata:", df['nilai_ujian'].mean())
    print("  Nilai Minimum:", df['nilai_ujian'].min(), "Maksimum:", df['nilai_ujian'].max())

    print("\nStatistik Absensi:")
    print("  Rata-rata:", df['absensi'].mean())
    print("  Absensi Minimum:", df['absensi'].min(), "Maksimum:", df['absensi'].max())

def tampilkan_distribusi_kategori(df):
    print("\nDistribusi Kategori:")
    kategori = ['jenis_kelamin', 'kota', 'jurusan', 'status_belajar', 'ekstrakurikuler', 'lulus']
    for k in kategori:
        distribusi = df[k].value_counts().to_dict()
        print(f"  {k.replace('_', ' ').title()}: {distribusi}")


data_siswa_df = generate_data()
tampilkan_statistik_numerik(data_siswa_df)
tampilkan_distribusi_kategori(data_siswa_df)