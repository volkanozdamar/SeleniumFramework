package screenshot;

import org.openqa.selenium.WebDriver;
import org.tinylog.Logger;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;

public class TakeScreenshot {
    /***
     * Utility classes should not have public constructors
     */
    private TakeScreenshot() {
        throw new IllegalStateException("Utility class");
    }

    static Screenshot screenshot;
    static String imagesPath = System.getProperty("user.dir")+"/src/resources/screenshots/";
    public static void fullpageScreenshot(WebDriver driver){
        try{
            screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(driver);
            BufferedImage image = screenshot.getImage();
            ImageIO.write(image, "PNG", new File( imagesPath+new Date()+".png"));
            Logger.info("Screenshot Taken");
        }
        catch (Exception e){
            Logger.error("Image Error");
        }

    }
}
