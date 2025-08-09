package core.ports;

import core.ports.in.FraudDetection;
import core.ports.out.ReadingRepository;
import domain.Reading;
import domain.ReadingFraudResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnomalyDetectorService implements FraudDetection {

    private final ReadingRepository readingRepository;

    public AnomalyDetectorService(ReadingRepository readingRepository) {
        this.readingRepository = readingRepository;
    }

    @Override
    public List<ReadingFraudResult> detectFrauds() {

        List<Reading> readings = readingRepository.getReadings();
        Map<String,Integer> clientConsumeMedian =  readings.stream()
                .collect(Collectors
                        .groupingBy(Reading::getCustomerId, Collectors.averagingDouble(Reading::getValueKwh)));

        List<ReadingFraudResult> detectedFrauds = ;

        return detectedFrauds;
    }

    private int calculateMedian(List<Integer> values) {



    }

}
