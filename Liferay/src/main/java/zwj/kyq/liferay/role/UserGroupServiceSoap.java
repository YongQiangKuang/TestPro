/**
 * UserGroupServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package zwj.kyq.liferay.role;

public interface UserGroupServiceSoap extends java.rmi.Remote {
    public void addGroupUserGroups(long groupId, long[] userGroupIds) throws java.rmi.RemoteException;
    public void addTeamUserGroups(long teamId, long[] userGroupIds) throws java.rmi.RemoteException;
    public zwj.kyq.liferay.role.UserGroupSoap addUserGroup(java.lang.String name, java.lang.String description) throws java.rmi.RemoteException;
    public zwj.kyq.liferay.role.UserGroupSoap addUserGroup(java.lang.String name, java.lang.String description, zwj.kyq.liferay.role.ServiceContext serviceContext) throws java.rmi.RemoteException;
    public void deleteUserGroup(long userGroupId) throws java.rmi.RemoteException;
    public zwj.kyq.liferay.role.UserGroupSoap fetchUserGroup(long userGroupId) throws java.rmi.RemoteException;
    public zwj.kyq.liferay.role.UserGroupSoap getUserGroup(long userGroupId) throws java.rmi.RemoteException;
    public zwj.kyq.liferay.role.UserGroupSoap getUserGroup(java.lang.String name) throws java.rmi.RemoteException;
    public zwj.kyq.liferay.role.UserGroupSoap[] getUserGroups(long companyId) throws java.rmi.RemoteException;
    public zwj.kyq.liferay.role.UserGroupSoap[] getUserUserGroups(long userId) throws java.rmi.RemoteException;
    public void unsetGroupUserGroups(long groupId, long[] userGroupIds) throws java.rmi.RemoteException;
    public void unsetTeamUserGroups(long teamId, long[] userGroupIds) throws java.rmi.RemoteException;
    public zwj.kyq.liferay.role.UserGroupSoap updateUserGroup(long userGroupId, java.lang.String name, java.lang.String description) throws java.rmi.RemoteException;
    public zwj.kyq.liferay.role.UserGroupSoap updateUserGroup(long userGroupId, java.lang.String name, java.lang.String description, zwj.kyq.liferay.role.ServiceContext serviceContext) throws java.rmi.RemoteException;
}
