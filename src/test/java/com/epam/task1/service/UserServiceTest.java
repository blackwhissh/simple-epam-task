package com.epam.task1.service;

import com.epam.task1.models.User;
import com.epam.task1.repositories.UserRepository;
import com.epam.task1.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("test");

        userService.saveUser(user);

        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testGetUsers() {
        userService.getUsers();

        verify(userRepository, times(1)).findAll();
    }
}
