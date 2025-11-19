package ndyudev.lab3.dao;

import ndyudev.lab3.entity.Favorite;
import java.util.List;

public interface FavoriteDAO extends BaseDAO<Favorite, Long> {
    List<Favorite> findByUserId(String userId);
}