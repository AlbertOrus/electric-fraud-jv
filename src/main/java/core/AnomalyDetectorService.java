package core;

import core.ports.in.FraudDetection;
import core.ports.out.ReadingRepository;
import domain.Reading;
import domain.ReadingFraudResult;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnomalyDetectorService implements FraudDetection {

    private static final double SUSPICIOUS_MEDIAN_THRESHOLD = 0.5;

    private final ReadingRepository readingRepository;

    public AnomalyDetectorService(ReadingRepository readingRepository) {
        this.readingRepository = readingRepository;
    }

    @Override
    public List<ReadingFraudResult> detectFrauds() {

        List<Reading> readings = readingRepository.getReadings();
        Map<String,Integer> clientConsumeMedian = readings.stream()
                .collect(Collectors.groupingBy(
                        Reading::getCustomerId,
                        Collectors.collectingAndThen(
                                Collectors.mapping(Reading::getValueKwh, Collectors.toList()),
                                this::calculateMedian
                        )
                ));

        return readings.stream()
                .filter(reading -> isFraud(reading.getValueKwh(),clientConsumeMedian.get(reading.getCustomerId())))
                .map(reading -> new ReadingFraudResult(reading,clientConsumeMedian.get(reading.getCustomerId())))
                .toList();


    }

    private boolean isFraud(int readingValue, int median) {

        double superiorLimit = median*(1+SUSPICIOUS_MEDIAN_THRESHOLD);
        double inferiorLimit = median*(1-SUSPICIOUS_MEDIAN_THRESHOLD);

        return readingValue > superiorLimit || readingValue < inferiorLimit;

    }

    private int calculateMedian(List<Integer> values) {
        if(values.isEmpty())
            return 0;
        List<Integer> sortedValues = values.stream().sorted(Comparator.naturalOrder()).toList();
        int size = sortedValues.size();
        if (size % 2 == 1) {
            return sortedValues.get(size / 2);
        }
        return (sortedValues.get(size / 2 - 1) + sortedValues.get(size / 2)) / 2;

    }

}
