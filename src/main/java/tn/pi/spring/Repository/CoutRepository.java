package tn.pi.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.pi.spring.entity.Cout;


@Repository
public interface CoutRepository extends JpaRepository<Cout, Long> {

}
