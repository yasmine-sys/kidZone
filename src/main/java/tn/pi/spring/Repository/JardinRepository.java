package tn.pi.spring.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
//AUTHOR ABDESSALEM BENCHRIFA
import org.springframework.stereotype.Repository;

import tn.pi.spring.entity.Jardin;


@Repository
public interface JardinRepository extends JpaRepository<Jardin, Long> {

}

