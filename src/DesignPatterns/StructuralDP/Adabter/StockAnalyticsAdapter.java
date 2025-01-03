package DesignPatterns.StructuralDP.Adabter;

interface IXMLData {
    public void showData();

    public String getData();
}

class XMLData implements IXMLData {
    public String data;

    public XMLData(String data) {
        this.data = data;
    }

    @Override
    public String getData() {
        return data;
    }

    public void showData() {
        System.out.println(data);
    }
}

interface IJSONData {
    public void showData();

    public static String xmlTojson(IXMLData data) {
        return data.getData().replace("xml", "json");
    }
}

class JSONData implements IJSONData {
    String data;

    public JSONData(String data) {
        this.data = data;
    }

    @Override
    public void showData() {
        System.out.println(data);
    }
}

interface IStockDataProvider {
    void showData(IXMLData data);
}

class AnalyticsService {
    public String data;

    public AnalyticsService(String data) {
        this.data = data;
    }

    public void showData(IJSONData data) {
        data.showData();
    }
}

class StockService implements IStockDataProvider {
    @Override
    public void showData(IXMLData data) {
        data.showData();
    }
}

class AnalyticsServiceAdapter implements IStockDataProvider {
    public AnalyticsService adaptee;

    public AnalyticsServiceAdapter(AnalyticsService adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void showData(IXMLData data) {
        String jsonData = IJSONData.xmlTojson(data);
        adaptee.showData(new JSONData(jsonData));
    }
}

public class StockAnalyticsAdapter {
    public static void main(String[] args) {
        StockService stocService = new StockService();
        IXMLData xmlData = new XMLData("xml data");
        stocService.showData(xmlData);

        AnalyticsServiceAdapter adapter = new AnalyticsServiceAdapter(new AnalyticsService("json data"));
        adapter.showData(xmlData);
    }
}
