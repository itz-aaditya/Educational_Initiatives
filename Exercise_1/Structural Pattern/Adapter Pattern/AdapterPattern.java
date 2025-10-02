// Target interface expected by the client
interface IReports {
    String getJsonData(String data);
}

// Adaptee: provides XML data from a raw input
class XmlDataProvider {
    // Expect data in "name:id" format (e.g. "Alice:42")
    String getXmlData(String data) {
        if (data == null || !data.contains(":")) {
            throw new IllegalArgumentException("Invalid raw data format. Expected 'name:id'");
        }

        int sep = data.indexOf(':');
        String name = data.substring(0, sep);
        String id   = data.substring(sep + 1);

        return "<user>"
                + "<name>" + name + "</name>"
                + "<id>"   + id   + "</id>"
                + "</user>";
    }
}

// Adapter: implements IReports by converting XML → JSON (manually)
class XmlDataProviderAdapter implements IReports {
    private XmlDataProvider xmlProvider;

    public XmlDataProviderAdapter(XmlDataProvider provider) {
        this.xmlProvider = provider;
    }

    public String getJsonData(String data) {
        String xml = xmlProvider.getXmlData(data);

        String name = extract(xml, "<name>", "</name>");
        String id   = extract(xml, "<id>", "</id>");

        return "{"
                + "\"name\":\"" + name + "\", "
                + "\"id\":" + id
                + "}";
    }

    // Utility method to extract text between tags
    private String extract(String xml, String startTag, String endTag) {
        int start = xml.indexOf(startTag);
        int end   = xml.indexOf(endTag);

        if (start == -1 || end == -1) {
            throw new IllegalArgumentException("Invalid XML: missing " + startTag + " or " + endTag);
        }

        return xml.substring(start + startTag.length(), end);
    }
}

// Client: works only with IReports
class Client {
    public void getReport(IReports report, String rawData) {
        System.out.println("Processed JSON: " + report.getJsonData(rawData));
    }
}

// Main Class
public class AdapterPattern {
    public static void main(String[] args) {
        XmlDataProvider xmlProv = new XmlDataProvider();
        IReports adapter = new XmlDataProviderAdapter(xmlProv);
        String rawData = "Alice:42";
        Client client = new Client();
        client.getReport(adapter, rawData);
    }
}