package tcgob.services;

import com.mailersend.sdk.MailerSend;
import com.mailersend.sdk.MailerSendResponse;
import com.mailersend.sdk.emails.Email;
import com.mailersend.sdk.exceptions.MailerSendException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class EmailService {

    private final ConfiguracaoEmailService configuracaoEmailService;

    @Autowired
    public EmailService(ConfiguracaoEmailService configuracaoEmailService) {
        this.configuracaoEmailService = configuracaoEmailService;
    }

    public void enviarEmail(String destinatario, String assunto, String corpoEmail, String nomeDoUsuario) {
        Email email = new Email();

        email.setFrom("Nox Software", configuracaoEmailService.getConfiguracaoEmail().getUsername());
        String inicioEmail = "<html>\n" +
                "<body>\n" ;
        String saudacao = "<h2>\n Prezado irmão " + nomeDoUsuario + ", </h2>\n";
        String fimEmail = "</html>\n" +
                "</body>\n" ;
        email.addRecipient(nomeDoUsuario, destinatario);
        email.setSubject(assunto);
        email.setHtml(inicioEmail + saudacao + corpoEmail + fimEmail);
        MailerSend ms = new MailerSend();
        ms.setToken(configuracaoEmailService.getConfiguracaoEmail().getToken());

        try {
            MailerSendResponse response = ms.emails().send(email);
            Logger.getLogger(response.responseStatusCode + response.messageId);
        } catch (MailerSendException e) {
            e.printStackTrace();
        }
    }

}

