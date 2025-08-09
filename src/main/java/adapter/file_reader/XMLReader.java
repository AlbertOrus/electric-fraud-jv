package adapter.file_reader;

import core.ports.out.ReadingRepository;
import domain.Reading;

import java.util.List;

public class XMLReader implements ReadingRepository {

    private String file_path;

    public XMLReader(String file_path) {
        this.file_path = file_path;
    }

    @Override
    public List<Reading> getReadings() {
        //TODO Implemntar

        return List.of();
    }
}
