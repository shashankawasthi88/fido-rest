/**
 * OpenAPIV4Soap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fido.wsclient;

public interface OpenAPIV4Soap extends java.rmi.Remote {

    /**
     * 登录方法，LoginType=0为用户登录，1为设备IMEI登录,3表示由接口判读登陆类型，优先判断用户在判断设备
     */
    public java.lang.String login(java.lang.String name, java.lang.String pass, int loginType) throws java.rmi.RemoteException;

    /**
     * 登录方法，LoginType=0为用户登录，1为设备IMEI登录,3表示由接口判读登陆类型，优先判断用户在判断设备
     */
    public java.lang.String login2(java.lang.String name, java.lang.String pass, int loginType, java.lang.String appID, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 登录方法，LoginType=0为用户登录，1为设备IMEI登录,3表示由接口判读登陆类型，优先判断用户在判断设备
     */
    public java.lang.String loginWithToken(java.lang.String name, java.lang.String pass, int loginType, java.lang.String appID, java.lang.String language, java.lang.String token) throws java.rmi.RemoteException;

    /**
     * RefreshToken
     */
    public java.lang.String refreshToken(int loginID, int loginType, java.lang.String token) throws java.rmi.RemoteException;

    /**
     * 获取某个用户的分组
     */
    public java.lang.String getGroupByUserID(int userID) throws java.rmi.RemoteException;

    /**
     * 获取图标
     */
    public java.lang.String getIconList(int userID) throws java.rmi.RemoteException;

    /**
     * 新增或者保存分组
     */
    public java.lang.String saveGroup(int groupID, int userID, java.lang.String groupName, java.lang.String description) throws java.rmi.RemoteException;

    /**
     * 获取某个设备的指令集
     */
    public java.lang.String getCommandSetByDeviceID(int deviceID, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 获取设备列表
     */
    public java.lang.String getDeviceList(int ID, int typeID, java.lang.String mapType, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 获取设备列表
     */
    public java.lang.String getDeviceList_ForSearchDeviceName(int userID, java.lang.String name, java.lang.String mapType, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 实时监控
     */
    public java.lang.String getTracking(int deviceID, double timeZone, java.lang.String mapType, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 分页获取录音列表
     */
    public java.lang.String getSoundFilesList(int deviceID, double timeZone, int pageNo, int pageCount) throws java.rmi.RemoteException;

    /**
     * 标记文件已读,删除
     */
    public java.lang.String setSoundFileRead(int deviceID, java.lang.String fileId, int operType, int isAll, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 获取报警配置
     */
    public java.lang.String getNSList(int ID, int typeID) throws java.rmi.RemoteException;

    /**
     * 获取下级列表
     */
    public java.lang.String getSubUserList(int userID) throws java.rmi.RemoteException;

    /**
     * 保存报警配置
     */
    public java.lang.String saveNSList(int ID, int typeID, java.lang.String notificationTypeIDs, java.lang.String isActives) throws java.rmi.RemoteException;

    /**
     * 历史轨迹
     */
    public java.lang.String getDevicesHistory(int deviceID, java.lang.String startTime, java.lang.String endTime, double timeZone, int showLBS, java.lang.String mapType, int selectCount, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 报警列表，TypeID=0为用户，TypeID=1为设备
     */
    public java.lang.String getWarnList(int ID, int pageNo, int pageCount, int typeID, double timeZone, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 获取地址
     */
    public java.lang.String getAddressByLatlng(java.lang.String lat, java.lang.String lng, java.lang.String mapType, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 获取设备详情
     */
    public java.lang.String getDeviceDetail(int deviceID) throws java.rmi.RemoteException;

    /**
     * 更新设备详情
     */
    public java.lang.String updateDeviceDetail(int deviceID, java.lang.String deviceName, java.lang.String carNo, java.lang.String contact, java.lang.String contactPhone, java.lang.String SIM) throws java.rmi.RemoteException;

    /**
     * 获取全部资讯信息
     */
    public java.lang.String getAllZiXunInfo(int userID, int pageNo, int pageCount) throws java.rmi.RemoteException;

    /**
     * 获取资讯内容
     */
    public java.lang.String getZiXunInfoByPostID(java.lang.String id) throws java.rmi.RemoteException;

    /**
     * 获取设备状态
     */
    public java.lang.String getDeviceStatus(int deviceID) throws java.rmi.RemoteException;
    public java.lang.String fogetPassWord(java.lang.String username, java.lang.String email) throws java.rmi.RemoteException;
    public java.lang.String onlineShopping(int userid) throws java.rmi.RemoteException;

    /**
     * 消息通知开关；UserID:用户ID;VoiceSwitch:开-1,关-0
     */
    public java.lang.String setVoiceSwitch(int userID, int voiceSwitch) throws java.rmi.RemoteException;

    /**
     * 设置电子围栏;EntryExit:0表示进出都触发，1表示出触发，2表示进触发，3表示进出都不触发
     */
    public java.lang.String setGeoFence(int deviceID, int userID, int geoFenceID, java.math.BigDecimal lat, java.math.BigDecimal lon, java.lang.String geoFenceName, int radius, int entryExit, java.lang.String mapType, java.lang.String description) throws java.rmi.RemoteException;

    /**
     * 获取消息通知开关；UserID:用户ID;返回{"onoff":"1"}格式数据:开-1,关-0
     */
    public java.lang.String getVoiceSwitch(int userID) throws java.rmi.RemoteException;

    /**
     * ExceptionIDs:报警ID,多个以逗号隔开，例如 ‘1,3,4’;UserID:用户ID
     */
    public java.lang.String deleteWarn(java.lang.String exceptionIDs, int userID) throws java.rmi.RemoteException;
    public java.lang.String getZiDingZiXun(int userid) throws java.rmi.RemoteException;

    /**
     * 方法名：新增修改设备信息 deviceId：设备号  deviceName：设备名称 Image:图片内容  HeadImage：图片名
     * 回复0为成功 -1设备不存在 -2修改失败 -3新增失败 -4 图片上传失败
     */
    public java.lang.String saveDevices(java.lang.String deviceName, java.lang.String image, java.lang.String fileName, java.lang.String SN, int userId, java.lang.String SIM, int style) throws java.rmi.RemoteException;

    /**
     * 更新设备详情，包括分组和图标
     */
    public java.lang.String updateDeviceDetailMore(int deviceID, java.lang.String deviceName, java.lang.String carNo, java.lang.String contact, java.lang.String contactPhone, java.lang.String SIM, int groupID, int icon) throws java.rmi.RemoteException;

    /**
     * 更新设备详情，包括分组和图标
     */
    public java.lang.String updateDeviceDetailMore_ZK(int deviceID, java.lang.String deviceName, java.lang.String carNo, java.lang.String contact, java.lang.String contactPhone, java.lang.String SIM, int groupID, int icon, java.lang.String iconCode) throws java.rmi.RemoteException;

    /**
     * 更新设备详情，包括分组和图标
     */
    public java.lang.String updateDeviceDetailMore_HX(int deviceID, java.lang.String deviceName, java.lang.String carNo, java.lang.String contact, java.lang.String contactPhone, java.lang.String SIM, int groupID, int icon, java.lang.String lessee, java.lang.String contractNumber) throws java.rmi.RemoteException;
    public java.lang.String getVersion(java.lang.String type, java.lang.String mapType) throws java.rmi.RemoteException;

    /**
     * 修改密码，TypeID=0为修改用户密码，TypeID=1为修改设备密码
     */
    public java.lang.String changePassword(int ID, int typeID, java.lang.String oldPass, java.lang.String newPass) throws java.rmi.RemoteException;

    /**
     * 新增或者保存电子围栏
     */
    public java.lang.String saveGeofence(int geofenceID, int userID, int deviceID, java.lang.String geofenceName, java.lang.String remark, java.math.BigDecimal lat, java.math.BigDecimal lng, java.math.BigDecimal radius, int fenceType, java.lang.String maptype) throws java.rmi.RemoteException;

    /**
     * 新增或者保存电子围栏
     */
    public java.lang.String saveGeofence2(int geofenceID, int userID, int deviceID, java.lang.String geofenceName, java.lang.String remark, java.math.BigDecimal lat, java.math.BigDecimal lng, java.math.BigDecimal radius, int fenceType, java.lang.String maptype, boolean isLBS) throws java.rmi.RemoteException;

    /**
     * 删除围栏
     */
    public java.lang.String delGeofence(int geofenceID, int deviceID) throws java.rmi.RemoteException;

    /**
     * 获取围栏
     */
    public java.lang.String getGeofence(int deviceID, java.lang.String mapType) throws java.rmi.RemoteException;

    /**
     * 用户注册功能
     */
    public java.lang.String userRegister(java.lang.String SN, java.lang.String userName, java.lang.String password, java.lang.String phone, java.lang.String deviceName, int icon) throws java.rmi.RemoteException;

    /**
     * 用户注册功能
     */
    public java.lang.String userRegister2(java.lang.String SN, java.lang.String userName, java.lang.String password, java.lang.String phone, java.lang.String email, java.lang.String deviceName, int icon, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 中科用户注册功能
     */
    public java.lang.String userRegister_ZK(java.lang.String SN, java.lang.String userName, java.lang.String password, java.lang.String phone, java.lang.String deviceName, int icon, java.lang.String EMail) throws java.rmi.RemoteException;

    /**
     * 中科用户注册功能
     */
    public java.lang.String userRegister_ZK1(java.lang.String SN, java.lang.String userName, java.lang.String password, java.lang.String phone, java.lang.String deviceName, int icon, java.lang.String EMail, java.lang.String carNumber) throws java.rmi.RemoteException;

    /**
     * 新增设备
     */
    public java.lang.String addDevice(java.lang.String SN, java.lang.String deviceName, int icon, java.lang.String phone, int userID, int groupID) throws java.rmi.RemoteException;

    /**
     * 新增设备
     */
    public java.lang.String addDevice_ZK(java.lang.String SN, java.lang.String deviceName, int icon, java.lang.String phone, int userID, int groupID, java.lang.String carNumber) throws java.rmi.RemoteException;
    public java.lang.String sendCommandToDevices(int deviceID, java.lang.String cmdValue, java.lang.String cmdType) throws java.rmi.RemoteException;
    public java.lang.String getResponse(int commandID) throws java.rmi.RemoteException;
    public java.lang.String sendCommandToDevices_Thinkrace(int deviceID, java.lang.String deviceModel, java.lang.String cmdType, java.lang.String cmdValue) throws java.rmi.RemoteException;
    public java.lang.String getResponse_Thinkrace(int commandID) throws java.rmi.RemoteException;
    public java.lang.String getLastSendCommand_Thinkrace(int deviceID, java.lang.String cmdType) throws java.rmi.RemoteException;
    public java.lang.String getLastSendCommandValue(int deviceID, java.lang.String cmdType, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 雷丁电动车
     */
    public java.lang.String sendConmmandToGateway_LD(int deviceID, java.lang.String deviceModel, java.lang.String cmdType, java.lang.String cmdValue) throws java.rmi.RemoteException;

    /**
     * 雷丁电动车状态信息
     */
    public java.lang.String getDeviceStatus_LD(int deviceID) throws java.rmi.RemoteException;

    /**
     * 雷丁注册
     */
    public java.lang.String registered_LD(java.lang.String loginName, java.lang.String userPhone, java.lang.String password, java.lang.String IMEI, java.lang.String carModel, java.lang.String buyDate, java.lang.String frameNumber, java.lang.String insuranceCompany, java.lang.String insuranceNumber, java.lang.String insuranceStartTime, java.lang.String insuranceEndTime) throws java.rmi.RemoteException;

    /**
     * 雷丁注销用户，1001：注销成功,1002：注销失败。2：非终端用户不能注销。-1：IMEI号不存在,-2：密码错误。0：异常返回失败
     */
    public java.lang.String LDCancellationUser(java.lang.String IMEI, java.lang.String pass) throws java.rmi.RemoteException;

    /**
     * 获取验证码
     */
    public java.lang.String sendSmsCode(int appId, java.lang.String phone, int vildateSence, int regType, java.lang.String zone, java.lang.String templateCode, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 手机邮箱注册: RegType 1手机 2邮箱,
     */
    public java.lang.String registerForSmsCode(int appId, java.lang.String phone, int regType, java.lang.String pass, java.lang.String zone, java.lang.String smsCode, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 登录
     */
    public java.lang.String loginForPhone(java.lang.String loginName, java.lang.String pass, java.lang.String appId, java.lang.String language, java.lang.String timeOffset) throws java.rmi.RemoteException;

    /**
     * 手机找回密码
     */
    public java.lang.String findPassWordByPhone(java.lang.String loginName, java.lang.String phone, java.lang.String newPassWord, int appId, java.lang.String smsCode, java.lang.String zone, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 邮箱找回密码
     */
    public java.lang.String findPasswordByEmail(java.lang.String loginName, java.lang.String email, java.lang.String code, java.lang.String newPassWord, int appId, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 绑定设备
     */
    public java.lang.String bindingDevice(int userId, java.lang.String serialNumber) throws java.rmi.RemoteException;

    /**
     * 绑定设备 绑定第一个设备时 用户转移到设备代理商名下 绑定大于1个的设备时 需判断用户是否与设备的代理商一样
     */
    public java.lang.String bindingDevices(java.lang.String SN, java.lang.String deviceName, int icon, java.lang.String phone, int userID, int groupID, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 删除设备转移到用户上级代理商
     */
    public java.lang.String transferToSuperior(int deviceID, int userId, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 雷丁保险信息获取
     */
    public java.lang.String getInsuranceInfo(int deviceID) throws java.rmi.RemoteException;

    /**
     * 雷丁等待响应
     */
    public java.lang.String getResponseText(int deviceID, java.lang.String cmdType) throws java.rmi.RemoteException;

    /**
     * 雷丁获取故障码
     */
    public java.lang.String getFaultCode_LD(int deviceID, int pageNo, int pageCount) throws java.rmi.RemoteException;

    /**
     * 雷丁登录方法，LoginType=0为用户登录，1为设备IMEI登录,3表示由接口判读登陆类型，优先判断用户在判断设备
     */
    public java.lang.String login_LD(java.lang.String name, java.lang.String pass, int loginType) throws java.rmi.RemoteException;

    /**
     * 雷丁删除故障码信息
     */
    public java.lang.String deleteFaultInfo(java.lang.String IDs) throws java.rmi.RemoteException;
    public java.lang.String getUserTimeZoneUTC() throws java.rmi.RemoteException;
    public java.lang.String upDateUsersTimeZone(int userID, java.lang.String timeZone) throws java.rmi.RemoteException;

    /**
     * 富路丽驰下发
     */
    public java.lang.String sendConmmandToGateway_FLLC(int deviceID, java.lang.String deviceModel, java.lang.String cmdType, java.lang.String cmdValue) throws java.rmi.RemoteException;

    /**
     * 富路丽驰按时间报警列表，TypeID=0为用户，TypeID=1为设备
     */
    public java.lang.String getWarnList_FLLC(int ID, int pageNo, int pageCount, int typeID, double timeZone, java.lang.String language, java.lang.String startTime, java.lang.String endTime) throws java.rmi.RemoteException;

    /**
     * 富路丽驰
     */
    public java.lang.String getDeviceStatus_FLLC(int deviceID) throws java.rmi.RemoteException;

    /**
     * 富路丽驰救援
     */
    public java.lang.String getHelpInfo_FLLC(int userID) throws java.rmi.RemoteException;

    /**
     * 富路丽驰4S店
     */
    public java.lang.String get4SInfo_FLLC(int deviceID) throws java.rmi.RemoteException;

    /**
     * 一件检测
     */
    public java.lang.String getOneClickDetection(int deviceID) throws java.rmi.RemoteException;

    /**
     * 获取设备离线信息
     */
    public java.lang.String getDevicesOfflineInfo(int userID, int pageNo, int pageCount, java.lang.String timeZones, int status, int offDay) throws java.rmi.RemoteException;

    /**
     * 根据时间获取总里程
     */
    public java.lang.String getSumMileage(java.lang.String carNum, java.lang.String startTime, java.lang.String endTime) throws java.rmi.RemoteException;

    /**
     * 根据登录名密码，设备imei获取设备id
     */
    public int getDeviceIdByImei(java.lang.String loginName, java.lang.String pwd, java.lang.String imei) throws java.rmi.RemoteException;

    /**
     * 搜索筛选报警内容
     */
    public java.lang.String searchExceptionByUser(int ID, int pageNo, int pageCount, int typeID, double timeZone, java.lang.String language, int notificationType, java.lang.String searchName) throws java.rmi.RemoteException;

    /**
     * 删除报警信息
     */
    public java.lang.String deleteExceptionByExceptionIds(java.lang.String exceptionIds, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 创建下级用户
     */
    public java.lang.String registerSubordinateUser(int userId, java.lang.String loginName, java.lang.String passWord, java.lang.String phone, java.lang.String email, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 获取报警配置
     */
    public java.lang.String getNotificationTypeInfo(int ID, int typeID, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 获取用户信息
     */
    public java.lang.String getUserInfo(int userID) throws java.rmi.RemoteException;

    /**
     * 更新用户信息
     */
    public java.lang.String updateUserInfo(int userID, java.lang.String userName, java.lang.String contact, java.lang.String contactNumber, java.lang.String email, java.lang.String address) throws java.rmi.RemoteException;
    public java.lang.String moveDevice(int deviceID, int targetUserID) throws java.rmi.RemoteException;

    /**
     * 邮箱找回密码
     */
    public java.lang.String findPassword(java.lang.String loginName, java.lang.String email, java.lang.String code, java.lang.String newPassWord, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 发送验证码
     */
    public java.lang.String sendCodeForEmail(java.lang.String loginName, java.lang.String email, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 保存设备是否解析LBS数据
     */
    public java.lang.String saveDeviceParsLbs(int deviceID, boolean parsLbs, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 分享文件
     */
    public java.lang.String shareFiles(int fileId, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 录音指令下发 9015,9031,9032:防盗录音 9019:声控录音 9030:持续录音
     */
    public java.lang.String sendVoiceCommandToDevicesForCmd(int deviceID, java.lang.String deviceModel, java.lang.String cmdType, java.lang.String cmdValue, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 获取指令状态 9015,9031,9032:防盗录音 9019:声控录音 9030:持续录音
     */
    public java.lang.String getVoiceCommandStatus(int deviceID, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 获取报警设置(包含指令)
     */
    public java.lang.String getAlarmSettings(int deviceID, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 报警设置(包含指令)
     */
    public java.lang.String setAlarmSetting(int deviceID, java.lang.String setting, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 获取月历史数据详情
     */
    public java.lang.String getMonthHistoryDetails(int deviceID, java.lang.String timeOffset, java.lang.String month, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 向H5指令平台发送指令
     */
    public java.lang.String sendCommandToCmdPlatform(int deviceID, java.lang.String deviceModel, java.lang.String cmdType, java.lang.String cmdValue, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 按月份获取录音记录
     */
    public java.lang.String getFilesMonthHistoryDetails(int deviceID, java.lang.String timeOffset, java.lang.String month, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 分页获取录音列表
     */
    public java.lang.String getSoundFilesListByTimes(int deviceID, double timeZone, java.lang.String startTime, java.lang.String endTime, int pageNo, int pageCount, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 获取报警推送设置
     */
    public java.lang.String getPushProessSetting(int userId, int deviceId, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 保存用户报警推送设置
     */
    public java.lang.String savePushProessSetting(java.lang.String data, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 保存用户报警推送设置(多对象)
     */
    public java.lang.String savePushProessSettings(java.lang.String data, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 保存用户或者设备的联系号码
     */
    public java.lang.String savePushCellPhone(int userId, int deviceId, java.lang.String phone, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 验证Code保存用户或者设备的联系号码
     */
    public java.lang.String savePushCellPhoneByCode(int userId, int deviceId, java.lang.String code, java.lang.String phone, java.lang.String cellPhone, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 获取号码绑定的设备
     */
    public java.lang.String getPpsCellPhoneDeviceList(int deviceId, java.lang.String phone, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 获取设备或者用户的联系号码
     */
    public java.lang.String getPpsCellPhone(int userId, int deviceId, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * 版本更新
     */
    public java.lang.String appVersionUp(int appId, int clientType, java.lang.String language) throws java.rmi.RemoteException;
}
