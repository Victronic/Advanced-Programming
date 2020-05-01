import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//clasa serverului, aceasta doar asteapta clienti la portul prefedifinit
public class GameServer {
    public static final int PORT = 8100;
    public GameServer() throws IOException{
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println("Waiting for a client...");
                Socket socket = serverSocket.accept();
                //fiecare client are un thread propriu care se va ocupa de opertiile sale
                new ClientThread(socket).start();
            }
        }catch (IOException e){
            System.err.println("Ooops..."+e);
        }
        finally {
            serverSocket.close();
        }
    }
}
