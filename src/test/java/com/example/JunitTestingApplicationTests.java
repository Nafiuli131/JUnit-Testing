package com.example;

import com.example.dao.UserRepository;
import com.example.model.User;
import com.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitTestingApplicationTests {
    @Autowired
    private UserService service;

    @MockBean
    private UserRepository repository;

    @Test
    public void getUsersTest() {
        when(repository.findAll()).thenReturn(Stream
                .of(new User(376L, "Danile", 31, "USA"),
                        new User(958L, "Huy", 35, "UK")).collect(Collectors.toList()));
        assertEquals(4, service.getUsers().size());
    }
    @Test
    public void getUserbyAddress(){
        String address = "Dhaka";
        when(repository.findByAddress(address)).thenReturn(Stream
                .of(new User(142L,"John",45,"Dhaka")).collect(Collectors.toList()));
        assertEquals(1,service.getUserbyAddress(address).size());
    }
    @Test
    public void saveUserTest() {
        User user = new User(999L, "Pranya", 33, "Pune");
        when(repository.save(user)).thenReturn(user);
        assertEquals(user, service.addUser(user));
    }

}
