package props;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class TestConfigurationProps {
    public static void main(String[] args) {
        ResourceBundle config = ResourceBundle.getBundle("configuration");
        String nomAdmin = config.getString("configuration.nom");
        Enumeration<String> enumeration = config.getKeys();
        while (enumeration.hasMoreElements()){
            String key = enumeration.nextElement();
            System.out.println(key +" ");
        }
        System.out.println(nomAdmin);


    }
}
