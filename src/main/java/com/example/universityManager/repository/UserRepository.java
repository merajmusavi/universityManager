package com.example.universityManager.repository;

import com.example.universityManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface UserRepository<T extends User> extends JpaRepository<T, Long> {
}
