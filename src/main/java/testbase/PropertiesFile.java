package testbase;

import org.tinylog.Logger;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {
    private PropertiesFile() {
        throw new IllegalStateException("TestBase.PropertiesFile");
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
    public static void setProperties(String propVal,String val) {
        try (OutputStream outputStream = new FileOutputStream(propertiesPath)) {
            prop.setProperty(propVal,val);
            prop.store(outputStream,null);
            propvalue = prop.getProperty(propVal);
            Logger.info("Browser is setted as  :"+propvalue);
        } catch (Exception e) {
            Logger.error("Messege : "+e.getMessage());
            Logger.error("Cause : "+e.getCause());
        }
    }
}
