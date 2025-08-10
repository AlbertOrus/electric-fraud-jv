package adapter.cli;

import core.ports.in.FraudDetection;
import domain.ReadingFraudResult;

import java.util.List;

public class CLIHandler {

    private final FraudDetection fraudDetectionService;

    public CLIHandler(FraudDetection fraudDetectionService) {
        this.fraudDetectionService = fraudDetectionService;
    }

    public void run(String[] args) {

        if(args.length == 0) {
            System.out.println("Error, input readings file");
        } else {
            System.out.printf("| %-18s | %-18s | %-17s | %-6s %n", "Client", "Month", "Suspicious", "Median");
            System.out.println("-------------------------------------------------------------------------------");
            List<ReadingFraudResult> fraudResults = fraudDetectionService.detectFrauds();
            for (ReadingFraudResult result : fraudResults) {
                System.out.printf("| %-18s | %-18s | %-17d | %-6d %n",
                        result.getReading().getCustomerId(),
                        result.getReading().getMonth().toString(),
                        result.getReading().getValueKwh(),
                        result.getMedianKwh());
            }

        }

    }

}
