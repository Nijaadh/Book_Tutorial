package com.electron.electron.repository;

import com.electron.electron.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findOneByEmailIdIgnoreCaseAndPassword(String emailId, String password);
}
