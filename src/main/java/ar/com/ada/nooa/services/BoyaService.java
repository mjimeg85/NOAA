package ar.com.ada.nooa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.nooa.entities.Boya;
import ar.com.ada.nooa.repos.BoyaRepository;

@Service
public class BoyaService {
    @Autowired
    BoyaRepository repo;

    public Boya crearBoya(Double longitudInstalacion, Double latitudInstalacion) {
        Boya boya = new Boya();
        boya.setColorLuz("azul");
        boya.setLatitudInstalacion(latitudInstalacion);
        boya.setLongitudInstalacion(longitudInstalacion);

        return repo.save(boya);

    }

    public List<Boya> obtenerBoyas() {
        return repo.findAll();
    }

    public Boya buscarPorId(Integer id) {
        return repo.findByBoyaId(id);
    }

    public void guardar(Boya nueva) {
        repo.save(nueva);
    }

}
