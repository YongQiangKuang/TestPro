/**
 * UserGroupRoleSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package zwj.kyq.liferay;

public class UserGroupRoleSoap  implements java.io.Serializable {
    private long companyId;

    private long groupId;

    private long mvccVersion;

    private zwj.kyq.liferay.UserGroupRolePK primaryKey;

    private long roleId;

    private long userId;

    public UserGroupRoleSoap() {
    }

    public UserGroupRoleSoap(
           long companyId,
           long groupId,
           long mvccVersion,
           zwj.kyq.liferay.UserGroupRolePK primaryKey,
           long roleId,
           long userId) {
           this.companyId = companyId;
           this.groupId = groupId;
           this.mvccVersion = mvccVersion;
           this.primaryKey = primaryKey;
           this.roleId = roleId;
           this.userId = userId;
    }


    /**
     * Gets the companyId value for this UserGroupRoleSoap.
     * 
     * @return companyId
     */
    public long getCompanyId() {
        return companyId;
    }


    /**
     * Sets the companyId value for this UserGroupRoleSoap.
     * 
     * @param companyId
     */
    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }


    /**
     * Gets the groupId value for this UserGroupRoleSoap.
     * 
     * @return groupId
     */
    public long getGroupId() {
        return groupId;
    }


    /**
     * Sets the groupId value for this UserGroupRoleSoap.
     * 
     * @param groupId
     */
    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }


    /**
     * Gets the mvccVersion value for this UserGroupRoleSoap.
     * 
     * @return mvccVersion
     */
    public long getMvccVersion() {
        return mvccVersion;
    }


    /**
     * Sets the mvccVersion value for this UserGroupRoleSoap.
     * 
     * @param mvccVersion
     */
    public void setMvccVersion(long mvccVersion) {
        this.mvccVersion = mvccVersion;
    }


    /**
     * Gets the primaryKey value for this UserGroupRoleSoap.
     * 
     * @return primaryKey
     */
    public zwj.kyq.liferay.UserGroupRolePK getPrimaryKey() {
        return primaryKey;
    }


    /**
     * Sets the primaryKey value for this UserGroupRoleSoap.
     * 
     * @param primaryKey
     */
    public void setPrimaryKey(zwj.kyq.liferay.UserGroupRolePK primaryKey) {
        this.primaryKey = primaryKey;
    }


    /**
     * Gets the roleId value for this UserGroupRoleSoap.
     * 
     * @return roleId
     */
    public long getRoleId() {
        return roleId;
    }


    /**
     * Sets the roleId value for this UserGroupRoleSoap.
     * 
     * @param roleId
     */
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }


    /**
     * Gets the userId value for this UserGroupRoleSoap.
     * 
     * @return userId
     */
    public long getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this UserGroupRoleSoap.
     * 
     * @param userId
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserGroupRoleSoap)) return false;
        UserGroupRoleSoap other = (UserGroupRoleSoap) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.companyId == other.getCompanyId() &&
            this.groupId == other.getGroupId() &&
            this.mvccVersion == other.getMvccVersion() &&
            ((this.primaryKey==null && other.getPrimaryKey()==null) || 
             (this.primaryKey!=null &&
              this.primaryKey.equals(other.getPrimaryKey()))) &&
            this.roleId == other.getRoleId() &&
            this.userId == other.getUserId();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += new Long(getCompanyId()).hashCode();
        _hashCode += new Long(getGroupId()).hashCode();
        _hashCode += new Long(getMvccVersion()).hashCode();
        if (getPrimaryKey() != null) {
            _hashCode += getPrimaryKey().hashCode();
        }
        _hashCode += new Long(getRoleId()).hashCode();
        _hashCode += new Long(getUserId()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserGroupRoleSoap.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://model.kernel.portal.liferay.com", "UserGroupRoleSoap"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("companyId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "companyId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mvccVersion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mvccVersion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("primaryKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "primaryKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://persistence.service.kernel.portal.liferay.com", "UserGroupRolePK"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roleId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "roleId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
