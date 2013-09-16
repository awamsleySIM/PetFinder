//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.09.13 at 02:56:27 PM EDT 
//


package com.systemsinmotion.petfinder.entities;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for animalType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="animalType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Dog"/>
 *     &lt;enumeration value="Cat"/>
 *     &lt;enumeration value="Small&amp;Furry"/>
 *     &lt;enumeration value="BarnYard"/>
 *     &lt;enumeration value="Bird"/>
 *     &lt;enumeration value="Horse"/>
 *     &lt;enumeration value="Pig"/>
 *     &lt;enumeration value="Rabbit"/>
 *     &lt;enumeration value="Reptile"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "animalType")
@XmlEnum
public enum AnimalType {

    @XmlEnumValue("Dog")
    DOG("Dog"),
    @XmlEnumValue("Cat")
    CAT("Cat"),
    @XmlEnumValue("Small&Furry")
    SMALL_FURRY("Small&Furry"),
    @XmlEnumValue("BarnYard")
    BARN_YARD("BarnYard"),
    @XmlEnumValue("Bird")
    BIRD("Bird"),
    @XmlEnumValue("Horse")
    HORSE("Horse"),
    @XmlEnumValue("Pig")
    PIG("Pig"),
    @XmlEnumValue("Rabbit")
    RABBIT("Rabbit"),
    @XmlEnumValue("Reptile")
    REPTILE("Reptile");
    private final String value;

    AnimalType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AnimalType fromValue(String v) {
        for (AnimalType c: AnimalType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
