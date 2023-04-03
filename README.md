# **SOAP Web Service using Red Hat Fuse in Spring Boot**


Example using camel with red hat fuse package, springboot, apache cxf to expose a simple server based on WSDL.

## Configuration 

The project are using de CXF camel component and exposing a simple SOAP Webservice, using a **wsdl** file that is packaged inside the resource folder. 

To respect the contract defined by the wsdl we are using the plugin **cxf-codegen-plugin** that will generate the sources necessary to our example implementation.

To generate the sources you can run:

``` shell
mvn clean package
```

The example is just a simple hello world SOAP Web Service tha you can send a name and the web service is gonna respond with a hello message.

SOAP XML Request:

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Header/>
   <soapenv:Body>
       <HelloRequest xmlns="http://learnwebservices.com/services/hello">
          <Name>Cássio Augusto</Name>
       </HelloRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

SOAP XML Response:

```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
    <soap:Body>
        <HelloResponse xmlns="http://learnwebservices.com/services/hello">
            <Message>Hello my friend: Cássio Augusto</Message>
        </HelloResponse>
    </soap:Body>
</soap:Envelope>
```

To configure de CXF endpoint we have to produced a Bean Configuration using a method and the @Bean annotation:

```java
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
```

Using the Bean Id we now can reference it in our Camel Route Configuration and do what we need using a processor:

```java
@Component
public class CamelRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("cxf:bean:helloEndpoint")
            .routeId("soap-hello-route")
            .process(new Processor() {
                @Override
                public void process(Exchange exchange) throws Exception {

                    HelloRequest objectReceived = exchange.getMessage().getBody(HelloRequest.class);
                    
                    HelloResponse response =  new HelloResponse();
                    response.setMessage("Hello my friend: " + objectReceived.getName());
                    
                    exchange.getOut().setBody(response);
                    
                }
            });
    }

}
```

So using the camel CXF component, we managed to expose a SOAP service based on a wsdl contract.

## Test

To test the example:

```shell
curl --location 'http://localhost:8080/services/hello' \
--header 'Content-Type: application/xml' \
--data '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Header/>
   <soapenv:Body>
       <HelloRequest xmlns="http://learnwebservices.com/services/hello">
          <Name>Cássio Augusto</Name>
       </HelloRequest>
   </soapenv:Body>
</soapenv:Envelope>'
```

To run locally:
```shell
mvn spring-boot:run  
```


Thanks for [learnwebservices](https://github.com/vicziani/learnwebservices) for providing the example WSDL.