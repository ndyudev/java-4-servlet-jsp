package ndyudev.lab4.dao;

import ndyudev.lab4.entity.Share;

public interface ShareDAO extends BaseDAO<Share, Long> {
    // Có thể thêm method tùy chỉnh, ví dụ: List<Share> findByUserId(String userId);
}