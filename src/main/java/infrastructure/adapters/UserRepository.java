package infrastructure.adapters;

import domain.model.User;
import domain.ports.UserPort;

public class UserRepository implements UserPort {


    public User GetUser(String id) {
       return new User("123", "Lasse");
    }
}
