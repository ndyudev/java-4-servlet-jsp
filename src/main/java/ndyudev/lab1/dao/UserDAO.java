package ndyudev.lab1.dao;

import java.util.List;
import ndyudev.lab1.entity.User;

public interface UserDAO {
    public void create(User user);
    public List<User> findAll();
    public User findById(String id);
    public void update(User user);
    public void deleteById(String id);
    List<User> finAllFPTEdu();
    List<User> findPageUser(int pageNumber, int pageSize);
}
