package ru.netology.authorizationservice1.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice1.authorities.Authorities;
import ru.netology.authorizationservice1.error.ErrorRegistration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final Map<String, String> userMap = new ConcurrentHashMap<>();
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = new ArrayList<>();
        if (userMap.containsKey(user) && userMap.get(user).equals(password)) {
                authorities.add(Authorities.READ);
                authorities.add(Authorities.WRITE);
                authorities.add(Authorities.DELETE);
        }
        return authorities;
    }

    public void userRegistration(String user, String password){
        if (!userMap.containsKey(user)) {
            userMap.put(user, password);
        } else throw new ErrorRegistration("The name is taken");
    }
}
