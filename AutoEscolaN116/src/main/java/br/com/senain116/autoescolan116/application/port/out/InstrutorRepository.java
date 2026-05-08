package br.com.senain116.autoescolan116.application.port.out;

import br.com.senain116.autoescolan116.application.core.domain.enums.Especialidade;
import br.com.senain116.autoescolan116.application.core.domain.model.Instrutor;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Stream;

public interface InstrutorRepository{
    Stream findAllByAtivoTrue(Pageable paginacao);
    boolean isActiveById(Long id);
    Instrutor save(Instrutor instrutor);
    Optional<Instrutor> findById(Long id);
    boolean existsByIdAndAtivoTrue(Long aLong);
    Instrutor getReferenceById(Long aLong);
    Instrutor escolherInstrutorAleatorioDisponivel(Especialidade especialidade, @NotNull @Future LocalDateTime data);
}