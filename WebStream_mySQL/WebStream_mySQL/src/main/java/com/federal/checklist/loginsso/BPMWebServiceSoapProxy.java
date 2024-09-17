package com.federal.checklist.loginsso;

public class BPMWebServiceSoapProxy implements com.federal.checklist.loginsso.BPMWebServiceSoap {
  private String _endpoint = null;
  private com.federal.checklist.loginsso.BPMWebServiceSoap bPMWebServiceSoap = null;
  
  public BPMWebServiceSoapProxy() {
    _initBPMWebServiceSoapProxy();
  }
  
  public BPMWebServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initBPMWebServiceSoapProxy();
  }
  
  private void _initBPMWebServiceSoapProxy() {
    try {
      bPMWebServiceSoap = (new com.federal.checklist.loginsso.BPMWebServiceLocator()).getBPMWebServiceSoap();
      if (bPMWebServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bPMWebServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bPMWebServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bPMWebServiceSoap != null)
      ((javax.xml.rpc.Stub)bPMWebServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.federal.checklist.loginsso.BPMWebServiceSoap getBPMWebServiceSoap() {
    if (bPMWebServiceSoap == null)
      _initBPMWebServiceSoapProxy();
    return bPMWebServiceSoap;
  }
  
  public com.federal.checklist.loginsso.BPMData getUserDetails(java.lang.String username) throws java.rmi.RemoteException{
    if (bPMWebServiceSoap == null)
      _initBPMWebServiceSoapProxy();
    return bPMWebServiceSoap.getUserDetails(username);
  }
  
  
}