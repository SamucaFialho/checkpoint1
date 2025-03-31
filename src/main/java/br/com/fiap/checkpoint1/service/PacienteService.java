package br.com.fiap.checkpoint1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint1.dto.PacienteRequestUpdate;
import br.com.fiap.checkpoint1.model.Paciente;


@Service
public class PacienteService {

    private List<Paciente> pacientes = new ArrayList<>();
    private Long sequence = 1L;

    public Paciente createPaciente(PacienteRequestUpdate dto){
        Paciente paciente = new Paciente();
        paciente.setId(sequence++);
        paciente.setBairro(paciente.getBairro());
        paciente.setEmail(paciente.getEmail());
        paciente.setEndereco(paciente.getEndereco());
        paciente.setNome(paciente.getNome());
        paciente.setTelefone(paciente.getTelefone());
        pacientes.add(paciente);
        return paciente;
    }

    public Optional<Paciente> getProductById(Long id) {
        
         return pacientes.stream()
         .filter(p -> p.getId().equals(id))
         .findFirst();
        
    }

    public List<Paciente> getAll(){
        return pacientes;
    }

    public Optional<Paciente> UpdatePaciente(Long id, PacienteRequestUpdate dto){
        return pacientes.stream().filter(p -> p.getId().equals(id))
                  .findFirst()
                  .map(p -> {
                      p.setId(dto.getId());
                     return p;
               });} 

    public boolean DeletePaciente(Long id){
        return pacientes.removeIf(p -> p.getId().equals(id));
    }
        
    
    

}
