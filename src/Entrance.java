import java.io.IOError;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Entrance {
    public String SetNodesAndLengthConnection() {
        Scanner scanr = new Scanner(System.in);
        System.out.println("Enter the numbers of Nodes & Length connection: N,k ");
        String i = "";
        if (scanr.hasNextLine()) {
            i = scanr.nextLine();
        }
        return i;
    }
    public int[] SetRelablesString(int numbrsOfNode) throws Exception, IOException {
        int[] arr = new int[numbrsOfNode];
        int[] voidArr = new int[0];

        System.out.println("Enter the string value between 0 to 1, means relables of nodes (lengths = " + numbrsOfNode + "): ");
        Scanner scanr = new Scanner(System.in);

        int tmpVar = 0;
        try {
            while (scanr.hasNextInt()){
                int val = scanr.nextInt();
                if (val < 0 || val > 1){
                    //System.out.println("wrong number, try again...");
                    arr = Arrays.copyOf(voidArr, 0);
                }
                arr[tmpVar] = val;
                tmpVar++;
            }

        }
        /*catch(IOException e){
            System.out.println(e.getMessage());
            return voidArr;
        }*/
        /*catch (){
            throw new Exception("Number can not be empty. Try again...");
        }*/
        return arr;
     }
}
