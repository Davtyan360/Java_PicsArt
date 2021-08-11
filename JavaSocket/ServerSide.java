import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;


public class ServerSide {
    public static void main(String[] args) throws MalformedURLException {
        try (ServerSocket server = new ServerSocket(8080)) {

            System.out.println("Server is active");

            while (true) {

                try (Socket connection = server.accept()) {

                    //getting request
                    DataInputStream dataInputStream = new DataInputStream(connection.getInputStream());


                    String urlString = dataInputStream.readUTF().split("\\s+")[1];
                    URL url = new URL(urlString);
                    System.out.println(url.getQuery().split("=")[1]);
                    Writer out = new OutputStreamWriter(connection.getOutputStream());
                    String answer = "GEt";
                    //sending answer
                    out.write(answer + "\r\n");
                    out.flush();
                }
                catch (IOException ex) {

                    ex.printStackTrace();

                }
            }
        }
        catch (IOException ex) {

            ex.printStackTrace();

        }
    }
}
