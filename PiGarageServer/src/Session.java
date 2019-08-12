import com.example.pigarageclient.Message;
import java.io.ObjectInputStream;
import java.net.Socket;


public class Session extends Thread {

    private Socket clientSocket;
    private ObjectInputStream in;

    Session(Socket socket){
        clientSocket = socket;
        this.run();
    }

    public void run(){
        try{
            while(true){
                in = new ObjectInputStream(clientSocket.getInputStream());
                Message read = (Message)in.readObject();
                System.out.println("UserKey: " + read.getUserKey() + "\tAction: " + read.getAction());

                if(PiGarageServer.keys.contains(read.getUserKey())){
                    if(read.getAction().equals("DOOR 1")){
                        GPIOPi.InitializePin(PiGarageServer.pins[0]);
                        GPIOPi.SetDirection(PiGarageServer.pins[0],"out");
                        GPIOPi.WritePin(PiGarageServer.pins[0],"0");
                        Thread.sleep(500);
                        GPIOPi.WritePin(PiGarageServer.pins[0],"1");
                        GPIOPi.UnInitializePin(PiGarageServer.pins[0]);
                    }
                    if(read.getAction().equals("DOOR 2")){
                        GPIOPi.InitializePin(PiGarageServer.pins[1]);
                        GPIOPi.SetDirection(PiGarageServer.pins[1],"out");
                        GPIOPi.WritePin(PiGarageServer.pins[1],"0");
                        Thread.sleep(500);
                        GPIOPi.WritePin(PiGarageServer.pins[1],"1");
                        GPIOPi.UnInitializePin(PiGarageServer.pins[1]);
                    }
                    if(read.getAction().equals("DOOR 3")){
                        GPIOPi.InitializePin(PiGarageServer.pins[2]);
                        GPIOPi.SetDirection(PiGarageServer.pins[2],"out");
                        GPIOPi.WritePin(PiGarageServer.pins[2],"0");
                        Thread.sleep(500);
                        GPIOPi.WritePin(PiGarageServer.pins[2],"1");
                        GPIOPi.UnInitializePin(PiGarageServer.pins[2]);
                    }
                    if(read.getAction().equals("DOOR 4")){
                        GPIOPi.InitializePin(PiGarageServer.pins[3]);
                        GPIOPi.SetDirection(PiGarageServer.pins[3],"out");
                        GPIOPi.WritePin(PiGarageServer.pins[3],"0");
                        Thread.sleep(500);
                        GPIOPi.WritePin(PiGarageServer.pins[3],"1");
                        GPIOPi.UnInitializePin(PiGarageServer.pins[3]);
                    }
                }
                in.close();
            }
        }
        catch (Exception e){
            //Socket Closed Exception will fire here ignore
        }
    }
}