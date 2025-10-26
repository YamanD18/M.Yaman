import socket

server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

server_host = '127.0.0.1'  
server_port = 12345

server_socket.bind((server_host, server_port))

server_socket.listen(1)
print(f"Server berjalan di {server_host}:{server_port}")
print("Menunggu koneksi dari client...")

client_socket, client_address = server_socket.accept()
print(f"Terhubung dengan client {client_address}")

message = client_socket.recv(1024).decode()
print(f"Pesan dari client: {message}")

response = "Pesan diterima dengan baik oleh server."
client_socket.send(response.encode())

client_socket.close()
server_socket.close()
print("Koneksi ditutup.")
