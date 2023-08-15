package prueba.tecnica.sintad.tipousuario.infrastructure.in;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.tecnica.sintad.tipousuario.application.TipoUsuarioService;
import prueba.tecnica.sintad.tipousuario.domain.dto.TipoUsuarioCreateDto;
import prueba.tecnica.sintad.tipousuario.domain.dto.TipoUsuarioDto;
import prueba.tecnica.sintad.tipousuario.domain.dto.TipoUsuarioUpdateDto;
import java.util.List;

@RestController
@RequestMapping("/api/tipoUsuario")
public class TipoUsuarioController {
    private final TipoUsuarioService tipoUsuarioService;

    public TipoUsuarioController(TipoUsuarioService tipoUsuarioService) {
        this.tipoUsuarioService = tipoUsuarioService;
    }

    @GetMapping("")
    public ResponseEntity<List<TipoUsuarioDto>> listarTipoUsuarios() {
        return new ResponseEntity<>(tipoUsuarioService.listarTipoUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/{idTipoUsuario}")
    public ResponseEntity<TipoUsuarioDto> obtenerTipoUsuarioPorId(@PathVariable("idTipoUsuario") int idTipoUsuario) {
        return new ResponseEntity<>(tipoUsuarioService.obtenerTipoUsuarioPorId(idTipoUsuario), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<TipoUsuarioDto> registrarUsuario(@RequestBody TipoUsuarioCreateDto tipoUsuarioCreateDto) {
        return new ResponseEntity<>(tipoUsuarioService.registrarTipoUsuario(tipoUsuarioCreateDto), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<TipoUsuarioDto> actualizarUsuario(@RequestBody TipoUsuarioUpdateDto tipoUsuarioUpdateDto) {
        return new ResponseEntity<>(tipoUsuarioService.actualizarTipoUsuario(tipoUsuarioUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("/{idTipoUsuario}")
    public ResponseEntity<Void> eliminarOrdeCompra(@PathVariable("idTipoUsuario") int idTipoUsuario) {
        tipoUsuarioService.eliminarTipoUsuario(idTipoUsuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
