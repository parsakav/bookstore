package com.parsakav.bookstore;


import com.parsakav.bookstore.entity.UserEntity;
import com.parsakav.bookstore.repository.UserEntityRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserEntityRepository userRepository;

    UserEntity user=null;
  /*  @BeforeEach
    void before(){

        new Student("amir-"+ Math.random(),"amir@gmail.com",Gender.MALE);
    }
    @AfterEach
    void clearDatabase(){
        studentRepository.deleteAll();

    }
    @Test
    void itShouldBeExistsEmail() {
        studentRepository.save(student);

        boolean exist= studentRepository.selectExistsEmail("amir@gmail.com");
        assertThat(exist).isTrue();

    }
    @Test
    void itShould_not_BeExistsEmail() {
        boolean notexist = studentRepository.selectExistsEmail("amir@gmail.com");
        assertThat(notexist).isFalse();

    }*/
}
