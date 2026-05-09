package br.com.senain116.autoescolan116.adapter.out.repository.mapper;

import br.com.senain116.autoescolan116.adapter.out.repository.entity.AlunoEntity;
import br.com.senain116.autoescolan116.adapter.out.repository.entity.InstrucaoEntity;
import br.com.senain116.autoescolan116.adapter.out.repository.entity.InstrutorEntity;
import br.com.senain116.autoescolan116.application.core.domain.model.Aluno;
import br.com.senain116.autoescolan116.application.core.domain.model.Instrucao;
import br.com.senain116.autoescolan116.application.core.domain.model.Instrutor;
import org.springframework.stereotype.Component;

@Component
public class InstrucaoEntityMapper {

    public Instrucao toDomain(InstrucaoEntity entity){
       AlunoEntity alunoEntity = entity.getAluno();
        Aluno aluno = new Aluno(
                alunoEntity.getId(),
                alunoEntity.getNome(),
                alunoEntity.getEmail(),
                alunoEntity.getTelefone(),
                alunoEntity.getCpf(),
                alunoEntity.getEndereco(),
                alunoEntity.isAtivo()
        );

        InstrutorEntity instrutorEntity = entity.getInstrutor();
        Instrutor instrutor = new Instrutor(
                instrutorEntity.getId(),
                instrutorEntity.getNome(),
                instrutorEntity.getEmail(),
                instrutorEntity.getTelefone(),
                instrutorEntity.getCnh(),
                instrutorEntity.getEspecialidade(),
                instrutorEntity.getEndereco(),
                instrutorEntity.isAtivo()

        );

        return new Instrucao(
                entity.getId(),
                aluno,
                instrutor,
                entity.getData()
        );
    }

    public InstrucaoEntity toEntity(Instrucao instrucao){
            AlunoEntity alunoEntity = new AlunoEntity(
                    instrucao.getAluno().getId(),
                    instrucao.getAluno().getNome(),
                    instrucao.getAluno().getEmail(),
                    instrucao.getAluno().getTelefone(),
                    instrucao.getAluno().getCpf(),
                    instrucao.getAluno().getEndereco(),
                    instrucao.getAluno().isAtivo()
            );

            InstrutorEntity instrutorEntity = new InstrutorEntity(
                    instrucao.getInstrutor().getId(),
                    instrucao.getInstrutor().getNome(),
                    instrucao.getInstrutor().getEmail(),
                    instrucao.getInstrutor().getTelefone(),
                    instrucao.getInstrutor().getCnh(),
                    instrucao.getInstrutor().getEspecialidade(),
                    instrucao.getInstrutor().getEndereco(),
                    instrucao.getInstrutor().isAtivo()
            );

            return new InstrucaoEntity(
                    instrucao.getId(),
                    alunoEntity,
                    instrutorEntity,
                    instrucao.getData()
            );
        }
    }
