package br.com.senain116.autoescolan116.application.port.out;

import br.com.senain116.autoescolan116.application.core.domain.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository {
    UserDetails findByLogin(String username);

    Page<Usuario> findAllByAtivoTrue(Pageable paginacao);

    boolean existsByIdAndAtivoTrue(Long id);

    Usuario save(Usuario usuario);

    Usuario findById(Long id);
}