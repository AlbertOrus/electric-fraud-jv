package adapter.read.repository;

import adapter.exception.FileReadingException;
import adapter.exception.ParsingException;
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

            NodeList nodes = document.getElementsByTagName("reading");

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

        } catch (ParserConfigurationException | SAXException e) {
            throw new ParsingException(e.getMessage());
        } catch (IOException e) {
            throw new FileReadingException(e.getMessage());
        }

        return readings;
    }
}
