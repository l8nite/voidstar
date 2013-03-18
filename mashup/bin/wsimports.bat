
wsimport -verbose -s src/main/java/ -d target/ http://triton.idlemonkeys.net:8080/mashup-0.0.1-SNAPSHOT/city?wsdl
wsimport -verbose -s src/main/java/ -d target/ http://triton.idlemonkeys.net:8080/mashup-0.0.1-SNAPSHOT/country?wsdl
wsimport -verbose -s src/main/java/ -d target/ http://triton.idlemonkeys.net:8080/mashup-0.0.1-SNAPSHOT/countrylanguage?wsdl
wsimport -verbose -s src/main/java/ -d target/ http://triton.idlemonkeys.net:8080/mashup-0.0.1-SNAPSHOT/infection?wsdl
wsimport -verbose -s src/main/java/ -d target/ http://triton.idlemonkeys.net:8080/mashup-0.0.1-SNAPSHOT/language?wsdl
wsimport -verbose -extension -s src/main/java/ -d target/ http://www.webservicex.net/geoipservice.asmx?WSDL

