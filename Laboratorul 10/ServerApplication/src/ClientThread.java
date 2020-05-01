import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
//clasa thread care se ocupa de un client
public class ClientThread extends Thread {
    private final Socket socket ;
    public ClientThread (Socket socket){
        this.socket=socket;
    }
    public void run(){
        try{
            //un reader si writer
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            //citim requestul transmitind un mesaj corespunzator
            String request=in.readLine();
            String raspuns="Server received the request ... ";
            //daca citim stop sau exit comunicarea se incheie
            //in cazul stop threadul trebuie orpit
            //in cazul exit clientul a iesit deci nu mai are rost ca tredul sa astepte comenzi
            while(!"stop".equals(request) && !"exit".equals(request)){
                out.println(raspuns);
                out.flush();
                request=in.readLine();
            }
            //daca se citeste stop se va transmite care client ca serverul s-a oprit(deci acest nu mai poate scrie comenzi)
            if("stop".equals(request)){
            raspuns="Server Stopped";
            out.println(raspuns);
            out.flush();
            }
        }catch(IOException e){
            System.err.println("Communication error "+ e);
        }finally{
            try{
                socket.close();
            }catch (IOException e) {System.err.println(e);}
        }
    }
}
