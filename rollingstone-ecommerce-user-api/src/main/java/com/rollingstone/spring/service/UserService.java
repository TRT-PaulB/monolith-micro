package com.rollingstone.spring.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.rollingstone.spring.model.User;

public interface UserService {

   User save(User user);
   Optional<User> get(long id);
   Page<User> getUsersByPage(Integer pageNumber, Integer pageSize);
   void update(long id, User user);
   void delete(long id);
}
