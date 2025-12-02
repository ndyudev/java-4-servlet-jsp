//package ndyudev.lab5.filter;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.FilterConfig;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpFilter;
//import java.io.IOException;
//
///**
// * Servlet Filter implementation class Lab5Lesson4Filter2
// */
//public class Lab5Lesson4Filter2 extends HttpFilter implements Filter {
//       
//    /**
//     * @see HttpFilter#HttpFilter()
//     */
//    public Lab5Lesson4Filter2() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see Filter#destroy()
//	 */
//	public void destroy() {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
//	 */
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        Object value = request.getAttribute("hello");
//        System.out.println("Filter 2 nhận được: " + value);
//        
//        chain.doFilter(request, response);
//	}
//
//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	public void init(FilterConfig fConfig) throws ServletException {
//		// TODO Auto-generated method stub
//	}
//
//}
