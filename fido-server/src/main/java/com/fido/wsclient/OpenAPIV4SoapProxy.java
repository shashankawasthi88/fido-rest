package com.fido.wsclient;

public class OpenAPIV4SoapProxy implements com.fido.wsclient.OpenAPIV4Soap {
  private String _endpoint = null;
  private com.fido.wsclient.OpenAPIV4Soap openAPIV4Soap = null;
  
  public OpenAPIV4SoapProxy() {
    _initOpenAPIV4SoapProxy();
  }
  
  public OpenAPIV4SoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initOpenAPIV4SoapProxy();
  }
  
  private void _initOpenAPIV4SoapProxy() {
    try {
      openAPIV4Soap = (new com.fido.wsclient.OpenAPIV4Locator()).getOpenAPIV4Soap();
      if (openAPIV4Soap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)openAPIV4Soap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)openAPIV4Soap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (openAPIV4Soap != null)
      ((javax.xml.rpc.Stub)openAPIV4Soap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.fido.wsclient.OpenAPIV4Soap getOpenAPIV4Soap() {
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap;
  }
  
  public java.lang.String login(java.lang.String name, java.lang.String pass, int loginType) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.login(name, pass, loginType);
  }
  
  public java.lang.String login2(java.lang.String name, java.lang.String pass, int loginType, java.lang.String appID, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.login2(name, pass, loginType, appID, language);
  }
  
  public java.lang.String loginWithToken(java.lang.String name, java.lang.String pass, int loginType, java.lang.String appID, java.lang.String language, java.lang.String token) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.loginWithToken(name, pass, loginType, appID, language, token);
  }
  
  public java.lang.String refreshToken(int loginID, int loginType, java.lang.String token) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.refreshToken(loginID, loginType, token);
  }
  
  public java.lang.String getGroupByUserID(int userID) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getGroupByUserID(userID);
  }
  
  public java.lang.String getIconList(int userID) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getIconList(userID);
  }
  
  public java.lang.String saveGroup(int groupID, int userID, java.lang.String groupName, java.lang.String description) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.saveGroup(groupID, userID, groupName, description);
  }
  
  public java.lang.String getCommandSetByDeviceID(int deviceID, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getCommandSetByDeviceID(deviceID, language);
  }
  
  public java.lang.String getDeviceList(int ID, int typeID, java.lang.String mapType, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getDeviceList(ID, typeID, mapType, language);
  }
  
  public java.lang.String getDeviceList_ForSearchDeviceName(int userID, java.lang.String name, java.lang.String mapType, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getDeviceList_ForSearchDeviceName(userID, name, mapType, language);
  }
  
  public java.lang.String getTracking(int deviceID, double timeZone, java.lang.String mapType, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getTracking(deviceID, timeZone, mapType, language);
  }
  
  public java.lang.String getSoundFilesList(int deviceID, double timeZone, int pageNo, int pageCount) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getSoundFilesList(deviceID, timeZone, pageNo, pageCount);
  }
  
  public java.lang.String setSoundFileRead(int deviceID, java.lang.String fileId, int operType, int isAll, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.setSoundFileRead(deviceID, fileId, operType, isAll, language);
  }
  
  public java.lang.String getNSList(int ID, int typeID) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getNSList(ID, typeID);
  }
  
  public java.lang.String getSubUserList(int userID) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getSubUserList(userID);
  }
  
  public java.lang.String saveNSList(int ID, int typeID, java.lang.String notificationTypeIDs, java.lang.String isActives) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.saveNSList(ID, typeID, notificationTypeIDs, isActives);
  }
  
  public java.lang.String getDevicesHistory(int deviceID, java.lang.String startTime, java.lang.String endTime, double timeZone, int showLBS, java.lang.String mapType, int selectCount, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getDevicesHistory(deviceID, startTime, endTime, timeZone, showLBS, mapType, selectCount, language);
  }
  
  public java.lang.String getWarnList(int ID, int pageNo, int pageCount, int typeID, double timeZone, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getWarnList(ID, pageNo, pageCount, typeID, timeZone, language);
  }
  
  public java.lang.String getAddressByLatlng(java.lang.String lat, java.lang.String lng, java.lang.String mapType, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getAddressByLatlng(lat, lng, mapType, language);
  }
  
  public java.lang.String getDeviceDetail(int deviceID) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getDeviceDetail(deviceID);
  }
  
  public java.lang.String updateDeviceDetail(int deviceID, java.lang.String deviceName, java.lang.String carNo, java.lang.String contact, java.lang.String contactPhone, java.lang.String SIM) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.updateDeviceDetail(deviceID, deviceName, carNo, contact, contactPhone, SIM);
  }
  
  public java.lang.String getAllZiXunInfo(int userID, int pageNo, int pageCount) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getAllZiXunInfo(userID, pageNo, pageCount);
  }
  
  public java.lang.String getZiXunInfoByPostID(java.lang.String id) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getZiXunInfoByPostID(id);
  }
  
  public java.lang.String getDeviceStatus(int deviceID) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getDeviceStatus(deviceID);
  }
  
  public java.lang.String fogetPassWord(java.lang.String username, java.lang.String email) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.fogetPassWord(username, email);
  }
  
  public java.lang.String onlineShopping(int userid) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.onlineShopping(userid);
  }
  
  public java.lang.String setVoiceSwitch(int userID, int voiceSwitch) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.setVoiceSwitch(userID, voiceSwitch);
  }
  
  public java.lang.String setGeoFence(int deviceID, int userID, int geoFenceID, java.math.BigDecimal lat, java.math.BigDecimal lon, java.lang.String geoFenceName, int radius, int entryExit, java.lang.String mapType, java.lang.String description) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.setGeoFence(deviceID, userID, geoFenceID, lat, lon, geoFenceName, radius, entryExit, mapType, description);
  }
  
  public java.lang.String getVoiceSwitch(int userID) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getVoiceSwitch(userID);
  }
  
  public java.lang.String deleteWarn(java.lang.String exceptionIDs, int userID) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.deleteWarn(exceptionIDs, userID);
  }
  
  public java.lang.String getZiDingZiXun(int userid) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getZiDingZiXun(userid);
  }
  
  public java.lang.String saveDevices(java.lang.String deviceName, java.lang.String image, java.lang.String fileName, java.lang.String SN, int userId, java.lang.String SIM, int style) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.saveDevices(deviceName, image, fileName, SN, userId, SIM, style);
  }
  
  public java.lang.String updateDeviceDetailMore(int deviceID, java.lang.String deviceName, java.lang.String carNo, java.lang.String contact, java.lang.String contactPhone, java.lang.String SIM, int groupID, int icon) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.updateDeviceDetailMore(deviceID, deviceName, carNo, contact, contactPhone, SIM, groupID, icon);
  }
  
  public java.lang.String updateDeviceDetailMore_ZK(int deviceID, java.lang.String deviceName, java.lang.String carNo, java.lang.String contact, java.lang.String contactPhone, java.lang.String SIM, int groupID, int icon, java.lang.String iconCode) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.updateDeviceDetailMore_ZK(deviceID, deviceName, carNo, contact, contactPhone, SIM, groupID, icon, iconCode);
  }
  
  public java.lang.String updateDeviceDetailMore_HX(int deviceID, java.lang.String deviceName, java.lang.String carNo, java.lang.String contact, java.lang.String contactPhone, java.lang.String SIM, int groupID, int icon, java.lang.String lessee, java.lang.String contractNumber) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.updateDeviceDetailMore_HX(deviceID, deviceName, carNo, contact, contactPhone, SIM, groupID, icon, lessee, contractNumber);
  }
  
  public java.lang.String getVersion(java.lang.String type, java.lang.String mapType) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getVersion(type, mapType);
  }
  
  public java.lang.String changePassword(int ID, int typeID, java.lang.String oldPass, java.lang.String newPass) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.changePassword(ID, typeID, oldPass, newPass);
  }
  
  public java.lang.String saveGeofence(int geofenceID, int userID, int deviceID, java.lang.String geofenceName, java.lang.String remark, java.math.BigDecimal lat, java.math.BigDecimal lng, java.math.BigDecimal radius, int fenceType, java.lang.String maptype) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.saveGeofence(geofenceID, userID, deviceID, geofenceName, remark, lat, lng, radius, fenceType, maptype);
  }
  
  public java.lang.String saveGeofence2(int geofenceID, int userID, int deviceID, java.lang.String geofenceName, java.lang.String remark, java.math.BigDecimal lat, java.math.BigDecimal lng, java.math.BigDecimal radius, int fenceType, java.lang.String maptype, boolean isLBS) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.saveGeofence2(geofenceID, userID, deviceID, geofenceName, remark, lat, lng, radius, fenceType, maptype, isLBS);
  }
  
  public java.lang.String delGeofence(int geofenceID, int deviceID) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.delGeofence(geofenceID, deviceID);
  }
  
  public java.lang.String getGeofence(int deviceID, java.lang.String mapType) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getGeofence(deviceID, mapType);
  }
  
  public java.lang.String userRegister(java.lang.String SN, java.lang.String userName, java.lang.String password, java.lang.String phone, java.lang.String deviceName, int icon) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.userRegister(SN, userName, password, phone, deviceName, icon);
  }
  
  public java.lang.String userRegister2(java.lang.String SN, java.lang.String userName, java.lang.String password, java.lang.String phone, java.lang.String email, java.lang.String deviceName, int icon, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.userRegister2(SN, userName, password, phone, email, deviceName, icon, language);
  }
  
  public java.lang.String userRegister_ZK(java.lang.String SN, java.lang.String userName, java.lang.String password, java.lang.String phone, java.lang.String deviceName, int icon, java.lang.String EMail) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.userRegister_ZK(SN, userName, password, phone, deviceName, icon, EMail);
  }
  
  public java.lang.String userRegister_ZK1(java.lang.String SN, java.lang.String userName, java.lang.String password, java.lang.String phone, java.lang.String deviceName, int icon, java.lang.String EMail, java.lang.String carNumber) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.userRegister_ZK1(SN, userName, password, phone, deviceName, icon, EMail, carNumber);
  }
  
  public java.lang.String addDevice(java.lang.String SN, java.lang.String deviceName, int icon, java.lang.String phone, int userID, int groupID) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.addDevice(SN, deviceName, icon, phone, userID, groupID);
  }
  
  public java.lang.String addDevice_ZK(java.lang.String SN, java.lang.String deviceName, int icon, java.lang.String phone, int userID, int groupID, java.lang.String carNumber) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.addDevice_ZK(SN, deviceName, icon, phone, userID, groupID, carNumber);
  }
  
  public java.lang.String sendCommandToDevices(int deviceID, java.lang.String cmdValue, java.lang.String cmdType) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.sendCommandToDevices(deviceID, cmdValue, cmdType);
  }
  
  public java.lang.String getResponse(int commandID) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getResponse(commandID);
  }
  
  public java.lang.String sendCommandToDevices_Thinkrace(int deviceID, java.lang.String deviceModel, java.lang.String cmdType, java.lang.String cmdValue) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.sendCommandToDevices_Thinkrace(deviceID, deviceModel, cmdType, cmdValue);
  }
  
  public java.lang.String getResponse_Thinkrace(int commandID) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getResponse_Thinkrace(commandID);
  }
  
  public java.lang.String getLastSendCommand_Thinkrace(int deviceID, java.lang.String cmdType) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getLastSendCommand_Thinkrace(deviceID, cmdType);
  }
  
  public java.lang.String getLastSendCommandValue(int deviceID, java.lang.String cmdType, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getLastSendCommandValue(deviceID, cmdType, language);
  }
  
  public java.lang.String sendConmmandToGateway_LD(int deviceID, java.lang.String deviceModel, java.lang.String cmdType, java.lang.String cmdValue) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.sendConmmandToGateway_LD(deviceID, deviceModel, cmdType, cmdValue);
  }
  
  public java.lang.String getDeviceStatus_LD(int deviceID) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getDeviceStatus_LD(deviceID);
  }
  
  public java.lang.String registered_LD(java.lang.String loginName, java.lang.String userPhone, java.lang.String password, java.lang.String IMEI, java.lang.String carModel, java.lang.String buyDate, java.lang.String frameNumber, java.lang.String insuranceCompany, java.lang.String insuranceNumber, java.lang.String insuranceStartTime, java.lang.String insuranceEndTime) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.registered_LD(loginName, userPhone, password, IMEI, carModel, buyDate, frameNumber, insuranceCompany, insuranceNumber, insuranceStartTime, insuranceEndTime);
  }
  
  public java.lang.String LDCancellationUser(java.lang.String IMEI, java.lang.String pass) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.LDCancellationUser(IMEI, pass);
  }
  
  public java.lang.String sendSmsCode(int appId, java.lang.String phone, int vildateSence, int regType, java.lang.String zone, java.lang.String templateCode, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.sendSmsCode(appId, phone, vildateSence, regType, zone, templateCode, language);
  }
  
  public java.lang.String registerForSmsCode(int appId, java.lang.String phone, int regType, java.lang.String pass, java.lang.String zone, java.lang.String smsCode, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.registerForSmsCode(appId, phone, regType, pass, zone, smsCode, language);
  }
  
  public java.lang.String loginForPhone(java.lang.String loginName, java.lang.String pass, java.lang.String appId, java.lang.String language, java.lang.String timeOffset) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.loginForPhone(loginName, pass, appId, language, timeOffset);
  }
  
  public java.lang.String findPassWordByPhone(java.lang.String loginName, java.lang.String phone, java.lang.String newPassWord, int appId, java.lang.String smsCode, java.lang.String zone, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.findPassWordByPhone(loginName, phone, newPassWord, appId, smsCode, zone, language);
  }
  
  public java.lang.String findPasswordByEmail(java.lang.String loginName, java.lang.String email, java.lang.String code, java.lang.String newPassWord, int appId, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.findPasswordByEmail(loginName, email, code, newPassWord, appId, language);
  }
  
  public java.lang.String bindingDevice(int userId, java.lang.String serialNumber) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.bindingDevice(userId, serialNumber);
  }
  
  public java.lang.String bindingDevices(java.lang.String SN, java.lang.String deviceName, int icon, java.lang.String phone, int userID, int groupID, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.bindingDevices(SN, deviceName, icon, phone, userID, groupID, language);
  }
  
  public java.lang.String transferToSuperior(int deviceID, int userId, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.transferToSuperior(deviceID, userId, language);
  }
  
  public java.lang.String getInsuranceInfo(int deviceID) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getInsuranceInfo(deviceID);
  }
  
  public java.lang.String getResponseText(int deviceID, java.lang.String cmdType) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getResponseText(deviceID, cmdType);
  }
  
  public java.lang.String getFaultCode_LD(int deviceID, int pageNo, int pageCount) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getFaultCode_LD(deviceID, pageNo, pageCount);
  }
  
  public java.lang.String login_LD(java.lang.String name, java.lang.String pass, int loginType) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.login_LD(name, pass, loginType);
  }
  
  public java.lang.String deleteFaultInfo(java.lang.String IDs) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.deleteFaultInfo(IDs);
  }
  
  public java.lang.String getUserTimeZoneUTC() throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getUserTimeZoneUTC();
  }
  
  public java.lang.String upDateUsersTimeZone(int userID, java.lang.String timeZone) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.upDateUsersTimeZone(userID, timeZone);
  }
  
  public java.lang.String sendConmmandToGateway_FLLC(int deviceID, java.lang.String deviceModel, java.lang.String cmdType, java.lang.String cmdValue) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.sendConmmandToGateway_FLLC(deviceID, deviceModel, cmdType, cmdValue);
  }
  
  public java.lang.String getWarnList_FLLC(int ID, int pageNo, int pageCount, int typeID, double timeZone, java.lang.String language, java.lang.String startTime, java.lang.String endTime) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getWarnList_FLLC(ID, pageNo, pageCount, typeID, timeZone, language, startTime, endTime);
  }
  
  public java.lang.String getDeviceStatus_FLLC(int deviceID) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getDeviceStatus_FLLC(deviceID);
  }
  
  public java.lang.String getHelpInfo_FLLC(int userID) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getHelpInfo_FLLC(userID);
  }
  
  public java.lang.String get4SInfo_FLLC(int deviceID) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.get4SInfo_FLLC(deviceID);
  }
  
  public java.lang.String getOneClickDetection(int deviceID) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getOneClickDetection(deviceID);
  }
  
  public java.lang.String getDevicesOfflineInfo(int userID, int pageNo, int pageCount, java.lang.String timeZones, int status, int offDay) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getDevicesOfflineInfo(userID, pageNo, pageCount, timeZones, status, offDay);
  }
  
  public java.lang.String getSumMileage(java.lang.String carNum, java.lang.String startTime, java.lang.String endTime) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getSumMileage(carNum, startTime, endTime);
  }
  
  public int getDeviceIdByImei(java.lang.String loginName, java.lang.String pwd, java.lang.String imei) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getDeviceIdByImei(loginName, pwd, imei);
  }
  
  public java.lang.String searchExceptionByUser(int ID, int pageNo, int pageCount, int typeID, double timeZone, java.lang.String language, int notificationType, java.lang.String searchName) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.searchExceptionByUser(ID, pageNo, pageCount, typeID, timeZone, language, notificationType, searchName);
  }
  
  public java.lang.String deleteExceptionByExceptionIds(java.lang.String exceptionIds, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.deleteExceptionByExceptionIds(exceptionIds, language);
  }
  
  public java.lang.String registerSubordinateUser(int userId, java.lang.String loginName, java.lang.String passWord, java.lang.String phone, java.lang.String email, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.registerSubordinateUser(userId, loginName, passWord, phone, email, language);
  }
  
  public java.lang.String getNotificationTypeInfo(int ID, int typeID, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getNotificationTypeInfo(ID, typeID, language);
  }
  
  public java.lang.String getUserInfo(int userID) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getUserInfo(userID);
  }
  
  public java.lang.String updateUserInfo(int userID, java.lang.String userName, java.lang.String contact, java.lang.String contactNumber, java.lang.String email, java.lang.String address) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.updateUserInfo(userID, userName, contact, contactNumber, email, address);
  }
  
  public java.lang.String moveDevice(int deviceID, int targetUserID) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.moveDevice(deviceID, targetUserID);
  }
  
  public java.lang.String findPassword(java.lang.String loginName, java.lang.String email, java.lang.String code, java.lang.String newPassWord, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.findPassword(loginName, email, code, newPassWord, language);
  }
  
  public java.lang.String sendCodeForEmail(java.lang.String loginName, java.lang.String email, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.sendCodeForEmail(loginName, email, language);
  }
  
  public java.lang.String saveDeviceParsLbs(int deviceID, boolean parsLbs, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.saveDeviceParsLbs(deviceID, parsLbs, language);
  }
  
  public java.lang.String shareFiles(int fileId, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.shareFiles(fileId, language);
  }
  
  public java.lang.String sendVoiceCommandToDevicesForCmd(int deviceID, java.lang.String deviceModel, java.lang.String cmdType, java.lang.String cmdValue, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.sendVoiceCommandToDevicesForCmd(deviceID, deviceModel, cmdType, cmdValue, language);
  }
  
  public java.lang.String getVoiceCommandStatus(int deviceID, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getVoiceCommandStatus(deviceID, language);
  }
  
  public java.lang.String getAlarmSettings(int deviceID, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getAlarmSettings(deviceID, language);
  }
  
  public java.lang.String setAlarmSetting(int deviceID, java.lang.String setting, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.setAlarmSetting(deviceID, setting, language);
  }
  
  public java.lang.String getMonthHistoryDetails(int deviceID, java.lang.String timeOffset, java.lang.String month, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getMonthHistoryDetails(deviceID, timeOffset, month, language);
  }
  
  public java.lang.String sendCommandToCmdPlatform(int deviceID, java.lang.String deviceModel, java.lang.String cmdType, java.lang.String cmdValue, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.sendCommandToCmdPlatform(deviceID, deviceModel, cmdType, cmdValue, language);
  }
  
  public java.lang.String getFilesMonthHistoryDetails(int deviceID, java.lang.String timeOffset, java.lang.String month, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getFilesMonthHistoryDetails(deviceID, timeOffset, month, language);
  }
  
  public java.lang.String getSoundFilesListByTimes(int deviceID, double timeZone, java.lang.String startTime, java.lang.String endTime, int pageNo, int pageCount, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getSoundFilesListByTimes(deviceID, timeZone, startTime, endTime, pageNo, pageCount, language);
  }
  
  public java.lang.String getPushProessSetting(int userId, int deviceId, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getPushProessSetting(userId, deviceId, language);
  }
  
  public java.lang.String savePushProessSetting(java.lang.String data, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.savePushProessSetting(data, language);
  }
  
  public java.lang.String savePushProessSettings(java.lang.String data, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.savePushProessSettings(data, language);
  }
  
  public java.lang.String savePushCellPhone(int userId, int deviceId, java.lang.String phone, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.savePushCellPhone(userId, deviceId, phone, language);
  }
  
  public java.lang.String savePushCellPhoneByCode(int userId, int deviceId, java.lang.String code, java.lang.String phone, java.lang.String cellPhone, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.savePushCellPhoneByCode(userId, deviceId, code, phone, cellPhone, language);
  }
  
  public java.lang.String getPpsCellPhoneDeviceList(int deviceId, java.lang.String phone, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getPpsCellPhoneDeviceList(deviceId, phone, language);
  }
  
  public java.lang.String getPpsCellPhone(int userId, int deviceId, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.getPpsCellPhone(userId, deviceId, language);
  }
  
  public java.lang.String appVersionUp(int appId, int clientType, java.lang.String language) throws java.rmi.RemoteException{
    if (openAPIV4Soap == null)
      _initOpenAPIV4SoapProxy();
    return openAPIV4Soap.appVersionUp(appId, clientType, language);
  }
  
  
}