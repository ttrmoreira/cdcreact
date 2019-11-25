package com.restbucks;

import java.io.IOException;

import javax.xml.namespace.QName;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.QNameMap;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class OrderingClient {
	
	private XStream xstream;
	
	public OrderingClient() {
		
		QNameMap qnameMap = new QNameMap();
		QName qname = new QName("http://restbucks.com/order", "o");
		qnameMap.registerMapping(qname, Order.class);
		xstream = new XStream(new StaxDriver(qnameMap));
		xstream.alias("order", Order.class);
		xstream.alias("item", Item.class);
	}
	
	public String placeOrder(Order order, String uri) throws HttpException, IOException {
		
        PostMethod post = new PostMethod(uri);
        RequestEntity entity = new ByteArrayRequestEntity(xstream.toXML(order).getBytes());
        post.setRequestEntity(entity);

		HttpClient client = new HttpClient();
		
        try {
            int response = client.executeMethod(post);
            
            if(response == 201) {
            	return post.getResponseHeader("Location").getValue();
            }
            
            throw new HttpException("Failed to create order. Status code: " + response);
            
        } finally {
            post.releaseConnection();
        }
	}
}
