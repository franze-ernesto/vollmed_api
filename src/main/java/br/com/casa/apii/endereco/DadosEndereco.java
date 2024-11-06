package br.com.casa.apii.endereco;

public record DadosEndereco(
        String rua,
        String numero,
        String complemento,
        String cep,
        String bairro,
        String cidade,
        String uf

) {
}
