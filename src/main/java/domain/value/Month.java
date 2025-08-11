package domain.value;

import java.time.YearMonth;

public class Month {

    private final YearMonth dateValue;

    public Month(String monthStr) {

        String[] splitValues = monthStr.split("-");
        this.dateValue = YearMonth.of(Integer.parseInt(splitValues[0]),Integer.parseInt(splitValues[1]));
    }

    public YearMonth getDateValue() {
        return dateValue;
    }

    @Override
    public String toString() {
        return dateValue.toString();
    }
}
