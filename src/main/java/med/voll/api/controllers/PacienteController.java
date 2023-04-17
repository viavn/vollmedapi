package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dtos.*;
import med.voll.api.entities.Paciente;
import med.voll.api.exceptions.RecordNotFoundException;
import med.voll.api.repositories.PacienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    private PacienteRepository pacienteRepository;

    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping("/{id}")
    public DadosDetalhamentoPaciente obtemPorId(@PathVariable("id") Long id) {
        return pacienteRepository.findById(id).map(DadosDetalhamentoPaciente::new)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(size = 15, sort = {"nome"}) Pageable paginacao) {
        return pacienteRepository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriBuilder) {
        var paciente = pacienteRepository.save(new Paciente(dados));
        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));
    }

    @PutMapping("/{id}")
    @Transactional
    public DadosListagemPaciente atualizar(@PathVariable("id") Long id, @RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.atualizarInformacoes(dados);
        return new DadosListagemPaciente(paciente);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable("id") Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
    }
}
