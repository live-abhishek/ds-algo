import socket


def main():
    host = socket.gethostname()
    port = 7894
    encoding = "utf-8"

    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    s.bind((host, port))
    print("Server started")

    while True:
        data, addr = s.recvfrom(1024)
        decodedMessage = data.decode(encoding)
        print("message from:", str(addr))
        print("received:", decodedMessage)
        messageToSend = decodedMessage.encode(encoding).upper()
        print("sending:", messageToSend)
        s.sendto(messageToSend, addr)
    s.close()


if __name__ == "__main__":
    main()
