import socket

server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

host = '127.0.0.1' 
port = 5000

server_socket.bind((host, port))

server_socket.listen(1)
print(f"Server berjalan di {host}:{port}")
print("Menunggu koneksi dari client...")

client_socket, client_address = server_socket.accept()
print(f"Terhubung dengan client: {client_address}")

data = client_socket.recv(1024).decode()
print(f"Pesan dari client: {data}")

balasan = "Pesan diterima oleh server!"
client_socket.send(balasan.encode())

client_socket.close()
server_socket.close()
print("Koneksi ditutup.")
