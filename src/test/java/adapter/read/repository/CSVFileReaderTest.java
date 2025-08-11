package adapter.read.repository;

import domain.Reading;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVFileReaderTest {

    private static final String TEST_RESOURCE_FILENAME = "readings.csv";

    @Test
    void getReadings() throws URISyntaxException {

        URL resource = getClass().getClassLoader().getResource(TEST_RESOURCE_FILENAME);
        assertNotNull(resource, "Test resource not found: " + TEST_RESOURCE_FILENAME);
        String path = Paths.get(resource.toURI()).toString();

        CSVFileReader reader = new CSVFileReader(path);

        List<Reading> readings = reader.getReadings();
        assertEquals(120,readings.size());

        //583ef6329d7b9,2016-01,42451
        Reading firstRow = readings.getFirst();
        assertEquals("583ef6329d7b9",firstRow.getCustomerId());
        assertEquals(42451,firstRow.getValueKwh());
        assertEquals(1,firstRow.getMonth().getDateValue().getMonthValue());
        assertEquals(2016,firstRow.getMonth().getDateValue().getYear());

    }
}