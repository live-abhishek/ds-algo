import socket
import threading


class ChatClient:
    def __init__(self, server, conn, addr):
        self.server = server
        self.conn = conn
        self.addr = addr
        self.__initClient__()

    def __initClient__(self):
        pass


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
            print(addr, "connected")
            ChatClient(self, conn, addr)

    def boardcast(self, message, broadcaster):
        for client in self.clients:
            if client.addr != broadcaster.addr:
                client.send(message)

    def addClient(self, client):
        # synchronize this
        self.lock.acquire()
        try:
            self.clients.append(client)
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
        finally:
            self.lock.release()


server = ChatServer()
server.startServer()
