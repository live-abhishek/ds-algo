import socket


def main():
    host = socket.gethostname()
    port = 4567
    encoding = "utf-8"

    s = socket.socket()
    s.connect((host, port))

    message = input("=>")
    while message != "q":
        encodedMessage = message.encode(encoding)
        s.send(encodedMessage)
        data = s.recv(1024)
        decodedMessage = data.decode(encoding)
        print("Received from server:", decodedMessage)
        message = input("=>")
    s.close()


if __name__ == "__main__":
    main()
