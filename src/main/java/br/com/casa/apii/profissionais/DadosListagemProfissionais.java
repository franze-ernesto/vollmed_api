package br.com.casa.apii.profissionais;

import br.com.casa.apii.endereco.DadosEndereco;
import br.com.casa.apii.escolaridade.Escolaridade;

public record DadosListagemProfissionais(
        Long id,
        String nome,
        String idade,
        Escolaridade escolaridade,
        Profissao profissao

) {
    public DadosListagemProfissionais(Profissionais profissionais) {
        this(profissionais.getId(), profissionais.getNome(), profissionais.getIdade(), profissionais.getEscolaridade(), profissionais.getProfissao() );

    }
}
