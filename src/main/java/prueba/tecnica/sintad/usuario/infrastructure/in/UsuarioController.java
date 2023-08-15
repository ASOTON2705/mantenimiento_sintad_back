package prueba.tecnica.sintad.usuario.infrastructure.in;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.tecnica.sintad.usuario.application.UsuarioService;
import prueba.tecnica.sintad.usuario.domain.dto.UsuarioCreateDto;
import prueba.tecnica.sintad.usuario.domain.dto.UsuarioDto;
import prueba.tecnica.sintad.usuario.domain.dto.UsuarioUpdateDto;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("")
    public ResponseEntity<List<UsuarioDto>> listarUsuarios(){
        return new ResponseEntity<>(usuarioService.listarUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDto> obtenerUsuarioPorId(@PathVariable("idUsuario") int idUsuario){
        return new ResponseEntity<>(usuarioService.obtenerUsuarioPorId(idUsuario), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<UsuarioDto> registrarUsuario (@RequestBody UsuarioCreateDto usuarioCreateDto){
        return new ResponseEntity<>(usuarioService.registrarUsuario(usuarioCreateDto), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<UsuarioDto> actualizarUsuario (@RequestBody UsuarioUpdateDto usuarioUpdateDto){
        return new ResponseEntity<>(usuarioService.actualizarUsuario(usuarioUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> eliminarOrdeCompra(@PathVariable(value = "idUsuario") int idUsuario) {
        usuarioService.eliminarUsuario(idUsuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
