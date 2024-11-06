package br.com.casa.apii.profissionais;

import br.com.casa.apii.endereco.DadosEndereco;
import br.com.casa.apii.endereco.Endereco;
import br.com.casa.apii.escolaridade.Escolaridade;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "profissao2")
@Entity(name = "Profissionais")
public class Profissionais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String rg;
    private String idade;
    private String cpf;


    @Enumerated(EnumType.STRING)
    private Escolaridade escolaridade;
    @Enumerated(EnumType.STRING)
    private Profissao profissao;
    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Profissionais(DadosCadastroProfissionais dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.rg = dados.rg();
        this.idade = dados.idade();
        this.cpf =  dados.cpf();
        this.escolaridade = dados.escolaridade();
        this.profissao = dados.profissao();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoProfissionais dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
