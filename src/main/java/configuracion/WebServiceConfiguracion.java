package configuracion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class WebServiceConfiguracion {
    
    //private String path = System.getProperty("user.home") + File.separator + ".entrenamosuy" + File.separator +  ".properties.txt";
    private HashMap<String, String> configs;
    
    public WebServiceConfiguracion(){
        configs = new HashMap<>();
        configs.put("#WS_IP", "localhost");
        configs.put("#WS_PORT", "3001");
    }
    
    public String getConfigOf(String nombre) {
        return configs.get(nombre); 
    }
}
