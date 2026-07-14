import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server is listening on port 5000...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");
            
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Client says: " + message);
                writer.println("Server echoed: " + message);
                if (message.equals("bye")) break;
            }
            socket.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}