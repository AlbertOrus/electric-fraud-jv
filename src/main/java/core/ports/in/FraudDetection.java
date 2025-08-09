package core.ports.in;

import domain.ReadingFraudResult;

import java.util.List;

public interface FraudDetection {

    List<ReadingFraudResult> detectFrauds();

}
