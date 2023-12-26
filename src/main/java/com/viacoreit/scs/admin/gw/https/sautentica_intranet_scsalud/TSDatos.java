
package com.viacoreit.scs.admin.gw.https.sautentica_intranet_scsalud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DatosExtendido" type="{https://sautentica.intranet.scsalud.es/}_DatosExtendido"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "datosExtendido"
})
@XmlRootElement(name = "TSDatos")
public class TSDatos {

    @XmlElement(name = "DatosExtendido", required = true)
    protected DatosExtendido datosExtendido;

    /**
     * Obtiene el valor de la propiedad datosExtendido.
     * 
     * @return
     *     possible object is
     *     {@link DatosExtendido }
     *     
     */
    public DatosExtendido getDatosExtendido() {
        return datosExtendido;
    }

    /**
     * Define el valor de la propiedad datosExtendido.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosExtendido }
     *     
     */
    public void setDatosExtendido(DatosExtendido value) {
        this.datosExtendido = value;
    }

}
