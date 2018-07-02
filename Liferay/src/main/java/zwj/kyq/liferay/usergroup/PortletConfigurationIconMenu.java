/**
 * PortletConfigurationIconMenu.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package zwj.kyq.liferay.usergroup;

public class PortletConfigurationIconMenu  implements java.io.Serializable {
    private java.lang.Object comparator;

    public PortletConfigurationIconMenu() {
    }

    public PortletConfigurationIconMenu(
           java.lang.Object comparator) {
           this.comparator = comparator;
    }


    /**
     * Gets the comparator value for this PortletConfigurationIconMenu.
     * 
     * @return comparator
     */
    public java.lang.Object getComparator() {
        return comparator;
    }


    /**
     * Sets the comparator value for this PortletConfigurationIconMenu.
     * 
     * @param comparator
     */
    public void setComparator(java.lang.Object comparator) {
        this.comparator = comparator;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PortletConfigurationIconMenu)) return false;
        PortletConfigurationIconMenu other = (PortletConfigurationIconMenu) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.comparator==null && other.getComparator()==null) || 
             (this.comparator!=null &&
              this.comparator.equals(other.getComparator())));
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
        if (getComparator() != null) {
            _hashCode += getComparator().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PortletConfigurationIconMenu.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://icon.configuration.portlet.kernel.portal.liferay.com", "PortletConfigurationIconMenu"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comparator");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comparator"));
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
