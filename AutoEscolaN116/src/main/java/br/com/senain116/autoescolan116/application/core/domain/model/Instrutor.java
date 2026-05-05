package br.com.senain116.autoescolan116.application.core.domain.model;

import br.com.senain116.autoescolan116.application.core.domain.vo.Endereco;
import br.com.senain116.autoescolan116.application.core.domain.enums.Especialidade;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public class Instrutor {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cnh;

    public Instrutor() {
    }

    public Instrutor(Long id, String nome, String email, String telefone, String cnh, Especialidade especialidade, Endereco endereco, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cnh = cnh;
        this.especialidade = especialidade;
        this.endereco = endereco;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCnh() {
        return cnh;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    private Especialidade especialidade;

    private Endereco endereco;
    private boolean ativo = true;

    public void atualizarInformacoes() {
        if (nome != null && !nome.isBlank()) {
            this.nome = nome;
        }
        if (email != null && !email.isBlank()) {
            this.email = email;
        }
        if (telefone != null && !telefone.isBlank()) {
            this.telefone = telefone;
        }
        if (especialidade != null) {
            this.especialidade = especialidade;
        }
        if (endereco != null) {
            this.endereco.atualizarInformacoes(
                    endereco.getLogradouro(),
                    endereco.getNumero(),
                    endereco.getComplemento(),
                    endereco.getBairro(),
                    endereco.getCidade(),
                    endereco.getUf(),
                    endereco.getCep()
                    );
        }
    }

    public void excluir() {
        this.ativo = false;
    }

}