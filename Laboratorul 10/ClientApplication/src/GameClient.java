import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//clasa client care va comunica cu un thread al serverului
public class GameClient {
    public static void main(String[] args) throws IOException{
        //stabilim portul si serverul
        String serverAddress = "127.0.0.1";
        int PORT = 8100;
        try(
            //crez un sockec un reader si un writer
            Socket socket = new Socket(serverAddress,PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            //folosesc scan pentru a citi de la tastatura
            Scanner scan = new Scanner(System.in);
            String request = scan.nextLine();
            //cat timp nu am citit exit va continua comunicarea
            //note: daca citim stop si serverul se opreste(transmitand un mesaj corespunzator)
            //orice comanda de dupa va rezulta in eraore deoarece nu mai are loc comunicare(serverul s-a oprit)
            while(!"exit".equals(request)){
                out.println(request);
                String response = in.readLine();
                System.out.println(response);
                request=scan.nextLine();
            }
            out.println(request);// in cazul in care citim exit clientul se opreste dar transmite acest lucru serverului(urmand ca acesta sa  se opreasca si el)


        }catch (UnknownHostException e){
            System.err.println("No server listening.." + e);
        }

    }
}
