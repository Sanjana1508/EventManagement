package com.eventMgmt.service;

import com.eventMgmt.dao.UserRepository;
import com.eventMgmt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int theId) {
        Optional<User> foundUser= userRepository.findById(theId);
        User user=null;
        if(foundUser.isPresent()){
            user=foundUser.get();
        }
        else{
            throw new RuntimeException("User not found with id : "+theId);
        }
        return user;
    }

    @Override
    public void save(User theUser) {
        userRepository.save(theUser);
    }

    @Override
    public void deleteById(int theId) {
        userRepository.deleteById(theId);
    }
}
