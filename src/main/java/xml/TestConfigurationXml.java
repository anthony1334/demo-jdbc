package xml;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.util.Enumeration;
import java.util.Iterator;


public class TestConfigurationXml {
    public static void main(String[] args) {

        Configurations configs = new Configurations();
        Configuration config = null;
        try {
            config = configs.xml("configuration.xml");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        String configuration = config.getString("database.host");
        Iterator<String> key = config.getKeys();
        while (key.hasNext()){
            String cle = key.next();
            String value = config.getString(cle);
            System.out.println(cle +" :" + value);
        }




        System.out.println(configuration);



    }
}
