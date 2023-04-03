package com.redhat.fuse.examples.soap;

import java.util.HashMap;
import java.util.Map;

import com.learnwebservices.services.hello.HelloEndpoint;

import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.cxf.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CXFSoapEndpointConfiguration {

    @Autowired
    private Bus bus;

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public CxfEndpoint helloEndpoint() {
        CxfEndpoint cxfEndpoint = new CxfEndpoint();

        cxfEndpoint.setBeanId("helloEndpoint");
        cxfEndpoint.setWsdlURL("wsdl/hello.wsdl");
        cxfEndpoint.setAddress("/hello");
        cxfEndpoint.setServiceClass(HelloEndpoint.class);
        cxfEndpoint.setBus(bus);

        Map<String,Object> properties = new HashMap<>();
        properties.put("dataFormat", "POJO");
        cxfEndpoint.setProperties(properties);
        return cxfEndpoint;
    }

}
