package br.com.senain116.autoescolan116.adapter.in.controller.response.usuario;

import br.com.senain116.autoescolan116.application.core.domain.enums.Perfil;
import br.com.senain116.autoescolan116.application.core.domain.model.Usuario;

public record DadosListagemUsuario(
        Long id,
        String login,
        Perfil perfil) {
    public DadosListagemUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getLogin(),
                usuario.getPerfil()
        );
    }
}