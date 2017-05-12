package common;
import java.net.URL;

import org.apache.log4j.xml.DOMConfigurator;
public class LoggerConfig {
    public void loggerConfig()
    {
    	URL u = getClass().getClassLoader().getResource("D:\\WorkSpace\\JoomlaTest\\src\\resource\\log4j.xml");
        DOMConfigurator.configure(u);
    }
}