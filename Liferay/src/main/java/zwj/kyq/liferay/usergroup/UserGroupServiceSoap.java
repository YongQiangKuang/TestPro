/**
 * UserGroupServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package zwj.kyq.liferay.usergroup;

public interface UserGroupServiceSoap extends java.rmi.Remote {
    public void addGroupUserGroups(long groupId, long[] userGroupIds) throws java.rmi.RemoteException;
    public void addTeamUserGroups(long teamId, long[] userGroupIds) throws java.rmi.RemoteException;
    public zwj.kyq.liferay.usergroup.UserGroupSoap addUserGroup(java.lang.String name, java.lang.String description) throws java.rmi.RemoteException;
    public zwj.kyq.liferay.usergroup.UserGroupSoap addUserGroup(java.lang.String name, java.lang.String description, zwj.kyq.liferay.usergroup.ServiceContext serviceContext) throws java.rmi.RemoteException;
    public void deleteUserGroup(long userGroupId) throws java.rmi.RemoteException;
    public zwj.kyq.liferay.usergroup.UserGroupSoap fetchUserGroup(long userGroupId) throws java.rmi.RemoteException;
    public zwj.kyq.liferay.usergroup.UserGroupSoap getUserGroup(long userGroupId) throws java.rmi.RemoteException;
    public zwj.kyq.liferay.usergroup.UserGroupSoap getUserGroup(java.lang.String name) throws java.rmi.RemoteException;
    public zwj.kyq.liferay.usergroup.UserGroupSoap[] getUserGroups(long companyId) throws java.rmi.RemoteException;
    public zwj.kyq.liferay.usergroup.UserGroupSoap[] getUserUserGroups(long userId) throws java.rmi.RemoteException;
    public void unsetGroupUserGroups(long groupId, long[] userGroupIds) throws java.rmi.RemoteException;
    public void unsetTeamUserGroups(long teamId, long[] userGroupIds) throws java.rmi.RemoteException;
    public zwj.kyq.liferay.usergroup.UserGroupSoap updateUserGroup(long userGroupId, java.lang.String name, java.lang.String description) throws java.rmi.RemoteException;
    public zwj.kyq.liferay.usergroup.UserGroupSoap updateUserGroup(long userGroupId, java.lang.String name, java.lang.String description, zwj.kyq.liferay.usergroup.ServiceContext serviceContext) throws java.rmi.RemoteException;
}
