package br.com.senain116.autoescolan116.adapter.out.repository;

import br.com.senain116.autoescolan116.adapter.in.controller.UsuarioController;
import br.com.senain116.autoescolan116.adapter.out.repository.persistence.UsuarioJpaRepository;
import br.com.senain116.autoescolan116.application.core.domain.model.Usuario;
import br.com.senain116.autoescolan116.application.port.out.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioRepositoryImpl implements UsuarioRepository {
    private final UsuarioJpaRepository jpaRepository;

    public UsuarioRepositoryImpl(UsuarioJpaRepository jpaRepository){
        this.jpaRepository = jpaRepository;
    }

    @Override
    public UserDetails findByLogin(String username) {
        return null;
    }

    @Override
    public Page<Usuario> findAllByAtivoTrue(Pageable paginacao) {
        return null;
    }

    @Override
    public boolean existsByIdAndAtivoTrue(Long id) {
        return false;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return null;
    }

    @Override
    public Usuario findById(Long id) {
        return null;
    }
}
