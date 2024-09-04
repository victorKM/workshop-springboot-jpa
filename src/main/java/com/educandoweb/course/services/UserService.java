package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service
public class UserService {
  
  @Autowired
  private UserRepository userRepository;

  public List<User> findAll(){
    return userRepository.findAll();
  }

  public User findById(Long id) {
    Optional<User> obj = userRepository.findById(id);
    return obj.get();
  }

  public User insert(User user) {
    return userRepository.save(user);
  }

  public void delete(long id) {
    userRepository.deleteById(id);
  }

  public User update(Long id, User user) {
    User entity = userRepository.getReferenceById(id);
    update(entity, user);
    return userRepository.save(entity);
  }

  private void update(User entity, User user) {
    entity.setName(user.getName());
    entity.setEmail(user.getEmail());
    entity.setPhone(user.getPhone());
  }
}
