package ar.com.ada.nooa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.nooa.entities.Boya;
@Repository
public interface BoyaRepository extends JpaRepository<Boya, Integer>{
    
}
