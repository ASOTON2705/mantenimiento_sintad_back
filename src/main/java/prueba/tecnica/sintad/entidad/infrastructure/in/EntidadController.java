package prueba.tecnica.sintad.entidad.infrastructure.in;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.tecnica.sintad.entidad.application.EntidadService;
import prueba.tecnica.sintad.entidad.domain.dto.EntidadCreateDto;
import prueba.tecnica.sintad.entidad.domain.dto.EntidadDto;
import prueba.tecnica.sintad.entidad.domain.dto.EntidadUpdateDto;
import prueba.tecnica.sintad.tipocontribuyente.application.TipoContribuyenteService;
import prueba.tecnica.sintad.tipocontribuyente.domain.dto.TipoContribuyenteCreateDto;
import prueba.tecnica.sintad.tipocontribuyente.domain.dto.TipoContribuyenteDto;
import prueba.tecnica.sintad.tipocontribuyente.domain.dto.TipoContribuyenteUpdateDto;

import java.util.List;

@RestController
@RequestMapping("/api/entidad")
public class EntidadController {
    private final EntidadService entidadService;

    public EntidadController(EntidadService entidadService) {
        this.entidadService = entidadService;
    }

    @GetMapping("")
    public ResponseEntity<List<EntidadDto>> listarEntidades() {
        return new ResponseEntity<>(entidadService.listarEntidades(), HttpStatus.OK);
    }

    @GetMapping("/{idEntidad}")
    public ResponseEntity<EntidadDto> obtenerEntidadPorId(@PathVariable("idEntidad") int idEntidad) {
        return new ResponseEntity<>(entidadService.obtenerEntidadPorId(idEntidad), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<EntidadDto> registrarEntidad(@RequestBody EntidadCreateDto entidadCreateDto) {
        return new ResponseEntity<>(entidadService.registrarEntidad(entidadCreateDto), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<EntidadDto> actualizarEntidad(@RequestBody EntidadUpdateDto entidadUpdateDto) {
        return new ResponseEntity<>(entidadService.actualizarEntidad(entidadUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("/{idEntidad}")
    public ResponseEntity<Void> eliminarEntidad(@PathVariable("idEntidad") int idEntidad) {
        entidadService.eliminarEntidad(idEntidad);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
