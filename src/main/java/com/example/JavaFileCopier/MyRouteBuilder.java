package com.example.JavaFileCopier;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:F:/data/transformUTransform/input?noop=true").transform(body().regexReplaceAll("\r\n", ",")).process(new Processor() {
			
			public void process(Exchange exchange) throws Exception {
				System.out.print("Input is "+exchange.getIn().getBody(String.class));
				
			}
		})
		.to("file:F:/data/transformUTransform/output?fileName=${header.CamelFileName}-out.csv");
	}
}
