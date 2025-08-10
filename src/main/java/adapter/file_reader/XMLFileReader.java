package adapter.file_reader;

import core.ports.out.ReadingRepository;
import domain.Reading;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLFileReader implements ReadingRepository {

    private final String file_path;

    public XMLFileReader(String file_path) {
        this.file_path = file_path;
    }

    @Override
    public List<Reading> getReadings() {

        List<Reading> readings = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(file_path));
            //document.getDocumentElement().normalize();

            NodeList nodes = document.getElementsByTagName("readings");

            for(int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    readings.add(new Reading(
                            element.getAttribute("clientID"),
                            Integer.parseInt(element.getTextContent()),
                            element.getAttribute("period")
                    ));
                }

            }

        } catch (ParserConfigurationException | IOException | SAXException e) { //TODO Separar excepciones y usar excepciones genericas
            throw new RuntimeException(e);
        }

        return readings;
    }
}
