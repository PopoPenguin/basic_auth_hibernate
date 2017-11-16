package hello.service;

/*
created by PopoPenguin on 11/15/17
*/


import hello.model.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}