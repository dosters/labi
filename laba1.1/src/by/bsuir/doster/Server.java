package by.bsuir.doster;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class Server implements Hello{
    public Server() {

    }

    public static void main(String[] args) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            Server obj = new Server();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);
            System.err.println("Server ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public StringBuilder aboutCountry (String clientString) throws IOException {

        StringBuilder newString = new StringBuilder();
        BufferedReader br = null;
        br = new BufferedReader(new FileReader("C:\\Users\\Lenovo\\Desktop\\Sit-1.RMI\\Gid.txt"));
        String tmp = "";
        String temp="";
        while ((tmp = br.readLine()) != null) {
            if(tmp.equals(clientString)==true) {
                temp = br.readLine();
                break;
            }
        }
        newString.append(temp);
        return newString;
    }

}
