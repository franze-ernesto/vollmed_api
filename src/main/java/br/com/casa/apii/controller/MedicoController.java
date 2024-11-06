package br.com.casa.apii.controller;

import br.com.casa.apii.profissionais.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profissionais")
public class MedicoController {
    @Autowired
    private ProfissionaisRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroProfissionais dados){
        repository.save(new Profissionais(dados));

    }

    @GetMapping
    public Page<DadosListagemProfissionais> listar(@PageableDefault(size = 10, sort = {"nome"} )Pageable pageable) {
        return repository.findAllByAtivoTrue(pageable).map(DadosListagemProfissionais::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoProfissionais dados){
        var profissao = repository.getReferenceById(dados.id());
        profissao.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var profissao = repository.getReferenceById(id);
        profissao.excluir();
    }



}
