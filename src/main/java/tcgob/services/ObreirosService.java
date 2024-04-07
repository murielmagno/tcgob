package tcgob.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcgob.models.Obreiros;
import tcgob.repositories.ObreirosRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ObreirosService {

    private final ObreirosRepository obreirosRepository;

    @Autowired
    public ObreirosService(ObreirosRepository obreirosRepository) {
        this.obreirosRepository = obreirosRepository;
    }

    public List<Obreiros> listarTodosObreiros() {
        return obreirosRepository.findAll();
    }

    public Obreiros buscarObreiroPorId(UUID id) {
        Optional<Obreiros> optionalObreiro = obreirosRepository.findById(id);
        return optionalObreiro.orElse(null);
    }

    public Obreiros cadastrarObreiro(Obreiros obreiro) {
        return obreirosRepository.save(obreiro);
    }

    public Obreiros atualizarObreiro(UUID id, Obreiros obreiroAtualizado) {
        Optional<Obreiros> optionalObreiro = obreirosRepository.findById(id);
        if (optionalObreiro.isPresent()) {
            Obreiros obreiroExistente = optionalObreiro.get();
            obreiroExistente.setNome(obreiroAtualizado.getNome());
            // Atualize os outros atributos conforme necessário
            return obreirosRepository.save(obreiroExistente);
        } else {
            return null;
        }
    }

    public boolean excluirObreiro(UUID id) {
        if (obreirosRepository.existsById(id)) {
            obreirosRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Obreiros> encontrarObreirosComDataIniciacaoMaiorOuIgual (LocalDate dataMinima) {
        return obreirosRepository.encontrarObreirosComDataIniciacaoMaiorOuIgual(dataMinima);
    }
}

