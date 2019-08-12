import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class PiGarageServer extends  Thread {

    private ServerSocket listenSocket;
    private int PortNumber = 0;
    public static Vector<String> keys = new Vector<>();
    public static Integer[] pins = new Integer[4];

    public static void main(String[] args){
        new PiGarageServer();
    }

    PiGarageServer(){
        LoadKeysConfig();
        LoadPinConfig();
        LoadPortConfig();
        CreateSocket();
        this.start();
    }

    public void run(){
        try{
            System.out.println("\nPiGarageServer Running :)");
            System.out.println("Port: " + PortNumber);
            System.out.println("ctrl+c to terminate server");
            System.out.println("\nLog:");

            while (true){
                Socket clientSocket = listenSocket.accept();
                new Session(clientSocket);
            }
        }
        catch (Exception e){
            System.err.println("Failed To Start Garage Server :(");
            System.exit(1);
        }
    }

    private void LoadKeysConfig(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("keys"));
            String key = reader.readLine();
            while (key != null){
                keys.add(key);
                key = reader.readLine();
            }
            reader.close();
        }
        catch (Exception e){
            System.err.println("Error: Could Not Load Keys From Configuration File :(");
            System.exit(1);
        }
    }

    private void LoadPinConfig(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("pins"));
            for(int i = 0; i < pins.length; i++){
                String pin = reader.readLine();
                if(pin != null){
                    pins[i] = Integer.parseInt(pin);
                }
            }
            reader.close();
        }
        catch (Exception e){
            System.err.println("Error: Could Not Load Pin From Configuration File :(");
            System.exit(1);
        }
    }

    private void LoadPortConfig(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("port"));
            PortNumber = Integer.parseInt(reader.readLine());
            reader.close();
        }
        catch (Exception e){
            System.err.println("Error: Port Configuration File Could Not Be Read :(");
            System.exit(1);
        }
    }

    private void CreateSocket(){
        try{
            listenSocket = new ServerSocket(PortNumber);
        }
        catch(Exception e){
            System.err.println("Error: Creating GarageServer Socket :(");
            System.exit(1);
        }
    }
}
