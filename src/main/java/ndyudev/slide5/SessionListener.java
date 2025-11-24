package ndyudev.slide5;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {


    public SessionListener() {
    }
    int userOnline = 0;
    
    public void sessionCreated(HttpSessionEvent se)  { 
         System.out.println(se.getSession().getId() + " Start Session");
         userOnline++;
         System.out.println(userOnline);
         
    }


    public void sessionDestroyed(HttpSessionEvent se)  { 
         System.out.println(se.getSession().getId() + " Stop Session");
         userOnline--;
         System.out.println(userOnline);
    }
}
