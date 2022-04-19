package tn.pi.spring.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.pi.spring.entity.User;


@Repository
public interface UserRepository  extends CrudRepository<User, Long> {

}
