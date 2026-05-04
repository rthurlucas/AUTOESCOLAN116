package br.com.senain116.autoescolan116.adapter.in.controller.response.usuario;

import br.com.senain116.autoescolan116.application.core.domain.enums.Perfil;
import br.com.senain116.autoescolan116.application.core.domain.model.Usuario;

public record DadosDetalhamentoUsuario(
        Long id,
        String login,
        boolean ativo,
        Perfil perfil) {
    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getLogin(),
                usuario.isAtivo(),
                usuario.getPerfil()
        );
    }
}