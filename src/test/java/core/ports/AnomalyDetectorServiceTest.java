package core.ports;

import core.AnomalyDetectorService;
import core.ports.out.ReadingRepository;
import domain.Reading;
import domain.ReadingFraudResult;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnomalyDetectorServiceTest {

    static class MockReadingRepository implements ReadingRepository {

        @Override
        public List<Reading> getReadings() {
            return List.of(
                    new Reading("client_1",100,"2025-1"),
                    new Reading("client_1",120, "2025-2"),
                    new Reading("client_1",95,"2025-3"),
                    new Reading("client_1",110,"2025-4"),
                    new Reading("client_1",80,"2025-5"),
                    new Reading("client_1",85,"2025-6"),
                    new Reading("client_1",130,"2025-7"),
                    new Reading("client_1",200,"2025-8"),
                    new Reading("client_1",120,"2025-9"),
                    new Reading("client_1",70,"2025-10"),
                    new Reading("client_1",80,"2025-11"),
                    new Reading("client_1",105,"2025-12")
            );
        }
    }

    @Test
    void detectFrauds() {

        double expectedMean = 102.5;

        ReadingRepository readingRepository = new MockReadingRepository();
        AnomalyDetectorService anomalyDetectorService = new AnomalyDetectorService(readingRepository);

        List<ReadingFraudResult> result = anomalyDetectorService.detectFrauds();

        assertEquals(1,result.size());

        ReadingFraudResult expectedResult = result.getFirst();
        assertEquals("client_1",expectedResult.getReading().getCustomerId());
        assertEquals(200,expectedResult.getReading().getValueKwh());
        assertEquals(8,expectedResult.getReading().getMonth().getDateValue().getMonthValue());
        assertEquals(2025,expectedResult.getReading().getMonth().getDateValue().getYear());

        assertEquals(expectedMean,expectedResult.getMedianKwh());

    }
}