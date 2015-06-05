//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.02 at 11:54:56 AM EEST 
//


package org.fortune.schema._2_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * A poem
 * 
 * <p>Java class for poemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="poemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="title" type="{http://www.gribuser.ru/xml/fictionbook/2.0}titleType" minOccurs="0"/>
 *         &lt;element name="epigraph" type="{http://www.gribuser.ru/xml/fictionbook/2.0}epigraphType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="stanza" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="title" type="{http://www.gribuser.ru/xml/fictionbook/2.0}titleType" minOccurs="0"/>
 *                   &lt;element name="subtitle" type="{http://www.gribuser.ru/xml/fictionbook/2.0}pType" minOccurs="0"/>
 *                   &lt;element name="v" type="{http://www.gribuser.ru/xml/fictionbook/2.0}pType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *                 &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="text-author" type="{http://www.gribuser.ru/xml/fictionbook/2.0}textFieldType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="date" type="{http://www.gribuser.ru/xml/fictionbook/2.0}dateType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "poemType", propOrder = {
    "title",
    "epigraph",
    "stanza",
    "textAuthor",
    "date"
})
public class PoemType {

    protected TitleType title;
    protected List<EpigraphType> epigraph;
    @XmlElement(required = true)
    protected List<PoemType.Stanza> stanza;
    @XmlElement(name = "text-author")
    protected List<TextFieldType> textAuthor;
    protected DateType date;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String lang;

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link TitleType }
     *     
     */
    public TitleType getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link TitleType }
     *     
     */
    public void setTitle(TitleType value) {
        this.title = value;
    }

    /**
     * Gets the value of the epigraph property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the epigraph property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEpigraph().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EpigraphType }
     * 
     * 
     */
    public List<EpigraphType> getEpigraph() {
        if (epigraph == null) {
            epigraph = new ArrayList<EpigraphType>();
        }
        return this.epigraph;
    }

    /**
     * Gets the value of the stanza property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stanza property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStanza().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PoemType.Stanza }
     * 
     * 
     */
    public List<PoemType.Stanza> getStanza() {
        if (stanza == null) {
            stanza = new ArrayList<PoemType.Stanza>();
        }
        return this.stanza;
    }

    /**
     * Gets the value of the textAuthor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the textAuthor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTextAuthor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextFieldType }
     * 
     * 
     */
    public List<TextFieldType> getTextAuthor() {
        if (textAuthor == null) {
            textAuthor = new ArrayList<TextFieldType>();
        }
        return this.textAuthor;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDate(DateType value) {
        this.date = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="title" type="{http://www.gribuser.ru/xml/fictionbook/2.0}titleType" minOccurs="0"/>
     *         &lt;element name="subtitle" type="{http://www.gribuser.ru/xml/fictionbook/2.0}pType" minOccurs="0"/>
     *         &lt;element name="v" type="{http://www.gribuser.ru/xml/fictionbook/2.0}pType" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "title",
        "subtitle",
        "v"
    })
    public static class Stanza {

        protected TitleType title;
        protected PType subtitle;
        @XmlElement(required = true)
        protected List<PType> v;
        @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "language")
        protected String lang;

        /**
         * Gets the value of the title property.
         * 
         * @return
         *     possible object is
         *     {@link TitleType }
         *     
         */
        public TitleType getTitle() {
            return title;
        }

        /**
         * Sets the value of the title property.
         * 
         * @param value
         *     allowed object is
         *     {@link TitleType }
         *     
         */
        public void setTitle(TitleType value) {
            this.title = value;
        }

        /**
         * Gets the value of the subtitle property.
         * 
         * @return
         *     possible object is
         *     {@link PType }
         *     
         */
        public PType getSubtitle() {
            return subtitle;
        }

        /**
         * Sets the value of the subtitle property.
         * 
         * @param value
         *     allowed object is
         *     {@link PType }
         *     
         */
        public void setSubtitle(PType value) {
            this.subtitle = value;
        }

        /**
         * Gets the value of the v property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the v property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getV().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PType }
         * 
         * 
         */
        public List<PType> getV() {
            if (v == null) {
                v = new ArrayList<PType>();
            }
            return this.v;
        }

        /**
         * Gets the value of the lang property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLang() {
            return lang;
        }

        /**
         * Sets the value of the lang property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLang(String value) {
            this.lang = value;
        }

    }

}