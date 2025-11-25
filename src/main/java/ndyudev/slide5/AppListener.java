package ndyudev.slide5;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AppListener() {
        
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("App is stated");
    	Integer userOnline = 0;
    	sce.getServletContext().setAttribute("countUsers", userOnline);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("App is stoped");
    }
	
}
