package ndyudev.slide5;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class Slide5Listener implements ServletContextListener {

    public Slide5Listener() {
    }

    public void contextInitialized(ServletContextEvent sce)  {
    	System.out.println("App is stated");
    }


    public void contextDestroyed(ServletContextEvent sce)  {
    	System.out.println("App is stoped");
    }
	
}
