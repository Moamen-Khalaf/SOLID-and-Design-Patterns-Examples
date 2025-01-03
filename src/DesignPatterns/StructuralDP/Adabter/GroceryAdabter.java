package DesignPatterns.StructuralDP.Adabter;

// Existing system providing XML data
class XMLGroceryProvider {
    public String getGroceryListXML() {
        return "<groceryList><item>Apple</item><item>Banana</item><item>Carrot</item></groceryList>";
    }
}

// Target interface for clients expecting JSON
interface JSONGroceryClient {
    String getGroceryListJSON();
}

// Adapter to convert XML to JSON
class GroceryAdapter implements JSONGroceryClient {
    private XMLGroceryProvider xmlProvider;

    public GroceryAdapter(XMLGroceryProvider xmlProvider) {
        this.xmlProvider = xmlProvider;
    }

    @Override
    public String getGroceryListJSON() {
        String xml = xmlProvider.getGroceryListXML();
        return "{ \"groceryList\": [\"Apple\", \"Banana\", \"Carrot\"] }"; // Mock conversion
    }
}

// Client code
class GroceryClient {
    public static void main(String[] args) {
        // Existing XML provider
        XMLGroceryProvider xmlProvider = new XMLGroceryProvider();

        // Adapter to bridge XML and JSON
        JSONGroceryClient adapter = new GroceryAdapter(xmlProvider);

        // Fetch and print JSON data
        String groceryListJSON = adapter.getGroceryListJSON();
        System.out.println("Grocery List in JSON:");
        System.out.println(groceryListJSON);
    }
}
