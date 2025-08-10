package domain;

import domain.value.Month;

public class Reading {

    private final String customerId;
    private final int valueKwh;
    private final Month month;

    public Reading(String customerId, int valueKwh, String monthStr) {
        this.customerId = customerId;
        this.valueKwh = valueKwh;
        this.month = new Month(monthStr);
    }


    public String getCustomerId() {
        return customerId;
    }

    public int getValueKwh() {
        return valueKwh;
    }

    public Month getMonth() {
        return month;
    }
}
