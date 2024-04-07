package tcgob.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tcgob.services.TitulosService;

@Component
public class BatchEmailRunner implements CommandLineRunner {

    private final TitulosService titulosService;

    @Autowired
    public BatchEmailRunner(TitulosService titulosService) {
        this.titulosService = titulosService;
    }

    @Override
    public void run(String... args) throws Exception {
        titulosService.executeDailyTask();
    }
}
