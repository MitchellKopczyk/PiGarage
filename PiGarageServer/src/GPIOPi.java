import java.io.PrintWriter;
import java.io.FileWriter;

public class GPIOPi {

    private static  String GPIOPath = "/sys/class/gpio";

    public static void InitializePin(Integer pinNumber){
        try{
            PrintWriter writer = new PrintWriter(new FileWriter(GPIOPath + "/export", true));
            writer.write(pinNumber.toString());
            writer.close();
        }
        catch (Exception e){
            System.err.println("Error: Could Not Initialize Pin :(");
            System.exit(1);
        }
    }

    public static void UnInitializePin(Integer pinNumber){
        try{
            PrintWriter writer = new PrintWriter(new FileWriter(GPIOPath + "/unexport", true));
            writer.write(pinNumber.toString());
            writer.close();
        }
        catch (Exception e){
            System.err.println("Error: Could Not Uninitializee Pin :(");
            System.exit(1);
        }
    }

    public static void SetDirection(Integer pinNumber, String direction){
        try{
            PrintWriter writer = new PrintWriter(new FileWriter(GPIOPath + "/gpio" + pinNumber.toString() + "/direction"));
            writer.write(direction.toLowerCase());
            writer.close();
        }
        catch (Exception e){
            System.err.println("Error: Could Not Set Direction For Pin :(");
            System.exit(1);
        }
    }


    public static void WritePin(Integer pinNumber, String value){
        try{
            PrintWriter writer = new PrintWriter(new FileWriter(GPIOPath + "/gpio" + pinNumber.toString() + "/value"));
            writer.write(value.toString());
            writer.close();
        }
        catch (Exception e){
            System.err.println("Error: Could Not Write To Pin :(");
            System.exit(1);
        }
    }
}