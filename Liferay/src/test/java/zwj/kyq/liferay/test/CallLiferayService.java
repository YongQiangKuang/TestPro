package zwj.kyq.liferay.test;


import zwj.kyq.liferay.ServiceContext;
import zwj.kyq.liferay.UserServiceSoap;
import zwj.kyq.liferay.UserServiceSoapServiceLocator;
import zwj.kyq.liferay.UserSoap;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * Description:
 * Copyright: © 2017 CSNT. All rights reserved.
 * Company:CSTC
 *
 * @version 1.0
 * @author: kyq1024
 * @timestamp: 2018-07-02 10:31
 */
public class CallLiferayService {
    private static final Long LIFERAY_USER_ACTION_IDS = 31L;//liferay初始完成后User的ActionID，可以在ResourcePermission表中去查找
    private static final Long LIFERAY_GROUP_ACTION_IDS = 33554431L;//liferay初始完成后Group的ActionID，可以在ResourcePermission表中去查找
    private static final Long LIFERAY_COMPANY_INSTANCE_ID_ = 20116L;//liferay初始化实例的公司ID，来自company表的companyId
    private static final Long LIFERAY_OWNER_ROLE_ID_ = 20124L;//liferay Role_表中name为Owner的数据的roleId。 resoucePermission中的roleId。

    private static final Long LIFERAY_ACCOUNT_ID_ = 20118L;//liferay 来自Account_表的accountId
    private static final Long LIFERAY_CLASS_NAME_ID_ = 20087L;//liferay中contact_数据的classNameId，来自ClassName_表value为“com.liferay.portal.kernel.model.User”数据的classNameId,
    private static final Long LIFERAY_LDAP_SERVER_ID_ = 30830L;//liferay中User_数据的ldapServerId，ldap配置界面。,


    public static void main(String args[]) {
//        new CallLiferayService().portalClient();
        new CallLiferayService().addUser();
    }

    private static URL getURL(String serviceName) {
//        String url = "http://localhost:8080"; //本机
//        String screenName = "admin";
//        String password = "admin";
//        int pos = url.indexOf("://");
//        String protocol = url.substring(0, pos + 3);
//        String host = url.substring(pos + 3, url.length());
//        StringBuilder sb = new StringBuilder();
//        sb.append(protocol);
//        sb.append(screenName);
//        sb.append(":");
//        sb.append(password);
//        sb.append("@");
//        sb.append(host);
//        sb.append("/api/secure/axis/");
//        sb.append(serviceName);
//        System.out.println(sb.toString());
        try {
//            return new URL(sb.toString());
            return new URL("http://test:test@127.0.0.1:8080/api/axis/Portal_UserService");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void portalClient(){
        UserServiceSoapServiceLocator locator = new UserServiceSoapServiceLocator();
        UserServiceSoap portalUserService = null;
        try {
            portalUserService = locator.getPortal_UserService(getURL("Portal_UserService"));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        try {
            //38911L
            UserSoap userSoap = portalUserService.getUserById(38911L);
            System.out.println("userContact:"+userSoap.getContactId()+"");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void addUser(){
        ServiceContext serviceContext = new ServiceContext();
        UserServiceSoapServiceLocator locatorUser = new UserServiceSoapServiceLocator();
        try {
            UserServiceSoap serviceUser = locatorUser.getPortal_UserService(getURL("Portal_UserService"));
            long[] userGroupIds = {31024L};
            Date start = new Date();
            for(int i=6;i<1000;i++){
                UserSoap userSoap = serviceUser.addUser(LIFERAY_COMPANY_INSTANCE_ID_,
                        true,"test"+i,"test"+i,
                        false,"test"+i,"test"+i+"@scgs.com",0,null,
                        "zh_CN","文思"+i,null, "李",0,0,true,1,1,1970,null,null,null,null,userGroupIds,false,serviceContext);
                serviceUser.updateStatus(userSoap.getUserId(), 0);
            }

            Date endDate = new Date();
            System.out.println("starTime:"+start);
            System.out.println("starTime:"+endDate);

//            serviceUser.updateStatus(41145, 0);
//            System.out.println(userSoap.getUserId());
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
