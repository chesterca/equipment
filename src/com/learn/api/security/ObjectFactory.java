
package com.learn.api.security;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.learn.api.security package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AuthCheck_QNAME = new QName("http://controller.web.phicomm.com/", "authCheck");
    private final static QName _AuthCheckResponse_QNAME = new QName("http://controller.web.phicomm.com/", "authCheckResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.learn.api.security
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AuthCheck }
     * 
     */
    public AuthCheck createAuthCheck() {
        return new AuthCheck();
    }

    /**
     * Create an instance of {@link AuthCheckResponse }
     * 
     */
    public AuthCheckResponse createAuthCheckResponse() {
        return new AuthCheckResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthCheck }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.web.phicomm.com/", name = "authCheck")
    public JAXBElement<AuthCheck> createAuthCheck(AuthCheck value) {
        return new JAXBElement<AuthCheck>(_AuthCheck_QNAME, AuthCheck.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthCheckResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.web.phicomm.com/", name = "authCheckResponse")
    public JAXBElement<AuthCheckResponse> createAuthCheckResponse(AuthCheckResponse value) {
        return new JAXBElement<AuthCheckResponse>(_AuthCheckResponse_QNAME, AuthCheckResponse.class, null, value);
    }

}
