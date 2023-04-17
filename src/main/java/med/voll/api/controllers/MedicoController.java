package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dtos.DadosAtualizacaoMedico;
import med.voll.api.dtos.DadosCadastroMedico;
import med.voll.api.dtos.DadosListagemMedico;
import med.voll.api.entities.Medico;
import med.voll.api.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        medicoRepository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 15, sort = {"nome"}) Pageable paginacao) {
        return medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping("{id}")
    @Transactional
    public void atualizar(@PathVariable("id") Long id, @RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = medicoRepository.getReferenceById(id);
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("{id}")
    @Transactional
    public void excluir(@PathVariable("id") Long id) {
        //medicoRepository.deleteById(id);
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
    }
}
