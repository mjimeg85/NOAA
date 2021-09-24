package ar.com.ada.nooa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.nooa.entities.Boya;
import ar.com.ada.nooa.models.response.GenericResponse;
import ar.com.ada.nooa.services.BoyaService;

@RestController
public class BoyaController {

    @Autowired
    BoyaService service;

    @PostMapping("/boyas")
    public ResponseEntity<GenericResponse> crearBoya(@RequestBody Boya boya) {
        GenericResponse r = new GenericResponse();

        Boya nueva = service.crearBoya(boya.getLatitudInstalacion(), boya.getLongitudInstalacion());

        r.isOk = true;
        r.message = "Se ha creado la boya correctamente";
        r.id = nueva.getBoyaId();

        return ResponseEntity.ok(r);

    }

    @GetMapping("/boyas")
    public ResponseEntity<List<Boya>> obtenerBoyas() {
        return ResponseEntity.ok(service.obtenerBoyas());
    }

}
