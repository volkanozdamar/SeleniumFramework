package TestBase;

import org.tinylog.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {
    private PropertiesFile() {
        throw new IllegalStateException("TestBase.PropertiesFile");
    }
    public static void main(String[] args) {

    }
    static Properties prop = new Properties();
    static String propertiesPath = System.getProperty("user.dir")+"/src/main/resources/config.properties";
    static String browser;
    static String propvalue;
    public static String getProperties(String val){
        try {
            InputStream input = new FileInputStream(propertiesPath);
            prop.load(input);
            propvalue = prop.getProperty(val);
            Logger.info("Default "+val+" is :"+propvalue);
            input.close();
        }
        catch (Exception e){
            Logger.error("Messege : "+e.getMessage());
            Logger.error("Cause : "+e.getCause());
        }
        return propvalue;


    }
    public static void setProperties(String propVal,String val){
        try {
            OutputStream outputStream = new FileOutputStream(propertiesPath);
            prop.setProperty(propVal,val);
            prop.store(outputStream,null);
            propvalue = prop.getProperty(propVal);
            Logger.info("Browser is setted as  :"+propvalue);
            outputStream.close();
        }
        catch (Exception e){
            Logger.error("Messege : "+e.getMessage());
            Logger.error("Cause : "+e.getCause());
        }
    }
}
