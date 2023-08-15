package prueba.tecnica.sintad.tipousuario.application.impl;

import org.springframework.stereotype.Service;
import prueba.tecnica.sintad.tipousuario.application.TipoUsuarioService;
import prueba.tecnica.sintad.tipousuario.domain.dto.TipoUsuarioCreateDto;
import prueba.tecnica.sintad.tipousuario.domain.dto.TipoUsuarioDto;
import prueba.tecnica.sintad.tipousuario.domain.dto.TipoUsuarioUpdateDto;
import prueba.tecnica.sintad.tipousuario.domain.mapper.TipoUsuarioMapper;
import prueba.tecnica.sintad.tipousuario.domain.model.TipoUsuario;
import prueba.tecnica.sintad.tipousuario.infrastructure.out.TipoUsuarioRepository;
import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService {
    private final TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioServiceImpl(TipoUsuarioRepository tipoUsuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    @Override
    public List<TipoUsuarioDto> listarTipoUsuarios() {
        return TipoUsuarioMapper.INSTANCE.listaTipoUsuarioAListaTipoUsuarioDto(tipoUsuarioRepository.findAll());

    }

    @Override
    public TipoUsuarioDto obtenerTipoUsuarioPorId(int idTipoUsuario) {
        Optional<TipoUsuario> tipoUsuario = tipoUsuarioRepository.findById(idTipoUsuario);
        TipoUsuarioDto tipoUsuarioDto;
        if (tipoUsuario.isPresent()) {
            tipoUsuarioDto = TipoUsuarioMapper.INSTANCE.tipoUsuarioATipoUsuarioDto(tipoUsuario.get());
        } else {
            tipoUsuarioDto = null;
        }
        return tipoUsuarioDto;
    }

    @Override
    public TipoUsuarioDto registrarTipoUsuario(TipoUsuarioCreateDto tipoUsuarioCreateDto) {
        TipoUsuario tipoUsuario = TipoUsuarioMapper.INSTANCE.tipoUsuarioCreateDtoATipoUsuario(tipoUsuarioCreateDto);
        TipoUsuario respuestaEntity = tipoUsuarioRepository.save(tipoUsuario);
        TipoUsuarioDto respuestDto = TipoUsuarioMapper.INSTANCE.tipoUsuarioATipoUsuarioDto(respuestaEntity);
        return respuestDto;
    }

    @Override
    public TipoUsuarioDto actualizarTipoUsuario(TipoUsuarioUpdateDto tipoUsuarioUpdateDto) {
        TipoUsuario tipoUsuario = TipoUsuarioMapper.INSTANCE.tipoUsuarioUpdateDtoATipoUsuario(tipoUsuarioUpdateDto);
        TipoUsuario respuestaEntity = tipoUsuarioRepository.save(tipoUsuario);
        TipoUsuarioDto respuestDto = TipoUsuarioMapper.INSTANCE.tipoUsuarioATipoUsuarioDto(respuestaEntity);
        return respuestDto;
    }

    @Override
    public String eliminarTipoUsuario(int idTipoUsuario) {
        Optional<TipoUsuario> entities = tipoUsuarioRepository.findById(idTipoUsuario);
        String resultado;
        if (entities.isPresent()) {
            tipoUsuarioRepository.deleteById(idTipoUsuario);
            resultado = "Tipo de usuario eliminado";
        } else {
            resultado = "No se pudo eliminar el tipo de usuario";
        }
        return resultado;
    }

}
