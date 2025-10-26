import socket

client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

server_host = '127.0.0.1'
server_port = 12345

client_socket.connect((server_host, server_port))
print("Terhubung ke server.")

message = input("Masukkan pesan untuk server: ")
client_socket.send(message.encode())

response = client_socket.recv(1024).decode()
print(f"Balasan dari server: {response}")

client_socket.close()
