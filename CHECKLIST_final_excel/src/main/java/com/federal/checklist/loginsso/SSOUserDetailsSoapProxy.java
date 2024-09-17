package com.federal.checklist.loginsso;

public class SSOUserDetailsSoapProxy implements com.federal.checklist.loginsso.SSOUserDetailsSoap {
  private String _endpoint = null;
  private com.federal.checklist.loginsso.SSOUserDetailsSoap sSOUserDetailsSoap = null;
  
  public SSOUserDetailsSoapProxy() {
    _initSSOUserDetailsSoapProxy();
  }
  
  public SSOUserDetailsSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initSSOUserDetailsSoapProxy();
  }
  
  private void _initSSOUserDetailsSoapProxy() {
    try {
      sSOUserDetailsSoap = (new com.federal.checklist.loginsso.SSOUserDetailsLocator()).getSSOUserDetailsSoap();
      if (sSOUserDetailsSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sSOUserDetailsSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sSOUserDetailsSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sSOUserDetailsSoap != null)
      ((javax.xml.rpc.Stub)sSOUserDetailsSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.federal.checklist.loginsso.SSOUserDetailsSoap getSSOUserDetailsSoap() {
    if (sSOUserDetailsSoap == null)
      _initSSOUserDetailsSoapProxy();
    return sSOUserDetailsSoap;
  }
  
  public com.federal.checklist.loginsso.UserDetails allDetails(java.lang.String username) throws java.rmi.RemoteException{
    if (sSOUserDetailsSoap == null)
      _initSSOUserDetailsSoapProxy();
    return sSOUserDetailsSoap.allDetails(username);
  }
  
  
}