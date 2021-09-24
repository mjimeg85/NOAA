package ar.com.ada.nooa.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.nooa.entities.Boya;
import ar.com.ada.nooa.entities.Muestra;
import ar.com.ada.nooa.repos.MuestraRepository;

@Service
public class MuestraService {
    @Autowired
    MuestraRepository repo;
    @Autowired
    BoyaService service;

    public Muestra crearMuestra(Double alturaNivelDelMar, Integer boyaId, Date horario, Double latitud, Double longitud,
            String matricula) {

        Muestra muestra = new Muestra();
        muestra.setAlturaNivelMar(alturaNivelDelMar);
        Boya boya = service.buscarPorId(boyaId);
        muestra.setBoya(service.calcularColor(boya, alturaNivelDelMar));
        muestra.setHorarioMuestra(horario);
        muestra.setLatitud(latitud);
        muestra.setLongitud(longitud);
        muestra.setMatriculaEmbarcacion(matricula);

        return repo.save(muestra);
    }

    public List<Muestra> buscarMuestras(Integer idBoya) {

        Boya boya = service.buscarPorId(idBoya);

        return boya.getMuestras();

    }

    public void setColorAzul(Muestra muestra) {
        muestra.getBoya().setColorLuz("azul");
        repo.save(muestra);
    }

    public void borrar(Muestra muestra) {
        repo.delete(muestra);
    }

    public Muestra buscarPorId(Integer id) {
        return repo.findByMuestraId(id);
    }



    
    
    
 
}
