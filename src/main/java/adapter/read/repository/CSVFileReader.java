package adapter.read.repository;

import adapter.exception.FileReadingException;
import adapter.exception.ParsingException;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import core.ports.out.ReadingRepository;
import domain.Reading;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVFileReader implements ReadingRepository {

    private final String file_path;

    public CSVFileReader(String file_path) {
        this.file_path = file_path;
    }

    @Override
    public List<Reading> getReadings() {
        try(CSVReader reader = new CSVReader(new FileReader(file_path))) {
            List<String[]> rows = reader.readAll();
            return rows
                    .stream()
                    .skip(1)
                    .map(read -> new Reading(
                            read[0],
                            Integer.parseInt(read[2]),
                            read[1]
                    )).toList();
        } catch (CsvException e) {
            throw new ParsingException(e.getMessage());
        } catch (IOException e) {
            throw new FileReadingException(e.getMessage());
        }

    }

}
