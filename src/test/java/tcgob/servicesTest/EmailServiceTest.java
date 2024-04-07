package tcgob.servicesTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tcgob.services.EmailService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void testEnviarEmailSemImagem() {
        String nomeDoUsuario = "muriel";
        String destinatario = "magnomuriel@gmail.com";
        String assunto = "Teste de envio de e-mail";
        String mensagem = "Olá! Este é um e-mail de teste.";

        emailService.enviarEmail(destinatario, assunto, mensagem, nomeDoUsuario);
    }
}
