
package com.viacoreit.scs.admin.gw.https.sautentica_intranet_scsalud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para _DatosExtendido complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="_DatosExtendido">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Trabaja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CPuesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CUnidad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DPuesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DUnidad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "_DatosExtendido", propOrder = {
    "trabaja",
    "cPuesto",
    "cUnidad",
    "dPuesto",
    "dUnidad"
})
public class DatosExtendido {

    @XmlElement(name = "Trabaja", required = true)
    protected String trabaja;
    @XmlElement(name = "CPuesto", required = true)
    protected String cPuesto;
    @XmlElement(name = "CUnidad", required = true)
    protected String cUnidad;
    @XmlElement(name = "DPuesto", required = true)
    protected String dPuesto;
    @XmlElement(name = "DUnidad", required = true)
    protected String dUnidad;

    /**
     * Obtiene el valor de la propiedad trabaja.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrabaja() {
        return trabaja;
    }

    /**
     * Define el valor de la propiedad trabaja.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrabaja(String value) {
        this.trabaja = value;
    }

    /**
     * Obtiene el valor de la propiedad cPuesto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPuesto() {
        return cPuesto;
    }

    /**
     * Define el valor de la propiedad cPuesto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPuesto(String value) {
        this.cPuesto = value;
    }

    /**
     * Obtiene el valor de la propiedad cUnidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUnidad() {
        return cUnidad;
    }

    /**
     * Define el valor de la propiedad cUnidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUnidad(String value) {
        this.cUnidad = value;
    }

    /**
     * Obtiene el valor de la propiedad dPuesto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDPuesto() {
        return dPuesto;
    }

    /**
     * Define el valor de la propiedad dPuesto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDPuesto(String value) {
        this.dPuesto = value;
    }

    /**
     * Obtiene el valor de la propiedad dUnidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDUnidad() {
        return dUnidad;
    }

    /**
     * Define el valor de la propiedad dUnidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDUnidad(String value) {
        this.dUnidad = value;
    }

}
