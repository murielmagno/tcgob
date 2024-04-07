package tcgob.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tcgob.enums.EnumTitulos;
import tcgob.models.Obreiros;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Service
public class TitulosService {

    private ObreirosService obreirosService;
    private EmailService emailService;

    @Autowired
    public void obreirosService(ObreirosService obreirosService, EmailService emailService) {
        this.emailService = emailService;
        this.obreirosService = obreirosService;
    }

    @Scheduled(cron = "0 0/1 * * * *")
    @Transactional
    public void executeDailyTask() {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.info("Executando tarefa de envio do email");
        try {
            getBenemerito();
            getGrandeBenemerito();
            getEstrela();
            getCruz();
            getDomPedro();
            logger.info("Processo concluído com sucesso");
        } catch (Exception e) {
            logger.severe("Erro ao executar a tarefa: " + e.getMessage());
            // Tratar o erro conforme necessário
        }
    }

    private void getBenemerito() {
        String assunto = "Parabenizamos por alcançar o prestigioso título de Benemérito da Ordem";
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataMinima = dataAtual.minusYears(25);
        List<Obreiros> obreirosList = obreirosService.encontrarObreirosComDataIniciacaoMaiorOuIgual(dataMinima);
        if (!obreirosList.isEmpty()) {
            for (Obreiros obreiro : obreirosList) {
                if (obreiro.getAltBenemerito() < 3) {
                    obreiro.setAltBenemerito(obreiro.getAltBenemerito() + 1);
                    emailService.enviarEmail(obreiro.getEmail(), assunto, EnumTitulos.BENEMERITO.getMensagem(), obreiro.getNome());
                    obreirosService.atualizarObreiro(obreiro.getId(), obreiro);
                } else {
                    Logger logger = Logger.getLogger(getClass().getName());
                    logger.info("Obreiro: " + obreiro.getNome() + " já alertado 3 vezes");
                }
            }
        }
    }

    private void getGrandeBenemerito() {
        String assunto = "Parabenizamos por alcançar o prestigioso título de Grande Benemérito da Ordem";
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataMinima = dataAtual.minusYears(30);
        List<Obreiros> obreirosList = obreirosService.encontrarObreirosComDataIniciacaoMaiorOuIgual(dataMinima);
        if (!obreirosList.isEmpty()) {
            for (Obreiros obreiro : obreirosList) {
                if (obreiro.getAltGranBenemerito() < 3) {
                    obreiro.setAltBenemerito(obreiro.getAltBenemerito() + 1);
                    emailService.enviarEmail(obreiro.getEmail(), assunto, EnumTitulos.GRANDE_BENEMERITO.getMensagem(), obreiro.getNome());
                    obreirosService.atualizarObreiro(obreiro.getId(), obreiro);
                } else {
                    Logger logger = Logger.getLogger(getClass().getName());
                    logger.info("Obreiro: " + obreiro.getNome() + " já alertado 3 vezes");
                }
            }
        }
    }

    private void getEstrela() {
        String assunto = "Parabenizamos por alcançar o prestigioso título Estrela da Distinção Maçônica";
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataMinima = dataAtual.minusYears(35);
        List<Obreiros> obreirosList = obreirosService.encontrarObreirosComDataIniciacaoMaiorOuIgual(dataMinima);
        if (!obreirosList.isEmpty()) {
            for (Obreiros obreiro : obreirosList) {
                if (obreiro.getAltEstrela() < 3) {
                    obreiro.setAltBenemerito(obreiro.getAltBenemerito() + 1);
                    emailService.enviarEmail(obreiro.getEmail(), assunto, EnumTitulos.ESTRELA_DA_DISTINCAO.getMensagem(), obreiro.getNome());
                    obreirosService.atualizarObreiro(obreiro.getId(), obreiro);
                } else {
                    Logger logger = Logger.getLogger(getClass().getName());
                    logger.info("Obreiro: " + obreiro.getNome() + " já alertado 3 vezes");
                }
            }
        }
    }

    private void getCruz() {
        String assunto = "Parabenizamos por alcançar o prestigioso título Cruz da Perfeição Maçônica";
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataMinima = dataAtual.minusYears(40);
        List<Obreiros> obreirosList = obreirosService.encontrarObreirosComDataIniciacaoMaiorOuIgual(dataMinima);
        if (!obreirosList.isEmpty()) {
            for (Obreiros obreiro : obreirosList) {
                if (obreiro.getAltCruz() < 3) {
                    obreiro.setAltBenemerito(obreiro.getAltBenemerito() + 1);
                    emailService.enviarEmail(obreiro.getEmail(), assunto, EnumTitulos.CRUZ_DA_PERFEICAO.getMensagem(), obreiro.getNome());
                    obreirosService.atualizarObreiro(obreiro.getId(), obreiro);
                } else {
                    Logger logger = Logger.getLogger(getClass().getName());
                    logger.info("Obreiro: " + obreiro.getNome() + " já alertado 3 vezes");
                }
            }
        }
    }

    private void getDomPedro() {
        String assunto = "Parabenizamos por alcançar o prestigioso título Comenda da Ordem do Mérito de D. Pedro I";
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataMinima = dataAtual.minusYears(40);
        List<Obreiros> obreirosList = obreirosService.encontrarObreirosComDataIniciacaoMaiorOuIgual(dataMinima);
        if (!obreirosList.isEmpty()) {
            for (Obreiros obreiro : obreirosList) {
                if (obreiro.getAltDomPedro() < 3) {
                    obreiro.setAltBenemerito(obreiro.getAltBenemerito() + 1);
                    emailService.enviarEmail(obreiro.getEmail(), assunto, EnumTitulos.ORDEM_DO_MERITO_D_PEDRO_I.getMensagem(), obreiro.getNome());
                    obreirosService.atualizarObreiro(obreiro.getId(), obreiro);
                } else {
                    Logger logger = Logger.getLogger(getClass().getName());
                    logger.info("Obreiro: " + obreiro.getNome() + " já alertado 3 vezes");
                }
            }
        }
    }

}
