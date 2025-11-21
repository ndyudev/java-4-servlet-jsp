package ndyudev.lab4.dao;

import ndyudev.lab4.entity.Favorite;
import java.util.List;

public interface FavoriteDAO extends BaseDAO<Favorite, Long> {
    List<Favorite> findByUserId(String userId);
    void deleteByUserAndVideo(String userId, String videoId);
}