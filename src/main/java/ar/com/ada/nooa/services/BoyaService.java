package ar.com.ada.nooa.services;

import java.util.List;
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

    public Boya calcularColor(Boya boya, Double alturaNivelMar) {

        if (alturaNivelMar <= -50 || alturaNivelMar >= 50) {
            boya.setColorLuz("amarillo");
        } else if (alturaNivelMar <= -100 || alturaNivelMar >= 100) {
            boya.setColorLuz("rojo");
        } else
            boya.setColorLuz("verde");

        return boya;
    }
}
