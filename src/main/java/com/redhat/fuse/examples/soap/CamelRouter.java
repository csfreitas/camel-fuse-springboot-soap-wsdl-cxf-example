package com.redhat.fuse.examples.soap;

import com.learnwebservices.services.hello.HelloRequest;
import com.learnwebservices.services.hello.HelloResponse;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * A simple Camel REST DSL route that implement the greetings service.
 * 
 */
@Component
public class CamelRouter extends RouteBuilder {

    @Value("${nameService.host}")
    String nameServiceHost;

    @Value("${nameService.port}")
    String nameServicePort;


    @Override
    public void configure() throws Exception {

        from("cxf:bean:helloEndpoint")
            .routeId("soap-hello-route")
            .process(new Processor() {

        @Override
        public void process(Exchange exchange) throws Exception {
            
            HelloResponse response =  new HelloResponse();
            response.setMessage("TESTE");
            exchange.getOut().setBody(response);
            
        }


    });
    	//from("cxf:/CustomerServicePort?serviceClass=" + CustomerService.class.getName())
       //.to("CustomerServiceProcessor");

    }

}