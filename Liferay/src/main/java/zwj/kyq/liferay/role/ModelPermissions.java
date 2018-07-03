/**
 * ModelPermissions.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package zwj.kyq.liferay.role;

public class ModelPermissions  implements java.io.Serializable {
    private boolean empty;

    private java.lang.Object[] roleNames;

    public ModelPermissions() {
    }

    public ModelPermissions(
           boolean empty,
           java.lang.Object[] roleNames) {
           this.empty = empty;
           this.roleNames = roleNames;
    }


    /**
     * Gets the empty value for this ModelPermissions.
     * 
     * @return empty
     */
    public boolean isEmpty() {
        return empty;
    }


    /**
     * Sets the empty value for this ModelPermissions.
     * 
     * @param empty
     */
    public void setEmpty(boolean empty) {
        this.empty = empty;
    }


    /**
     * Gets the roleNames value for this ModelPermissions.
     * 
     * @return roleNames
     */
    public java.lang.Object[] getRoleNames() {
        return roleNames;
    }


    /**
     * Sets the roleNames value for this ModelPermissions.
     * 
     * @param roleNames
     */
    public void setRoleNames(java.lang.Object[] roleNames) {
        this.roleNames = roleNames;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ModelPermissions)) return false;
        ModelPermissions other = (ModelPermissions) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.empty == other.isEmpty() &&
            ((this.roleNames==null && other.getRoleNames()==null) || 
             (this.roleNames!=null &&
              java.util.Arrays.equals(this.roleNames, other.getRoleNames())));
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
        _hashCode += (isEmpty() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getRoleNames() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRoleNames());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRoleNames(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ModelPermissions.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://permission.service.kernel.portal.liferay.com", "ModelPermissions"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("empty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "empty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roleNames");
        elemField.setXmlName(new javax.xml.namespace.QName("", "roleNames"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setNillable(true);
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
