package domain.ports;

import domain.model.User;

public interface UserPort {

    public User GetUser(String id);

}
