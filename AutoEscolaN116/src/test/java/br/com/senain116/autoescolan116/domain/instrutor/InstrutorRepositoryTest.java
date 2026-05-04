/*package br.com.senain116.autoescolan116.domain.instrutor;

import br.com.senain116.autoescolan116.adapter.in.controller.mapper.EnderecoMapper;
import br.com.senain116.autoescolan116.application.core.domain.model.Aluno;
import br.com.senain116.autoescolan116.adapter.in.controller.request.aluno.DadosCadastroAluno;
import br.com.senain116.autoescolan116.adapter.in.controller.request.endereco.DadosEndereco;
import br.com.senain116.autoescolan116.application.core.domain.model.Instrucao;
import br.com.senain116.autoescolan116.adapter.in.controller.request.instrutor.DadosCadastroInstrutor;
import br.com.senain116.autoescolan116.application.core.domain.enums.Especialidade;
import br.com.senain116.autoescolan116.application.core.domain.model.Instrutor;
import br.com.senain116.autoescolan116.application.core.domain.vo.Endereco;
import br.com.senain116.autoescolan116.application.port.out.InstrutorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class InstrutorRepositoryTest {
    @Autowired
    private InstrutorRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EnderecoMapper enderecoMapper;

    @Test
    @DisplayName("Expectativa: retornar null quanto não há instrutor disponível")
    void escolherInstrutorAleatorioDisponivelCenario1() {
        LocalDateTime proximaSegundaAs10 = LocalDateTime
                .now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .withHour(10)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);

        Instrutor instrutor = cadastrarInstrutor(
                "Instrutor Teste",
                "instrutor@teste.com.br",
                "01234567890",
                Especialidade.CAMINHOES
        );
        Aluno aluno = cadastrarAluno(
                "Aluno Teste",
                "aluno@teste.com.br",
                "09876543210"
        );
        agendarInstrucao(instrutor, aluno, proximaSegundaAs10);

        Instrutor instrutorDisponivel = repository.escolherInstrutorAleatorioDisponivel(
                Especialidade.CAMINHOES,
                proximaSegundaAs10
        );

        assertThat(instrutorDisponivel).isNull();
    }

    @Test
    @DisplayName("Expectativa: retornar um instrutor quanto estiver disponível")
    void escolherInstrutorAleatorioDisponivelCenario2() {
        LocalDateTime proximaSegundaAs10 = LocalDateTime
                .now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .withHour(10)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);

        Instrutor instrutor = cadastrarInstrutor(
                "Instrutor Teste",
                "instrutor@teste.com.br",
                "01234567890",
                Especialidade.CAMINHOES
        );

        Instrutor instrutorDisponivel = repository.escolherInstrutorAleatorioDisponivel(
                Especialidade.CAMINHOES,
                proximaSegundaAs10
        );

        assertThat(instrutorDisponivel).isEqualTo(instrutor);
    }

    private Instrutor cadastrarInstrutor(
            String nome,
            String email,
            String cnh,
            Especialidade especialidade) {
        Instrutor instrutor = new Instrutor(dadosCadastroInstrutor(
                nome,
                email,
                cnh,
                especialidade
        ));
        entityManager.persist(instrutor);
        return instrutor;
    }

    private DadosCadastroInstrutor dadosCadastroInstrutor(
            String nome,
            String email,
            String cnh,
            Especialidade especialidade) {
        return new DadosCadastroInstrutor(
                nome,
                email,
                "(11) 98765-4321",
                cnh,
                especialidade,
                dadosEndereco()
        );
    }

    private Aluno cadastrarAluno(
            String nome,
            String email,
            String telefone,
            String cpf,
            DadosEndereco endereco) {
        Aluno aluno = new Aluno(dadosCadastroAluno(
                nome,
                email,
                telefone,
                cpf,
                enderecoMapper.toDomain(endereco)
        ));
        entityManager.persist(aluno);
        return aluno;
    }

    private DadosCadastroAluno dadosCadastroAluno(
            String nome,
            String email,
            String cpf) {
        return new DadosCadastroAluno(
                nome,
                email,
                "(11) 91234-5678",
                cpf,
                dadosEndereco()
        );
    }

    private DadosEndereco dadosEndereco() {
        return new DadosEndereco(
                "Rua Teste",
                "000",
                "Apto. 00",
                "Vizinhança Teste",
                "Cidade Teste",
                "TE",
                "12345678"
        );
    }

    private void agendarInstrucao(
            Instrutor instrutor,
            Aluno aluno,
            LocalDateTime data) {
        Instrucao instrucao = new Instrucao(
                null,
                aluno,
                instrutor,
                data
        );
        entityManager.persist(instrucao);
    }
}*/