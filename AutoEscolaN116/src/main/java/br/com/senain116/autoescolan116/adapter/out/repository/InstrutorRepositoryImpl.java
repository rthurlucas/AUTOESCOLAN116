package br.com.senain116.autoescolan116.adapter.out.repository;

import br.com.senain116.autoescolan116.adapter.out.repository.mapper.InstrutorEntityMapper;
import br.com.senain116.autoescolan116.adapter.out.repository.persistence.InstrutorJpaRepository;
import br.com.senain116.autoescolan116.application.core.domain.enums.Especialidade;
import br.com.senain116.autoescolan116.application.core.domain.model.Instrutor;
import br.com.senain116.autoescolan116.application.port.out.InstrutorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class InstrutorRepositoryImpl implements InstrutorRepository {
    private final InstrutorJpaRepository jpaRepository;
    private final InstrutorEntityMapper entityMapper;

    public InstrutorRepositoryImpl(InstrutorJpaRepository jpaRepository, InstrutorEntityMapper entityMapper) {
        this.jpaRepository = jpaRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Page<Instrutor> findAllByAtivoTrue(Pageable paginacao) {
        return jpaRepository

                .findAllByAtivoTrue(paginacao)
                .stream()
                .filter(instrutor -> instrutor.isAtivo())
                .map(entityMapper::toDomain);
    }

    @Override
    public Instrutor escolherInstrutorAleatorioDisponivel(Especialidade especialidade, LocalDateTime data) {
        return null;
    }

    @Override
    public boolean isActiveById(Long id) {
        return false;
    }

    @Override
    public Instrutor save(Instrutor instrutor) {
        return null;
    }

    @Override
    public Optional<Instrutor> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean existsByIdAndAtivoTrue(Long aLong) {
        return false;
    }

    @Override
    public Instrutor getReferenceById(Long aLong) {
        return null;
    }
}
