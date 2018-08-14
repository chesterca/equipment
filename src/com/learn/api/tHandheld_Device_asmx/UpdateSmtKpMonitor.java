
package com.learn.api.tHandheld_Device_asmx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="woId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OldMaterId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NewMasterId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Machine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "woId",
    "oldMaterId",
    "newMasterId",
    "machine"
})
@XmlRootElement(name = "Update_SmtKpMonitor")
public class UpdateSmtKpMonitor {

    protected String woId;
    @XmlElement(name = "OldMaterId")
    protected String oldMaterId;
    @XmlElement(name = "NewMasterId")
    protected String newMasterId;
    @XmlElement(name = "Machine")
    protected String machine;

    /**
     * ��ȡwoId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWoId() {
        return woId;
    }

    /**
     * ����woId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWoId(String value) {
        this.woId = value;
    }

    /**
     * ��ȡoldMaterId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldMaterId() {
        return oldMaterId;
    }

    /**
     * ����oldMaterId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldMaterId(String value) {
        this.oldMaterId = value;
    }

    /**
     * ��ȡnewMasterId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewMasterId() {
        return newMasterId;
    }

    /**
     * ����newMasterId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewMasterId(String value) {
        this.newMasterId = value;
    }

    /**
     * ��ȡmachine���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMachine() {
        return machine;
    }

    /**
     * ����machine���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMachine(String value) {
        this.machine = value;
    }

}
