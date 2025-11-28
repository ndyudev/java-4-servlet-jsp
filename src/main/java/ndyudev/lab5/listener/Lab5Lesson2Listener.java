package ndyudev.lab5.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class Lab5Lesson2Listener implements ServletContextListener, HttpSessionListener {
	private static int visitor = 0;

	/**
	 * Default constructor.
	 */
	public Lab5Lesson2Listener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext application = se.getSession().getServletContext();
		visitor++;

		application.setAttribute("visitors", visitor);
		System.out.println("Bắt đầu" + se.getSession().getId() + "Ng ghé thăm" + visitor);
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext application = se.getSession().getServletContext();
		visitor--;

		application.setAttribute("visitors", visitor);

		System.out.println("Kết thúc" + se.getSession().getId() + "Ng ghé thăm" + visitor);
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		application.setAttribute("visitors", visitor);
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
