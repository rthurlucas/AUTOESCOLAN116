package br.com.senain116.autoescolan116.adapter.out.repository.persistence;

import br.com.senain116.autoescolan116.adapter.out.repository.entity.InstrucaoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface InstrucaoJpaRepository extends JpaRepository<InstrucaoEntity, Long> {
    boolean existsByAlunoIdAndDataBetween(Long id, LocalDateTime inicio, LocalDateTime fim);
    boolean existsByInstrutorIdAndData(Long id, LocalDateTime data);
    Page<InstrucaoEntity> findAll(Pageable paginacao);
    Optional<InstrucaoEntity> findById(Long id);
}
