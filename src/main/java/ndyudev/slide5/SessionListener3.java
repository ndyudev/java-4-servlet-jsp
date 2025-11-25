package ndyudev.slide5;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener3 implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SessionListener3() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  {
    	 System.out.println(se.getSession().getId() + " is started");
         Integer n = (Integer)se.getSession().getServletContext().getAttribute("countUsers");
         n++;
         se.getSession().getServletContext().setAttribute("countUsers", n);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  {
    	HttpSession session = se.getSession();
    	System.out.println(session.getId() + " is stoped");
    	Integer n = (Integer)session.getServletContext().getAttribute("countUsers");
        //System.out.println(n);
    	n--;
    	session.getServletContext().setAttribute("countUsers", n);
    }
	
}
