package ar.com.ada.nooa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.nooa.entities.Muestra;

@Repository
public interface MuestraRepository extends JpaRepository<Muestra, Integer>{
    
}
