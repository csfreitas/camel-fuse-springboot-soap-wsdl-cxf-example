package com.learnwebservices.services.hello;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.5.0
 * 2022-01-26T20:11:27.749-03:00
 * Generated source version: 3.5.0
 *
 */
@WebServiceClient(name = "HelloEndpointService",
                  wsdlLocation = "file:/Users/csfreitas/redhat/MPRJ/examples/camel-soap/src/main/resources/wsdl/hello.wsdl",
                  targetNamespace = "http://learnwebservices.com/services/hello")
public class HelloEndpointService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://learnwebservices.com/services/hello", "HelloEndpointService");
    public final static QName HelloEndpointPort = new QName("http://learnwebservices.com/services/hello", "HelloEndpointPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/Users/csfreitas/redhat/MPRJ/examples/camel-soap/src/main/resources/wsdl/hello.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(HelloEndpointService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/Users/csfreitas/redhat/MPRJ/examples/camel-soap/src/main/resources/wsdl/hello.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public HelloEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public HelloEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloEndpointService() {
        super(WSDL_LOCATION, SERVICE);
    }





    /**
     *
     * @return
     *     returns HelloEndpoint
     */
    @WebEndpoint(name = "HelloEndpointPort")
    public HelloEndpoint getHelloEndpointPort() {
        return super.getPort(HelloEndpointPort, HelloEndpoint.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HelloEndpoint
     */
    @WebEndpoint(name = "HelloEndpointPort")
    public HelloEndpoint getHelloEndpointPort(WebServiceFeature... features) {
        return super.getPort(HelloEndpointPort, HelloEndpoint.class, features);
    }

}
