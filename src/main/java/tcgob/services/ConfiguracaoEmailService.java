package tcgob.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcgob.configs.EmailConfig;
import tcgob.repositories.ConfiguracaoEmailRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConfiguracaoEmailService {

    @Autowired
    private ConfiguracaoEmailRepository configuracaoEmailRepository;

    public EmailConfig getConfiguracaoEmail() {
        return configuracaoEmailRepository.findAll().stream().findFirst().orElse(null);
    }

    public List<EmailConfig> getAllConfiguracaoEmails() {
        return configuracaoEmailRepository.findAll();
    }

    public EmailConfig getConfiguracaoEmailById(UUID id) {
        Optional<EmailConfig> emailConfigOptional = configuracaoEmailRepository.findById(id);
        return emailConfigOptional.orElse(null);
    }

    public EmailConfig createConfiguracaoEmail(EmailConfig emailConfig) {
        return configuracaoEmailRepository.save(emailConfig);
    }

    public EmailConfig updateConfiguracaoEmail(UUID id, EmailConfig emailConfig) {
        if (configuracaoEmailRepository.existsById(id)) {
            emailConfig.setId(id);
            return configuracaoEmailRepository.save(emailConfig);
        } else {
            return null;
        }
    }

    public boolean deleteConfiguracaoEmail(UUID id) {
        if (configuracaoEmailRepository.existsById(id)) {
            configuracaoEmailRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
