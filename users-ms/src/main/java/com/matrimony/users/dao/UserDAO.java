package com.matrimony.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO<T> extends JpaRepository<T, Long> {
}
