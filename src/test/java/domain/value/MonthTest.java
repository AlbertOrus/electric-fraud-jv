package domain.value;

import org.junit.jupiter.api.Test;

import java.time.DateTimeException;

import static org.junit.jupiter.api.Assertions.*;

class MonthTest {

    @Test
    void invalidMonth() {
        assertThrows(DateTimeException.class, () -> new Month("2025-13"));
    }

}