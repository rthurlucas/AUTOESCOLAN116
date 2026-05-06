package br.com.senain116.autoescolan116.adapter.out.repository.mapper;

import br.com.senain116.autoescolan116.adapter.in.controller.mapper.InstrucaoMapper;
import br.com.senain116.autoescolan116.adapter.out.repository.entity.InstrucaoEntity;
import br.com.senain116.autoescolan116.application.core.domain.model.Instrucao;
import org.springframework.stereotype.Component;

@Component
public class InstrucaoEntityMapper {

    public Instrucao toDomain(InstrucaoEntity entity){
        return new Instrucao(
             entity.getId(),
             entity.getAluno(),
             entity.getInstrutor(),
             entity.getData()
        );
    }

    public InstrucaoEntity toEntity(Instrucao instrucao){
        return new InstrucaoEntity(
                instrucao.getId(),
                instrucao.getAluno(),
                instrucao.getInstrutor(),
                instrucao.getData()
        );
    }
}
