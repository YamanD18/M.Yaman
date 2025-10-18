import socket

client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

host = '127.0.0.1' 
port = 5000

client_socket.connect((host, port))
print(f"Terhubung ke server di {host}:{port}")

pesan = input("Masukkan pesan ke server: ")
client_socket.send(pesan.encode())

data = client_socket.recv(1024).decode()
print(f"Balasan dari server: {data}")

client_socket.close()