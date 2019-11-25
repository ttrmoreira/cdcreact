import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class OrderingClient {

	public static void main(String[] args) {
		String[] ids = new String[3];
		ids[0] = "abcd";
		ids[1] = "efgh";
		ids[2] = "ijlk";
		
		try {
			System.out.println(new OrderingClient().placeOrder("1234", ids));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private static final String XML_HEADING = "<?xml version=\"1.0\"?>\n";
	private static final String NO_RESPONSE = "Error: No response.";

	public String placeOrder(String customerId, String[] itemIds) throws Exception {

		String ids = "";
		for(String id : itemIds) {
			ids += "<a:string>" + id + "</a:string>";
		}

		String request = "<Order xmlns=\"http://ordering.example.org/order\">" +
		"<customerId>" + customerId + "</customerId>" +
		"<itemIds " +
		"xmlns:a=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">" +
		ids +
		"</itemIds>" +
		"</Order>";

		String response = sendRequestPost(request, "http://localhost:7070/PlaceOrder");

		Document xmlResponse;
		xmlResponse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(response)));

		NodeList nodeList = xmlResponse.getElementsByTagName("orderId");

		if(nodeList.getLength() == 1)
		{
			return nodeList.item(0).getFirstChild().getNodeValue();
		}
		else
		{
			throw new Exception("Unexpected response from the service");
		}
	}

	// getPrice method removed for brevity

	private String sendRequestPost(String request, String uri)
	throws IOException, HttpException {
		PostMethod method = new PostMethod(uri);
		method.setRequestHeader("Content-type", "text/xml");
		method.setRequestBody(XML_HEADING + request);
		String responseBody = NO_RESPONSE;
		try {
			new HttpClient().executeMethod(method);
			responseBody = new String(method.getResponseBody(), "UTF-8");
		} finally {
			method.releaseConnection();
		}
		return responseBody;
	}
}
