package core.ports.out;

import domain.Reading;

import java.util.List;

public interface ReadingRepository {

    List<Reading> getReadings();

}
