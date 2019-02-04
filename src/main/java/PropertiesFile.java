import org.tinylog.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {
    static Properties prop = new Properties();
    static String propertiesPath = System.getProperty("user.dir")+"/src/main/resources/config.properties";
    static String browser;
    public static void main(String[] args) {
        getProperties();
        setProperties("chrome");
    }
    public static String getProperties(){
        try{
            InputStream input = new FileInputStream(propertiesPath);
            prop.load(input);
            browser = prop.getProperty("browser");
            Logger.info("Default browser is :"+browser);
        }
        catch (Exception e){
            Logger.error(e);
        }
        return browser;
    }
    public static void setProperties(String val){
        try {
            OutputStream outputStream = new FileOutputStream(propertiesPath);
            prop.setProperty("browser",val);
            prop.store(outputStream,null);
            browser = prop.getProperty("browser");
            Logger.info("Browser is setted as  :"+browser);
        }
        catch (Exception e){
            Logger.error(e);
        }


    }
}
