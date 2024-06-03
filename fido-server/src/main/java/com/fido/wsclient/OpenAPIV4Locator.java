/**
 * OpenAPIV4Locator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fido.wsclient;

public class OpenAPIV4Locator extends org.apache.axis.client.Service implements com.fido.wsclient.OpenAPIV4 {

    public OpenAPIV4Locator() {
    }


    public OpenAPIV4Locator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public OpenAPIV4Locator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for OpenAPIV4Soap
    private java.lang.String OpenAPIV4Soap_address = "https://appapi.trackerking.net/OpenAPIV4.asmx";

    public java.lang.String getOpenAPIV4SoapAddress() {
        return OpenAPIV4Soap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String OpenAPIV4SoapWSDDServiceName = "OpenAPIV4Soap";

    public java.lang.String getOpenAPIV4SoapWSDDServiceName() {
        return OpenAPIV4SoapWSDDServiceName;
    }

    public void setOpenAPIV4SoapWSDDServiceName(java.lang.String name) {
        OpenAPIV4SoapWSDDServiceName = name;
    }

    public com.fido.wsclient.OpenAPIV4Soap getOpenAPIV4Soap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(OpenAPIV4Soap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getOpenAPIV4Soap(endpoint);
    }

    public com.fido.wsclient.OpenAPIV4Soap getOpenAPIV4Soap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.fido.wsclient.OpenAPIV4SoapStub _stub = new com.fido.wsclient.OpenAPIV4SoapStub(portAddress, this);
            _stub.setPortName(getOpenAPIV4SoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }	

    public void setOpenAPIV4SoapEndpointAddress(java.lang.String address) {
        OpenAPIV4Soap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.fido.wsclient.OpenAPIV4Soap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.fido.wsclient.OpenAPIV4SoapStub _stub = new com.fido.wsclient.OpenAPIV4SoapStub(new java.net.URL(OpenAPIV4Soap_address), this);
                _stub.setPortName(getOpenAPIV4SoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("OpenAPIV4Soap".equals(inputPortName)) {
            return getOpenAPIV4Soap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "OpenAPIV4");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "OpenAPIV4Soap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("OpenAPIV4Soap".equals(portName)) {
            setOpenAPIV4SoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
