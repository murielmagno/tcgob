package tcgob.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcgob.models.Obreiros;
import tcgob.services.ObreirosService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/obreiros")
public class ObreirosController {

    private final ObreirosService obreirosService;

    @Autowired
    public ObreirosController(ObreirosService obreirosService) {
        this.obreirosService = obreirosService;
    }

    @GetMapping
    public ResponseEntity<List<Obreiros>> listarObreiros() {
        List<Obreiros> obreiros = obreirosService.listarTodosObreiros();
        return ResponseEntity.ok(obreiros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Obreiros> buscarObreiroPorId(@PathVariable UUID id) {
        Obreiros obreiro = obreirosService.buscarObreiroPorId(id);
        if (obreiro != null) {
            return ResponseEntity.ok(obreiro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Obreiros> cadastrarObreiro(@RequestBody Obreiros obreiro) {
        Obreiros novoObreiro = obreirosService.cadastrarObreiro(obreiro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoObreiro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Obreiros> atualizarObreiro(@PathVariable UUID id, @RequestBody Obreiros obreiroAtualizado) {
        Obreiros obreiro = obreirosService.atualizarObreiro(id, obreiroAtualizado);
        if (obreiro != null) {
            return ResponseEntity.ok(obreiro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirObreiro(@PathVariable UUID id) {
        boolean sucesso = obreirosService.excluirObreiro(id);
        if (sucesso) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
