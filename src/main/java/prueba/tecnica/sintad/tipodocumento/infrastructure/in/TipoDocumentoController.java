package prueba.tecnica.sintad.tipodocumento.infrastructure.in;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.tecnica.sintad.tipodocumento.application.TipoDocumentoService;
import prueba.tecnica.sintad.tipodocumento.domain.dto.TipoDocumentoCreateDto;
import prueba.tecnica.sintad.tipodocumento.domain.dto.TipoDocumentoDto;
import prueba.tecnica.sintad.tipodocumento.domain.dto.TipoDocumentoUpdateDto;
import java.util.List;

@RestController
@RequestMapping("/api/tipoDocumento")
public class TipoDocumentoController {
    private final TipoDocumentoService tipoDocumentoService;

    public TipoDocumentoController(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    @GetMapping("")
    public ResponseEntity<List<TipoDocumentoDto>> listarTipoDocumentos() {
        return new ResponseEntity<>(tipoDocumentoService.listarTipoDocumentos(), HttpStatus.OK);
    }

    @GetMapping("/{idTipoDocumento}")
    public ResponseEntity<TipoDocumentoDto> obtenerTipoDocumentoPorId(@PathVariable("idTipoDocumento") int idTipoDocumento) {
        return new ResponseEntity<>(tipoDocumentoService.obtenerTipoDocumentoPorId(idTipoDocumento), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<TipoDocumentoDto> registrarTipoDocumento(@RequestBody TipoDocumentoCreateDto tipoDocumentoCreateDto) {
        return new ResponseEntity<>(tipoDocumentoService.registrarTipoDocumento(tipoDocumentoCreateDto), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<TipoDocumentoDto> actualizarTipoDocumento(@RequestBody TipoDocumentoUpdateDto tipoDocumentoUpdateDto) {
        return new ResponseEntity<>(tipoDocumentoService.actualizarTipoDocumento(tipoDocumentoUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("/{idTipoDocumento}")
    public ResponseEntity<Void> eliminarTipoDocumento(@PathVariable("idTipoDocumento") int idTipoDocumento) {
        tipoDocumentoService.eliminarTipoDocumento(idTipoDocumento);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
