package tcgob.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcgob.configs.EmailConfig;
import tcgob.services.ConfiguracaoEmailService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/emailConfig")
public class EmailConfigController {

    private final ConfiguracaoEmailService configuracaoEmailService;

    @Autowired
    public EmailConfigController(ConfiguracaoEmailService configuracaoEmailService) {
        this.configuracaoEmailService = configuracaoEmailService;
    }

    @GetMapping
    public ResponseEntity<List<EmailConfig>> getAllEmailConfigs() {
        List<EmailConfig> emailConfigs = configuracaoEmailService.getAllConfiguracaoEmails();
        return ResponseEntity.ok(emailConfigs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmailConfig> getEmailConfigById(@PathVariable UUID id) {
        EmailConfig emailConfig = configuracaoEmailService.getConfiguracaoEmailById(id);
        if (emailConfig != null) {
            return ResponseEntity.ok(emailConfig);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<EmailConfig> createEmailConfig(@RequestBody EmailConfig emailConfig) {
        EmailConfig createdEmailConfig = configuracaoEmailService.createConfiguracaoEmail(emailConfig);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmailConfig);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmailConfig> updateEmailConfig(@PathVariable UUID id, @RequestBody EmailConfig emailConfig) {
        EmailConfig updatedEmailConfig = configuracaoEmailService.updateConfiguracaoEmail(id, emailConfig);
        if (updatedEmailConfig != null) {
            return ResponseEntity.ok(updatedEmailConfig);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmailConfig(@PathVariable UUID id) {
        boolean deleted = configuracaoEmailService.deleteConfiguracaoEmail(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
