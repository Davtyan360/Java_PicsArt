import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientSide {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            //connect socket at 8080 port
            socket = new Socket("localhost", 8080);
            System.out.println("Connected");

            socket.setSoTimeout(15000);

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            //sending query
            System.out.println(2);
            dataOutputStream.writeUTF("GET http://localhost:80/names?q=Hamlet");
            dataOutputStream.flush();

            StringBuilder ans = new StringBuilder();

            InputStreamReader reader = new InputStreamReader(socket.getInputStream(), "ASCII");
            //getting answer
            System.out.println(1);
            for (int c = reader.read(); c != -1; c = reader.read()) {
                ans.append((char) c);
            }

            System.out.println(ans);
            //printing answer
        } catch (IOException ex) {

            System.err.println(ex);

        } finally {

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}