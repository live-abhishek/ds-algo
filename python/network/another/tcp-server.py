import socket


def main():
    host = socket.gethostname()
    port = 4567
    encoding = "utf-8"

    s = socket.socket()
    s.bind((host, port))
    s.listen(1)
    c, addr = s.accept()

    print("Connection from:", str(addr))
    while True:
        data = c.recv(1024)
        if not data:
            break
        decodedString = data.decode(encoding)
        print("from connected user:", decodedString)
        dataToSend = decodedString.upper()
        print('sending:', dataToSend)
        c.send(dataToSend.encode(encoding))
    c.close()


if __name__ == "__main__":
    main()
