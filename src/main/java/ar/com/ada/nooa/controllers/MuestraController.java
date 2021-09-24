package ar.com.ada.nooa.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.nooa.entities.Muestra;
import ar.com.ada.nooa.models.request.MuestraRequest;
import ar.com.ada.nooa.models.response.GenericResponse;
import ar.com.ada.nooa.models.response.MuestraResponse;
import ar.com.ada.nooa.services.MuestraService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class MuestraController {

    @Autowired
    MuestraService service;

    @PostMapping("/muestras")
    public ResponseEntity<?> crearMuestra(@RequestBody MuestraRequest infoMuestra) {

        MuestraResponse respuestaEsperada = new MuestraResponse();

        Muestra muestra = service.crearMuestra(infoMuestra.alturaNivelMar, infoMuestra.boyaId, infoMuestra.horario,
                infoMuestra.latitud, infoMuestra.longitud, infoMuestra.matricula);

        respuestaEsperada.id = muestra.getMuestraId();
        respuestaEsperada.color = muestra.getBoya().getColorLuz();


        return ResponseEntity.ok(respuestaEsperada);
    }
    
    @GetMapping("/muestras/boyas/{idBoya}")
    public ResponseEntity<List<Muestra>> getMuestraDeBoya(@PathVariable Integer idBoya) {

        return ResponseEntity.ok(service.buscarMuestras(idBoya));

    }

    @DeleteMapping("/muestra/{id}")
    public ResponseEntity<GenericResponse> borrarMuestra(@PathVariable Integer id) {

        GenericResponse r = new GenericResponse();

        Muestra muestra = service.buscarPorId(id);
        service.setColorAzul(muestra);

        r.isOk = true;
        r.message = "Muestra borrada";
        return ResponseEntity.ok(r);

    }

}
