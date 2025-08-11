package adapter.read.repository;

import adapter.exception.InvalidFileType;
import core.ports.out.ReadingRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReadingRepositoryFactoryTest {

    @Test
    void buildReaderFromPath() {

        String csvFile = "file.csv";
        String xmlFile = "file.xml";
        String invalidFile = "file.txt";

        ReadingRepository readingRepository = ReadingRepositoryFactory.buildReaderFromPath(csvFile);
        assertEquals(CSVFileReader.class,readingRepository.getClass());

        readingRepository = ReadingRepositoryFactory.buildReaderFromPath(xmlFile);
        assertEquals(XMLFileReader.class,readingRepository.getClass());

        assertThrows(InvalidFileType.class,() -> ReadingRepositoryFactory.buildReaderFromPath(invalidFile));

    }
}