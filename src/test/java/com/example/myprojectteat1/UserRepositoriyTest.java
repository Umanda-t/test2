package com.example.myprojectteat1;

import com.example.myprojectteat1.user.User;
import com.example.myprojectteat1.user.UserRepositoriy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class UserRepositoriyTest {

    @Autowired
    private UserRepositoriy repo;
    @Test
    public void testAddnew()
    {
         User user = new User();

        user.setEmail("Umanda@gmail.com");
        user.setPassword("umanda2021");
        user.setFirstName("Umanda");
        user.setLastName("Thathsarani");

        User savedUser = repo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }
    @Test
    public void testListAll()
    {
        Iterable<User> users= repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
        for(User user: users)
        {
      System.out.println("User");
        }
   }


}
