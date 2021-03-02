package org.example.virtualkey;


import org.example.virtualkey.dao.Dao;
import org.example.virtualkey.dao.UserDao;
import org.example.virtualkey.entities.User;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VirtualKeyApplicationTests {


    private Dao<User> userDao;


    @Test
    public void MyTest()
    {

        String myGreeting = VirtualKeyApplication.Greeting();

        assertEquals("Hello World!", myGreeting);


    }

    @Test void TestUser()
    {
        userDao = new UserDao();

        User user1 = getUser(0);
        System.out.println(user1);
        userDao.update(user1, new String[]{"Jake", "jake@domain.com", "password"});

        User user2 = getUser(1);
        userDao.delete(user2);
        userDao.save(new User(1,"Julie", "julie@domain.com", "password"));

        userDao.getAll().forEach(user -> System.out.println(user.getName()));
    }


    private User getUser(int id) {
        Optional<User> user = userDao.get(id);

        return user.orElseGet(
                () -> new User(0, "non-existing user", "no-email", "password"));
    }


}
