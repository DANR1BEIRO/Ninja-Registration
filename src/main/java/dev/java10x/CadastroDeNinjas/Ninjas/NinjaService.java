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

    public NinjaModel createNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    public void deleteNinjaById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("The ID is null");
        }
        ninjaRepository.deleteById(id);
    }

    public NinjaModel updateNinja(Long id, NinjaModel ninja) {
        if (ninjaRepository.existsById(id)) {   // se o ninja existir(ID)
            ninja.setId(id);                    // setta o id
            return ninjaRepository.save(ninja); // retorna o ninja atualizado
        }
        return null;
    }
}
