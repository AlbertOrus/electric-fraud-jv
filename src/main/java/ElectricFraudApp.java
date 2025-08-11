import adapter.cli.CLIHandler;
import adapter.read.repository.ReadingRepositoryFactory;
import core.AnomalyDetectorService;
import core.ports.in.FraudDetection;
import core.ports.out.ReadingRepository;

public class ElectricFraudApp {

    public static void main(String[] args) {

        if(args.length != 1) {
            System.err.println("Error! Please enter a valid file path (csv or xml)!");
            System.exit(1);
        }


        String filePath = args[0];

        ReadingRepository readingRepository = ReadingRepositoryFactory.buildReaderFromPath(filePath);
        FraudDetection fraudDetection = new AnomalyDetectorService(readingRepository);
        CLIHandler cliHandler = new CLIHandler(fraudDetection);
        cliHandler.showFrauds();

    }

}
