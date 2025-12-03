package ndyudev.lab7.servlet;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class Lab7Lesson2UploadFile
 */
@MultipartConfig
@WebServlet("/lab7/lesson2/upload")
public class Lab7Lesson2UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lab7Lesson2UploadFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("photo");
        
        String name = part.getSubmittedFileName();
        long size = part.getSize();
        String type = part.getContentType();
        
        String uploadPath = request.getServletContext().getRealPath("/files");
        
        Path path = Paths.get(uploadPath);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        
        String filename = uploadPath + "/" + name;
        part.write(filename);
        
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        
        String format = "{\"name\": \"%s\", \"type\": \"%s\", \"size\": %d}";
        String responseData = String.format(format, name, type, size);
        
        response.getWriter().print(responseData);
        
//        System.out.println(uploadPath);
	}

}
