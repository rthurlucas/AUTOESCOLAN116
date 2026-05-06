package br.com.senain116.autoescolan116.adapter.in.controller.response.instrucao;

import java.time.LocalDateTime;

public record DadosListagemInstrucao(
        Long id,
        String nomeAluno,
        String nomeInstrutor,
        LocalDateTime dataHora
) {
}
