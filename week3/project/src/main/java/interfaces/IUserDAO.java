package interfaces;

import java.util.List;

import models.User;

public interface IUserDAO {
    public void save(User user);

    public void saveAll(List<User> users);

    public User getByCardNumber(Long cardNumber);

    public List<User> getAll();

    public void update(User user);

    public void removeByCardNumber(Long cardNumber);
}
