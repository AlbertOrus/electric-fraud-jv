package domain.value;

import java.time.YearMonth;

public class Month {

    private final YearMonth month;

    public Month(String monthStr) {

        String[] splitValues = monthStr.split("-");
        this.month = YearMonth.of(Integer.parseInt(splitValues[0]),Integer.parseInt(splitValues[1]));
    }

    public YearMonth getMonth() {
        return month;
    }

}
