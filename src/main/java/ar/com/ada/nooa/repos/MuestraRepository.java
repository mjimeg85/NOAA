package ar.com.ada.nooa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.ada.nooa.entities.Muestra;

public interface MuestraRepository extends JpaRepository<Muestra, Integer>{
    
}
