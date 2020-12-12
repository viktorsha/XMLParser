import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IParser {
    String getServiceName();
    List<Developers> getDevelopersInfo() throws IOException, SAXException, ParserConfigurationException;

}
