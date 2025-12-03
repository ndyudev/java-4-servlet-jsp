package ndyudev.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RestIO {
	static private ObjectMapper mapper = new ObjectMapper();

	/**
	 * Đọc chuỗi JSON gửi từ client
	 */
	public static String readJson(HttpServletRequest req) throws IOException {
		req.setCharacterEncoding("utf-8");
		BufferedReader reader = req.getReader();
		String line;
		StringBuffer buffer = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
		}
		reader.close();
		return buffer.toString();
	}

	/**
	 * Gửi chuỗi JSON về client
	 */
	public static void writeJson(HttpServletResponse resp, String json) throws IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		resp.getWriter().print(json);
		resp.flushBuffer();
	}

	/**
	 * Đọc chuỗi JSON gửi từ client và chuyển đổi sang Java Object
	 */
	public static <T> T readObject(HttpServletRequest req, Class<T> clazz) throws IOException {
		String json = RestIO.readJson(req);
		T bean = mapper.readValue(json, clazz);
		return bean;
	}

	/**
	 * Chuyển đổi Java Object sang chuỗi JSON và gửi về client
	 */
	public static void writeObject(HttpServletResponse resp, Object data) throws IOException {
		String json = mapper.writeValueAsString(data);
		RestIO.writeJson(resp, json);
	}

	/**
	 * Gửi đối tượng rỗng về client
	 */
	public static void writeEmptyObject(HttpServletResponse resp) throws IOException {
		RestIO.writeObject(resp, Map.of());
	}
}
