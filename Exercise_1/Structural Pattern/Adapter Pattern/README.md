Design Pattern: Adapter Pattern

Use Case: Allow a client that expects JSON data to work with a legacy XML data provider without changing the client code. The adapter converts XML data into JSON format on-the-fly.

Explanation of the Code:

Target Interface (IReports): Defines the method getJsonData(String data) that the client expects.

Adaptee (XmlDataProvider): Provides data in XML format but cannot be used directly by the client.

Adapter (XmlDataProviderAdapter): Implements the target interface (IReports) and internally uses XmlDataProvider to fetch XML data, then converts it to JSON.

Client: Works only with the IReports interface and is unaware of the XML provider.

Main Class: Demonstrates using the adapter to fetch XML data, convert it to JSON, and send it to the client.

Key Benefit: The Adapter Pattern allows incompatible interfaces to work together, enabling code reuse and minimal changes to existing client code.