package tcgob.configs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;


@Entity
@Data
public class EmailConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String host;
    private int port;
    private String username;
    private String password;
    private String token;

}
