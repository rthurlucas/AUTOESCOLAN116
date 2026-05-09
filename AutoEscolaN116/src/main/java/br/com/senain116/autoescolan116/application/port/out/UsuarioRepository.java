package br.com.senain116.autoescolan116.application.port.out;

import br.com.senain116.autoescolan116.application.core.domain.model.Usuario;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository {
    UserDetails findByLogin(String username);

    Page<Usuario> findAllByAtivoTrue(Pageable paginacao);

    boolean existsByIdAndAtivoTrue(Long id);

    Usuario save(Usuario usuario);

    Optional<Usuario> findById(Long id);

    Usuario getReferenceById(@NotNull Long id);

    void delete(Usuario usuario);
}