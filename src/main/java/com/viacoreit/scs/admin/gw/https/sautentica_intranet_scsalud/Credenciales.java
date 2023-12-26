
package com.viacoreit.scs.admin.gw.https.sautentica_intranet_scsalud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para _Credenciales complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="_Credenciales">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LoginConexion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PassConexion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Aplicacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "_Credenciales", propOrder = {
    "loginConexion",
    "passConexion",
    "aplicacion"
})
public class Credenciales {

    @XmlElement(name = "LoginConexion", required = true)
    protected String loginConexion;
    @XmlElement(name = "PassConexion", required = true)
    protected String passConexion;
    @XmlElement(name = "Aplicacion", required = true)
    protected String aplicacion;

    /**
     * Obtiene el valor de la propiedad loginConexion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginConexion() {
        return loginConexion;
    }

    /**
     * Define el valor de la propiedad loginConexion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginConexion(String value) {
        this.loginConexion = value;
    }

    /**
     * Obtiene el valor de la propiedad passConexion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassConexion() {
        return passConexion;
    }

    /**
     * Define el valor de la propiedad passConexion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassConexion(String value) {
        this.passConexion = value;
    }

    /**
     * Obtiene el valor de la propiedad aplicacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAplicacion() {
        return aplicacion;
    }

    /**
     * Define el valor de la propiedad aplicacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAplicacion(String value) {
        this.aplicacion = value;
    }

}
