package adapter.cli;

import core.ports.in.FraudDetection;
import domain.Reading;
import domain.ReadingFraudResult;
import org.junit.jupiter.api.Test;

import java.util.List;

class CLIHandlerTest {

    static class MockFraudDetectionService implements FraudDetection {

        @Override
        public List<ReadingFraudResult> detectFrauds() {
            return List.of(
                    new ReadingFraudResult(new Reading(
                            "client_1",
                            900,
                            "2025-7"
                    ),120),
                    new ReadingFraudResult(new Reading(
                            "client_2",
                            870,
                            "2025-8"
                    ),141)

            );
        }
    }

    @Test
    void showFrauds() {

        MockFraudDetectionService detectionService = new MockFraudDetectionService();
        CLIHandler cliHandler = new CLIHandler(detectionService);
        cliHandler.showFrauds();

    }

}