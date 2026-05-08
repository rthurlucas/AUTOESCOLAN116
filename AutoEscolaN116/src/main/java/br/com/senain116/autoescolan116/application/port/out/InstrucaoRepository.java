package br.com.senain116.autoescolan116.application.port.out;

import br.com.senain116.autoescolan116.application.core.domain.model.Instrucao;
import org.apache.el.stream.Stream;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

public interface InstrucaoRepository{
    boolean existsByAlunoIdAndDataBetween(Long id, LocalDateTime inicio, LocalDateTime fim);

    boolean existsByInstrutorIdAndData(Long id, LocalDateTime data);

    Instrucao save(Instrucao instrucao);
    Optional<Instrucao> findById(Long id);

    Stream findAll(Pageable paginacao);
}