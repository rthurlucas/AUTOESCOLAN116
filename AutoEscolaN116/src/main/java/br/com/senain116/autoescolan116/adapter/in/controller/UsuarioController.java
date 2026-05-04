package br.com.senain116.autoescolan116.adapter.in.controller;

import br.com.senain116.autoescolan116.adapter.in.controller.request.usuario.DadosAtualizacaoSenha;
import br.com.senain116.autoescolan116.adapter.in.controller.request.usuario.DadosAtualizacaoUsuario;
import br.com.senain116.autoescolan116.adapter.in.controller.request.usuario.DadosCadastroUsuario;
import br.com.senain116.autoescolan116.adapter.in.controller.response.usuario.DadosDetalhamentoUsuario;
import br.com.senain116.autoescolan116.adapter.in.controller.response.usuario.DadosListagemUsuario;
import br.com.senain116.autoescolan116.adapter.in.controller.response.usuario.DadosSucesso;
import br.com.senain116.autoescolan116.application.core.domain.model.Usuario;
import br.com.senain116.autoescolan116.application.port.out.UsuarioRepository;
import br.com.senain116.autoescolan116.exception.type.usuario.SenhaIncorretaException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DadosDetalhamentoUsuario> cadastrarUsuario(
            @RequestBody @Valid DadosCadastroUsuario dados,
            UriComponentsBuilder uriBuilder) {
        String senhaCriptografada = encoder.encode(dados.senha());
        Usuario usuario = new Usuario(
                null,
                dados.login(),
                senhaCriptografada,
                true,
                dados.perfil()
        );
        repository.save(usuario);
        URI uri = uriBuilder
                .path("/usuarios/{id}")
                .buildAndExpand(usuario.getId())
                .toUri();
        DadosDetalhamentoUsuario dto = new DadosDetalhamentoUsuario(usuario);
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<DadosListagemUsuario>> listarUsuarios(
            @PageableDefault(size = 10, sort = "nome") Pageable paginacao) {
        Page page = repository
                .findAllByAtivoTrue(paginacao)
                .map(DadosListagemUsuario::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DadosDetalhamentoUsuario> detalharUsuario(
            @PathVariable Long id) {
        Usuario usuario = repository.getReferenceById(id);
        DadosDetalhamentoUsuario dto = new DadosDetalhamentoUsuario(usuario);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DadosDetalhamentoUsuario> atualizarUsuario(
            @RequestBody @Valid DadosAtualizacaoUsuario dados) {
        Usuario usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);
        repository.save(usuario);
        DadosDetalhamentoUsuario dto = new DadosDetalhamentoUsuario(usuario);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping
    @Transactional
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<DadosSucesso> atualizarSenha(@RequestBody @Valid DadosAtualizacaoSenha dados) {
        Usuario usuario = repository.getReferenceById(dados.id());
        if (!encoder.matches(dados.senhaAntiga(), usuario.getSenha())) {
            throw new SenhaIncorretaException("Senha incorreta!");
        }
        String senhaNovaCriptografada = encoder.encode(dados.senhaNova());
        usuario.atualizarSenha(senhaNovaCriptografada);
        repository.save(usuario);
        return ResponseEntity.ok(new DadosSucesso("Senha atualizada com sucesso!"));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        Usuario usuario = repository.getReferenceById(id);
        usuario.excluir();
        repository.save(usuario);
        return ResponseEntity.noContent().build();
    }
}