package adapter.read.repository;

import adapter.exception.InvalidFileType;
import core.ports.out.ReadingRepository;

public class ReadingRepositoryFactory {

    public static ReadingRepository buildReaderFromPath(String filePath) {

        if(filePath.endsWith("csv"))
            return new CSVFileReader(filePath);
        else if(filePath.endsWith("xml"))
            return new XMLFileReader(filePath);

        throw new InvalidFileType("File type of: "+filePath+" not valid");
    }

}
