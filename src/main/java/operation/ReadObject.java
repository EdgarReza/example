package operation;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadObject {
    Properties p = new Properties();
    public Properties getObjectRepository() throws IOException{
        //Read object repository file
    	
        InputStream stream = new FileInputStream("/Users/edgar.reza.sanchez/Desarrollos/automatizacion/object.properties");
        //load all objects
        p.load(stream);
         return p;
    }
    
}

