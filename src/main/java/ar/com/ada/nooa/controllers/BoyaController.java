package ar.com.ada.nooa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.com.ada.nooa.entities.Boya;
import ar.com.ada.nooa.models.request.ColorBoyaRequest;
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

    @GetMapping("/boyas/{id}")
    public ResponseEntity<Boya> buscarPorId(@PathVariable Integer id) {

        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/boyas/{id}")
    public ResponseEntity<GenericResponse> actualizarColorBoya(@PathVariable Integer id, @RequestBody ColorBoyaRequest color ){
        GenericResponse r= new GenericResponse();

        Boya nueva= service.buscarPorId(id);
        nueva.setColorLuz(color.color);
        service.guardar(nueva);

        r.isOk = true;
        r.message = "Color de boya actualizado";
        return ResponseEntity.ok(r);

    }

}
