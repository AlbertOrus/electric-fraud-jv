package domain;

public class ReadingFraudResult {

    private final Reading reading;
    private final double averageKwh;

    public ReadingFraudResult(Reading reading,double averageKwh) {
        this.reading = reading;
        this.averageKwh = averageKwh;
    }

    public Reading getReading() {
        return reading;
    }

    public double getAverageKwh() {
        return averageKwh;
    }
}
