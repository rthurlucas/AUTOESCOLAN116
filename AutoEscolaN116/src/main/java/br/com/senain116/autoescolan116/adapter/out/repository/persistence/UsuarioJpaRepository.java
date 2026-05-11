    package br.com.senain116.autoescolan116.adapter.out.repository.persistence;

    import br.com.senain116.autoescolan116.adapter.out.repository.entity.UsuarioEntity;
    import br.com.senain116.autoescolan116.application.core.domain.model.Usuario;
    import jakarta.validation.constraints.NotNull;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.data.jpa.repository.JpaRepository;

    import java.util.Optional;

    public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
        Optional <UsuarioEntity> findByLogin(String login);
        Page<UsuarioEntity> findAllByAtivoTrue(Pageable paginacao);
        boolean existsByIdAndAtivoTrue(Long id);
        Optional<UsuarioEntity> findById(Long id);
    }
