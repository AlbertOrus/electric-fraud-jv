package domain;

public class ReadingFraudResult {

    private final Reading reading;
    private final int medianKwh;

    public ReadingFraudResult(Reading reading,int averageKwh) {
        this.reading = reading;
        this.medianKwh = averageKwh;
    }

    public Reading getReading() {
        return reading;
    }

    public int getMedianKwh() {
        return medianKwh;
    }
}
