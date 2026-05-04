package br.com.senain116.autoescolan116.adapter.in.controller.response.instrutor;

import br.com.senain116.autoescolan116.adapter.in.controller.request.endereco.DadosEndereco;
import br.com.senain116.autoescolan116.application.core.domain.enums.Especialidade;
import br.com.senain116.autoescolan116.application.core.domain.model.Instrutor;

public record DadosDetalhamentoInstrutor(
        Long id,
        String nome,
        String email,
        String telefone,
        String cnh,
        Especialidade especialidade,
        DadosEndereco endereco,
        boolean ativo) {
    public DadosDetalhamentoInstrutor(Instrutor instrutor) {
        this(
                instrutor.getId(),
                instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getTelefone(),
                instrutor.getCnh(),
                instrutor.getEspecialidade(),
                new DadosEndereco(
                        instrutor.getEndereco().getLogradouro(),
                        instrutor.getEndereco().getNumero(),
                        instrutor.getEndereco().getComplemento(),
                        instrutor.getEndereco().getBairro(),
                        instrutor.getEndereco().getCidade(),
                        instrutor.getEndereco().getUf(),
                        instrutor.getEndereco().getCep()
                ),
                instrutor.isAtivo()
        );
    }
}