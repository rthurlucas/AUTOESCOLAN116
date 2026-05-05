package br.com.senain116.autoescolan116.application.core.usecase;

import br.com.senain116.autoescolan116.adapter.in.controller.mapper.UsuarioMapper;
import br.com.senain116.autoescolan116.adapter.in.controller.request.usuario.DadosAtualizacaoSenha;
import br.com.senain116.autoescolan116.adapter.in.controller.request.usuario.DadosAtualizacaoUsuario;
import br.com.senain116.autoescolan116.adapter.in.controller.request.usuario.DadosCadastroUsuario;
import br.com.senain116.autoescolan116.adapter.in.controller.response.usuario.DadosDetalhamentoUsuario;
import br.com.senain116.autoescolan116.application.core.domain.model.Usuario;
import br.com.senain116.autoescolan116.application.port.out.UsuarioRepository;
import br.com.senain116.autoescolan116.exception.type.usuario.SenhaIncorretaException;
import br.com.senain116.autoescolan116.exception.type.usuario.UsuarioNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;
    private final UsuarioMapper mapper;

    public UsuarioService(UsuarioRepository repository, UsuarioMapper mapper, PasswordEncoder encoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.encoder = encoder;
    }

    @Transactional
    public DadosDetalhamentoUsuario cadastrar(DadosCadastroUsuario dados){
        Usuario usuario = mapper.toDomain(dados);
        Usuario saved = repository.save(usuario);
        return mapper.toDetailsDTO(saved);
    }

    public Page listar(Pageable paginacao){
        return repository
                .findAllByAtivoTrue(paginacao)
                .map(mapper::toListDTO);
    }

    public DadosDetalhamentoUsuario detalhar(Long id){
        Usuario usuario = repository.findById(id).orElseThrow(() -> new UsuarioNotFoundException("ID do usuario nao encontrado: " + id));
        return mapper.toDetailsDTO(usuario);
    }

    @Transactional
    public DadosDetalhamentoUsuario atualizarSenha(DadosAtualizacaoSenha dados){
        Usuario usuario = repository.findById(dados.id()).orElseThrow(() -> new UsuarioNotFoundException("ID do usuario nao encontrado: " + dados.id()));
        if (!encoder.matches(dados.senhaAntiga(), usuario.getSenha())) {
            throw new SenhaIncorretaException("Senha incorreta!");
        }
        String senhaNovaCriptografada = encoder.encode(dados.senhaNova());
        usuario.atualizarSenha(senhaNovaCriptografada);
        repository.save(usuario);
        return mapper.toDetailsDTO(usuario);
    }

    public DadosDetalhamentoUsuario atualizarUsuario(DadosAtualizacaoUsuario dados){
        Usuario usuario = repository.findById(dados.id()).orElseThrow(() -> new UsuarioNotFoundException("ID do usuario nao encontrado: " + dados.id()));
        usuario.atualizarUsuario(
                dados.id(),
                dados.login(),
                dados.ativo(),
                dados.perfil());
        repository.save(usuario);
        return new DadosDetalhamentoUsuario(usuario);
    }

    public void excluir(Long id){
        Usuario usuario = repository.findById(id).orElseThrow(() -> new UsuarioNotFoundException("ID do usuario nao encontrado: " + id));
        repository.delete(usuario);
    }
}
