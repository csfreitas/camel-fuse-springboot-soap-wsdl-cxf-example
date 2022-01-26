
package com.learnwebservices.services.hello;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SayHello complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SayHello"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HelloRequest" type="{http://learnwebservices.com/services/hello}helloRequest"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SayHello", propOrder = {
    "helloRequest"
})
public class SayHello {

    @XmlElement(name = "HelloRequest", required = true)
    protected HelloRequest helloRequest;

    /**
     * Gets the value of the helloRequest property.
     * 
     * @return
     *     possible object is
     *     {@link HelloRequest }
     *     
     */
    public HelloRequest getHelloRequest() {
        return helloRequest;
    }

    /**
     * Sets the value of the helloRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link HelloRequest }
     *     
     */
    public void setHelloRequest(HelloRequest value) {
        this.helloRequest = value;
    }

}
