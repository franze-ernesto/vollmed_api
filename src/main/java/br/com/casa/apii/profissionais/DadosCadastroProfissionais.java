package br.com.casa.apii.profissionais;

import br.com.casa.apii.endereco.DadosEndereco;
import br.com.casa.apii.escolaridade.Escolaridade;

public record DadosCadastroProfissionais(
        String nome,
        String rg,
        String idade,
        String cpf,
        Escolaridade escolaridade,
        Profissao profissao,
        DadosEndereco endereco

) {
}
