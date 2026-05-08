package br.com.senain116.autoescolan116.adapter.out.repository;

import br.com.senain116.autoescolan116.adapter.out.repository.entity.InstrucaoEntity;
import br.com.senain116.autoescolan116.adapter.out.repository.mapper.InstrucaoEntityMapper;
import br.com.senain116.autoescolan116.adapter.out.repository.persistence.InstrucaoJpaRepository;
import br.com.senain116.autoescolan116.application.core.domain.model.Instrucao;
import br.com.senain116.autoescolan116.application.port.out.InstrucaoRepository;
import org.apache.el.stream.Stream;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

public class InstrucaoRepositoryImpl implements InstrucaoRepository {
    private final InstrucaoEntityMapper mapper;
    private final InstrucaoJpaRepository jpaRepository;

    public InstrucaoRepositoryImpl(InstrucaoJpaRepository jpaRepository, InstrucaoEntityMapper mapper) {
        this.mapper = mapper;
        this.jpaRepository = jpaRepository;
    }

    @Override
    public boolean existsByAlunoIdAndDataBetween(Long id, LocalDateTime inicio, LocalDateTime fim) {
        return false;
    }

    @Override
    public boolean existsByInstrutorIdAndData(Long id, LocalDateTime data) {
        return jpaRepository.existsByInstrutorIdAndData(id, data);
    }

    @Override
    public Instrucao save(Instrucao instrucao) {
        InstrucaoEntity entity = mapper.toEntity(instrucao);
        InstrucaoEntity saved =  jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Instrucao> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Stream findAll(Pageable paginacao) {
        return null;
    }
}
