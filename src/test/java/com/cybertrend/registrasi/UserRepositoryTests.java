package com.cybertrend.registrasi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.cybertrend.registrasi.model.User;
import com.cybertrend.registrasi.repository.UserRepository;

public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    @Test
    public void testCreateUser() {

        User user = new User();
        user.setNama("Hisyam Bagas Prakoso");
        user.setTelp("085345678769");
        user.setEmail("hisyambagasprakoso@gmail.com");
        user.setPassword("hisam2023");
        
        User savedUser = repo.save(user);
        
        User existUser = entityManager.find(User.class, savedUser.getUser_id());
        
        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
        
    }
    
}
