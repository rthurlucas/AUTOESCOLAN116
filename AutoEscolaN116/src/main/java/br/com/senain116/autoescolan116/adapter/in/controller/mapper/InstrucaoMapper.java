package br.com.senain116.autoescolan116.adapter.in.controller.mapper;

import br.com.senain116.autoescolan116.adapter.in.controller.response.instrucao.DadosDetalhamentoAgendamento;
import br.com.senain116.autoescolan116.adapter.in.controller.response.instrucao.DadosListagemInstrucao;
import br.com.senain116.autoescolan116.application.core.domain.model.Instrucao;
import org.springframework.stereotype.Component;

@Component
public class InstrucaoMapper {
    public Instrucao toDomain(Instrucao instrucao){
        return new Instrucao(
                instrucao.getId(),
                instrucao.getAluno(),
                instrucao.getInstrutor(),
                instrucao.getData()
        );
    }

    public DadosListagemInstrucao toListDTO(Instrucao instrucao){
        return new DadosListagemInstrucao(
                instrucao.getId(),
                instrucao.getAluno().getNome(),
                instrucao.getInstrutor().getNome(),
                instrucao.getData()
        );
    }

    public DadosDetalhamentoAgendamento toDetails(Instrucao instrucao){
        return new DadosDetalhamentoAgendamento(
                instrucao.getId(),
                instrucao.getAluno().getId(),
                instrucao.getInstrutor().getId(),
                instrucao.getInstrutor().getEspecialidade(),
                instrucao.getData()
        );
    }
}
