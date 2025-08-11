package domain;

public class ReadingFraudResult {

    private final Reading reading;
    private final double medianKwh;

    public ReadingFraudResult(Reading reading,double medianKwh) {
        this.reading = reading;
        this.medianKwh = medianKwh;
    }

    public Reading getReading() {
        return reading;
    }

    public double getMedianKwh() {
        return medianKwh;
    }
}
