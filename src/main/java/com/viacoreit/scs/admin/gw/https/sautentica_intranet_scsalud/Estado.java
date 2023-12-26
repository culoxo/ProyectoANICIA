
package com.viacoreit.scs.admin.gw.https.sautentica_intranet_scsalud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para _Estado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="_Estado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Acepta" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Motivo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "_Estado", propOrder = {
    "acepta",
    "motivo"
})
public class Estado {

    @XmlElement(name = "Acepta")
    protected int acepta;
    @XmlElement(name = "Motivo", required = true)
    protected String motivo;

    /**
     * Obtiene el valor de la propiedad acepta.
     * 
     */
    public int getAcepta() {
        return acepta;
    }

    /**
     * Define el valor de la propiedad acepta.
     * 
     */
    public void setAcepta(int value) {
        this.acepta = value;
    }

    /**
     * Obtiene el valor de la propiedad motivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Define el valor de la propiedad motivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivo(String value) {
        this.motivo = value;
    }

}
