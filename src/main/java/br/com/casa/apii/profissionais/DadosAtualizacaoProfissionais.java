package br.com.casa.apii.profissionais;

import br.com.casa.apii.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProfissionais(
        @NotNull
        Long id,
        String nome,
        DadosEndereco endereco

) {
}
