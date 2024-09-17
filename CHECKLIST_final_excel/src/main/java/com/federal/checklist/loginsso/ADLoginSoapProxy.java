package com.federal.checklist.loginsso;

public class ADLoginSoapProxy implements com.federal.checklist.loginsso.ADLoginSoap {
  private String _endpoint = null;
  private com.federal.checklist.loginsso.ADLoginSoap aDLoginSoap = null;
  
  public ADLoginSoapProxy() {
    _initADLoginSoapProxy();
  }
  
  public ADLoginSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initADLoginSoapProxy();
  }
  
  private void _initADLoginSoapProxy() {
    try {
      aDLoginSoap = (new com.federal.checklist.loginsso.ADLoginLocator()).getADLoginSoap();
      if (aDLoginSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)aDLoginSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)aDLoginSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (aDLoginSoap != null)
      ((javax.xml.rpc.Stub)aDLoginSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.federal.checklist.loginsso.ADLoginSoap getADLoginSoap() {
    if (aDLoginSoap == null)
      _initADLoginSoapProxy();
    return aDLoginSoap;
  }
  
  public com.federal.checklist.loginsso.UserAttributesResponseUserAttributesResult userAttributes(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (aDLoginSoap == null)
      _initADLoginSoapProxy();
    return aDLoginSoap.userAttributes(username, password);
  }
  
  
}