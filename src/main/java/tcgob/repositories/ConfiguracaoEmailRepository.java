package tcgob.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcgob.configs.EmailConfig;

import java.util.UUID;

@Repository
public interface ConfiguracaoEmailRepository extends JpaRepository<EmailConfig, UUID> {
}
