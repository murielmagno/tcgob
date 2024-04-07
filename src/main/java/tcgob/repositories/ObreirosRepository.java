package tcgob.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tcgob.models.Obreiros;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ObreirosRepository extends JpaRepository<Obreiros, UUID> {

    @Query("SELECT o FROM Obreiros o WHERE o.dataIniciacao <= :dataMinima")
    List<Obreiros> encontrarObreirosComDataIniciacaoMaiorOuIgual(LocalDate dataMinima);

}
