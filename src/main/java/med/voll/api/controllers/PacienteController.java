package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dtos.DadosAtualizacaoPaciente;
import med.voll.api.dtos.DadosCadastroPaciente;
import med.voll.api.dtos.DadosListagemPaciente;
import med.voll.api.entities.Paciente;
import med.voll.api.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        pacienteRepository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(size = 15, sort = {"nome"}) Pageable paginacao) {
        return pacienteRepository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }

    @PutMapping("{id}")
    @Transactional
    public void atualizar(@PathVariable("id") Long id, @RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping("{id}")
    @Transactional
    public void excluir(@PathVariable("id") Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
    }
}
