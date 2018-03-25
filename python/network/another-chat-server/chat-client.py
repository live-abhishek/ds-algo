import socket
import threading


def startReceiving(chatClient):
    chatClient.recieve()


class ChatClient:
    def __init__(self):
        self.host = socket.gethostname()
        self.port = 4561
        self.encoding = "utf-8"
        self.socket = socket.socket()
        self.running = False

    def start(self):
        self.socket.connect((self.host, self.port))
        threading.Thread(target=startReceiving,
                         args=(self,), daemon=True).start()
        msg = input("<=")
        while msg is not "q":
            encodedData = msg.encode(self.encoding)
            self.socket.send(encodedData)
            msg = input("<=")
        self.running = False
        self.socket.close()

    def recieve(self):
        self.running = True
        while self.running:
            data = self.socket.recv(1024)
            decodedMsg = data.decode(self.encoding)
            print(decodedMsg)


if __name__ == "__main__":
    chatClient = ChatClient()
    chatClient.start()
