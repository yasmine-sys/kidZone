package tn.pi.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.pi.spring.entity.Blacklist;

@Repository
public interface BlacklistRepository extends JpaRepository<Blacklist, Long>{

}
