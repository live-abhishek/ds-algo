import socket


def main():
    host = socket.gethostname()
    port = 7895
    encoding = "utf-8"

    server = (socket.gethostname(), 7894)

    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    s.bind((host, port))

    message = input("=>")
    while message is not "q":
        encodedMessage = message.encode(encoding)
        s.sendto(encodedMessage, server)
        data, addr = s.recvfrom(1024)
        decodedMessage = data.decode(encoding)
        print("Received from server:", decodedMessage)
        message = input("=>")
    s.close()


if __name__ == "__main__":
    main()
