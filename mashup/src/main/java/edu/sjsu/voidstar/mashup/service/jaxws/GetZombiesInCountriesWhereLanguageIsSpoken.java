
package edu.sjsu.voidstar.mashup.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getZombiesInCountriesWhereLanguageIsSpoken", namespace = "http://ws.voidstar.sjsu.edu/mashup")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getZombiesInCountriesWhereLanguageIsSpoken", namespace = "http://ws.voidstar.sjsu.edu/mashup")
public class GetZombiesInCountriesWhereLanguageIsSpoken {

    @XmlElement(name = "languageName", namespace = "")
    private String languageName;

    /**
     * 
     * @return
     *     returns String
     */
    public String getLanguageName() {
        return this.languageName;
    }

    /**
     * 
     * @param languageName
     *     the value for the languageName property
     */
    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

}
