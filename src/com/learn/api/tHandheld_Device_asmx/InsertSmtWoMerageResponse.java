
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
 *         &lt;element name="Insert_Smt_woMerageResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "insertSmtWoMerageResult"
})
@XmlRootElement(name = "Insert_Smt_woMerageResponse")
public class InsertSmtWoMerageResponse {

    @XmlElement(name = "Insert_Smt_woMerageResult")
    protected String insertSmtWoMerageResult;

    /**
     * ��ȡinsertSmtWoMerageResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsertSmtWoMerageResult() {
        return insertSmtWoMerageResult;
    }

    /**
     * ����insertSmtWoMerageResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsertSmtWoMerageResult(String value) {
        this.insertSmtWoMerageResult = value;
    }

}
