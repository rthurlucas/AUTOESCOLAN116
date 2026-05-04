package br.com.senain116.autoescolan116.application.port.out;

import br.com.senain116.autoescolan116.application.core.domain.model.Instrucao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface InstrucaoRepository extends JpaRepository<Instrucao, Long> {
    boolean existsByAlunoIdAndDataBetween(Long id, LocalDateTime inicio, LocalDateTime fim);

    boolean existsByInstrutorIdAndData(Long id, LocalDateTime data);
}