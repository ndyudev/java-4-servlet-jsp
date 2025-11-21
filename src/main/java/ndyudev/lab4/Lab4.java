package ndyudev.lab4;

import java.util.List;

import ndyudev.lab4.dao.impl.ShareDAOImpl;
import ndyudev.lab4.dao.impl.UserDAOImpl;
import ndyudev.lab4.dao.impl.VideoDAOImpl;
import ndyudev.lab4.entity.Share;
import ndyudev.lab4.entity.User;
import ndyudev.lab4.entity.Video;

public class Lab4 {
	public static void main(String[] args) {
		UserDAOImpl userDAO = new UserDAOImpl();
		VideoDAOImpl videoDAO = new VideoDAOImpl();
		ShareDAOImpl shareDAO = new ShareDAOImpl();
		
		User user = userDAO.findUserByIdOrEmail("U001");
		System.out.println(user);
//		List<Video> listVideo = videoDAO.findVideoByKeyWord("Học");
//		for (Video video : listVideo) {
//			System.out.println(video);
//		}
//		System.out.println(user);
		
//		List<Video> listVideoTop10View = videoDAO.top10VideoView();
//		for (Video video : listVideoTop10View) {
//			System.out.println(video);
//		}
//		
//		List<Video> listVideoNoLike = videoDAO.findVideoNoLike();
//		for (Video video : listVideoNoLike) {
//			System.out.println(video);
//		}
		
//		List<Share> listVideoShare2024 = shareDAO.VideoShareIn2024();
//		for (Share share : listVideoShare2024) {
//			System.out.println(share);
//		}
//		
	}
}
