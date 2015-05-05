package by.bsuir.doster;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


public class Client {

    public Client() {

    }

    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Hello stub = (Hello) registry.lookup("Hello");
            StringBuilder receiveString=null;
            int ch=-1;
            do {
                System.out.println("1)Russia \n\r 2)Azeyrbaydzhan \n\r 3)Haiti \n\r 4)Belarus \n\r 5)USA \n\r 6)Exit \n\r");
                Scanner scanner = new Scanner(System.in);
                ch=scanner.nextInt();
                if(ch<1 && ch>6)
                {
                    System.out.println( "не верный ввод");
                }
                else
                {
                    switch (ch) {
                        case 1: {
                            receiveString = stub.aboutCountry("Russia");
                            System.out.println(receiveString);
                            break;
                        }
                        case 2: {
                            receiveString = stub.aboutCountry("Azeyrbaydzhan");
                            System.out.println(receiveString);
                            break;
                        }
                        case 3: {
                            receiveString = stub.aboutCountry("Haiti");
                            System.out.println(receiveString);
                            break;
                        }
                        case 4: {
                            receiveString = stub.aboutCountry("Belarus");
                            System.out.println(receiveString);
                            break;
                        }
                        case 5: {
                            receiveString = stub.aboutCountry("USA");
                            System.out.println(receiveString);
                            break;
                        }
                        case 6: {
                            ch = 0;
                            break;
                        }
                    }
                }
            }while(ch!=0);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

    }



}
