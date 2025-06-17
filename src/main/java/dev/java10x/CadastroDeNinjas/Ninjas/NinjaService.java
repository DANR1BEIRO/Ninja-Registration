package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> displayAllNinjas() {
        return ninjaRepository.findAll();
    }

    public Optional<NinjaModel> getNinjaById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("The ID can't be null");
        }
        return ninjaRepository.findById(id);
    }
}









/*
 * O @Autowired é uma anotação que o Spring usa para injetar automaticamente uma
 * dependência (ou seja, um objeto de outra classe) dentro da sua classe atual,
 * sem você precisar criar esse objeto manualmente com new.*/