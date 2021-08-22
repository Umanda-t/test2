package com.example.myprojectteat1.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired private UserRepositoriy repo;
    public List<User> listAll()
    {
        return(List<User>)repo.findAll();
    }
}
