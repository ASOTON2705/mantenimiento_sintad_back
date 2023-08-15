package prueba.tecnica.sintad.tipocontribuyente.infrastructure.in;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.tecnica.sintad.tipocontribuyente.application.TipoContribuyenteService;
import prueba.tecnica.sintad.tipocontribuyente.domain.dto.TipoContribuyenteCreateDto;
import prueba.tecnica.sintad.tipocontribuyente.domain.dto.TipoContribuyenteDto;
import prueba.tecnica.sintad.tipocontribuyente.domain.dto.TipoContribuyenteUpdateDto;
import java.util.List;

@RestController
@RequestMapping("/api/tipoContribuyente")
public class TipoContribuyenteController {
    private final TipoContribuyenteService tipoContribuyenteService;

    public TipoContribuyenteController(TipoContribuyenteService tipoContribuyenteService) {
        this.tipoContribuyenteService = tipoContribuyenteService;
    }

    @GetMapping("")
    public ResponseEntity<List<TipoContribuyenteDto>> listarTipoContribuyentes() {
        return new ResponseEntity<>(tipoContribuyenteService.listarTipoContribuyentes(), HttpStatus.OK);
    }

    @GetMapping("/{idTipoContribuyente}")
    public ResponseEntity<TipoContribuyenteDto> obtenerTipoContribuyentePorId(@PathVariable("idTipoContribuyente") int idTipoContribuyente) {
        return new ResponseEntity<>(tipoContribuyenteService.obtenerTipoContribuyentePorId(idTipoContribuyente), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<TipoContribuyenteDto> registrarTipoContribuyente(@RequestBody TipoContribuyenteCreateDto tipoContribuyenteCreateDto) {
        return new ResponseEntity<>(tipoContribuyenteService.registrarTipoContribuyente(tipoContribuyenteCreateDto), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<TipoContribuyenteDto> actualizarTipoContribuyente(@RequestBody TipoContribuyenteUpdateDto tipoContribuyenteUpdateDto) {
        return new ResponseEntity<>(tipoContribuyenteService.actualizarTipoContribuyente(tipoContribuyenteUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("/{idTipoContribuyente}")
    public ResponseEntity<Void> eliminarTipoContribuyente(@PathVariable("idTipoContribuyente") int idTipoContribuyente) {
        tipoContribuyenteService.eliminarTipoContribuyente(idTipoContribuyente);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
