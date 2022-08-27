package com.example.demo.mysql;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.mysql.user;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface repo extends CrudRepository<user, Long> {

}