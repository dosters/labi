package by.bsuir.doster;


import java.io.IOException;
import java.rmi.Remote;

public interface Hello extends Remote{
    StringBuilder aboutCountry(String clientString) throws IOException;
}
