import socket
import threading


def startClient(chatClient):
    chatClient.startClient()


class ChatClient:
    def __init__(self, server, conn, addr):
        self.server = server
        self.conn = conn
        self.addr = addr

    def startClient(self):
        while True:
            try:
                data = self.conn.recv(1024)
                self.server.boardcast(self, data)
            except:
                self.server.removeClient(self)
                break


class ChatServer:
    def __init__(self):
        self.lock = threading.Lock()
        self.clients = []
        self.host = socket.gethostname()
        self.port = 4561
        self.serverSocket = socket.socket()

    def startServer(self):
        self.serverSocket.bind((self.host, self.port))
        self.serverSocket.listen(5)
        print("Server intialized. Waiting for clients...")
        while True:
            conn, addr = self.serverSocket.accept()
            print(addr, "request recieved...")
            chatClient = ChatClient(self, conn, addr)
            self.addClient(chatClient)
        self.serverSocket.close()

    def boardcast(self, broadcaster, message):
        for client in self.clients:
            if client.addr != broadcaster.addr:
                client.conn.send(message)

    def addClient(self, client):
        # synchronize this
        self.lock.acquire()
        try:
            threading.Thread(target=startClient, args=(client,)).start()
            self.clients.append(client)
            print(client.addr, "connected...")
        finally:
            self.lock.release()

    def removeClient(self, clientToRemove):
        # synchronize this
        self.lock.acquire()
        try:
            newClients = []
            for client in self.clients:
                if client.addr != clientToRemove.addr:
                    newClients.append(client)
            self.clients = newClients
            clientToRemove.conn.close()
            print(clientToRemove.addr, "removed...")
        finally:
            self.lock.release()


if __name__ == "__main__":
    server = ChatServer()
    server.startServer()
