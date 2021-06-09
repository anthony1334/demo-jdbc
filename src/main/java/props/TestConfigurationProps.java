package props;

import java.util.ResourceBundle;

public class TestConfigurationProps {
    public static void main(String[] args) {
        ResourceBundle config = ResourceBundle.getBundle("configuration");
        String nomAdmin = config.getString("configuration.nom");
        System.out.println(nomAdmin);


    }
}
