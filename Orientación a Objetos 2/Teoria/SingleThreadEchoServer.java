import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadEchoServer {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java SingleThreadEchoServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        boolean listening = true;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Single-threaded echo server listening on port: " + portNumber);
            while (listening) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from: " + clientSocket.getInetAddress().getHostAddress() + ":" + clientSocket.getPort());
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received message: " + inputLine + " from " + clientSocket.getInetAddress().getHostAddress() + ":" + clientSocket.getPort());
                out.println(inputLine); // Echo back the received message
                if (inputLine.equalsIgnoreCase("")) {
                    break; // Client requested to close the connection
                }
            }
            System.out.println("Connection closed with " + clientSocket.getInetAddress().getHostAddress() + ":" + clientSocket.getPort());
        } catch (IOException e) {
            System.err.println("Problem with communication with client: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing socket: " + e.getMessage());
            }
        }
    }
}
