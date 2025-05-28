from modul import pemilih, calon, voting, statistik

def menu():
    while True:
        print("\n=== E-Voting Ketua Organisasi Mahasiswa ===")
        print("1. Tambah Pemilih")
        print("2. Tambah Calon")
        print("3. Voting")
        print("4. Lihat Hasil Sementara")
        print("5. Statistik Pemilu")
        print("0. Keluar")
        pilihan = input("Pilih menu: ")

        if pilihan == "1":
            id = input("ID Pemilih: ")
            nama = input("Nama: ")
            jurusan = input("Jurusan: ")
            if pemilih.tambah_pemilih(id, nama, jurusan):
                print("Pemilih ditambahkan.")
            else:
                print("ID sudah terdaftar.")

        elif pilihan == "2":
            id = input("ID Calon: ")
            nama = input("Nama: ")
            visi = input("Visi Misi: ")
            if calon.tambah_calon(id, nama, visi):
                print("Calon ditambahkan.")
            else:
                print("ID sudah terdaftar.")

        elif pilihan == "3":
            id_pemilih = input("ID Pemilih: ")
            id_calon = input("ID Calon: ")
            print(voting.proses_voting(id_pemilih, id_calon))

        elif pilihan == "4":
            data = calon.semua_calon()
            print("\n=== Hasil Sementara ===")
            for c in data:
                print(f"{c['nama']} ({c['id']}) - Suara: {c['jumlah_suara']}")

        elif pilihan == "5":
            s = statistik.hitung_statistik()
            print("\n=== Statistik Pemilu ===")
            print(f"Total Pemilih      : {s['total_pemilih']}")
            print(f"Sudah Memilih      : {s['sudah_memilih']}")
            print(f"Partisipasi        : {s['partisipasi']:.2f}%")
            if s['pemenang']:
                print(f"Pemenang sementara : {s['pemenang']['nama']} ({s['pemenang']['jumlah_suara']} suara)")
            else:
                print("Belum ada suara masuk.")

        elif pilihan == "0":
            break
        else:
            print("Pilihan tidak valid.")

if __name__ == "__main__":
    menu()