package domain;

import java.time.YearMonth;

public class Reading {

    private final String customerId;
    private final int valueKwh;
    private final YearMonth month;

    public Reading(String customerId, int valueKwh, YearMonth month) {
        this.customerId = customerId;
        this.valueKwh = valueKwh;
        this.month = month;
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getValueKwh() {
        return valueKwh;
    }

    public YearMonth getMonth() {
        return month;
    }
}
