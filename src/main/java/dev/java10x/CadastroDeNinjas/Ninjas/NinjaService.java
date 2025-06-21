package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    @Autowired
    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> displayAllNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::toDto)
                .collect(Collectors.toList());
    }

    public NinjaDTO getNinjaById(Long id) {
        Optional<NinjaModel> ninjasById = ninjaRepository.findById(id);
        return ninjasById.map(ninjaMapper::toDto).orElse(null);
    }

    public NinjaDTO createNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = ninjaMapper.toEntity(ninjaDTO); //Converte DTO para Model (para o Service/Repository)
        NinjaModel savedNinja = ninjaRepository.save(ninjaModel); //Chama o Service para salvar (trabalha com Model)
        return ninjaMapper.toDto(savedNinja); //Converte o Model salvo de volta para DTO (resposta da API)
    }

    public void deleteNinjaById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("The ID is null");
        }
        ninjaRepository.deleteById(id);
    }

    public NinjaDTO updateNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExist = ninjaRepository.findById(id);
        if (ninjaExist.isPresent()) {
            NinjaModel updatedNinja = ninjaMapper.toEntity(ninjaDTO);
            updatedNinja.setId(id);
            NinjaModel savedNinja = ninjaRepository.save(updatedNinja);
            return ninjaMapper.toDto(savedNinja);
        }
        return null;
    }
}
