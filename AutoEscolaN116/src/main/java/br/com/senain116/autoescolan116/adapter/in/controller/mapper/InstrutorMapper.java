package br.com.senain116.autoescolan116.adapter.in.controller.mapper;

import br.com.senain116.autoescolan116.adapter.in.controller.request.instrutor.DadosCadastroInstrutor;
import br.com.senain116.autoescolan116.application.core.domain.model.Instrutor;

public class InstrutorMapper {
    private final EnderecoMapper enderecoMapper;

    public InstrutorMapper(EnderecoMapper enderecoMapper) {
        this.enderecoMapper = enderecoMapper;
    }

    public Instrutor toDomain(DadosCadastroInstrutor dados){

    }
}
