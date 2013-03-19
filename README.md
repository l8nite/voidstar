SE157B - Project 3 - Team void* - Ash Islam, Jason Campos, Shaun Guth

There are 3 components in this project:

service - "core" SOAP services supporting queries against City, Country, Language, Infection, and CountryLanguage data
mashup - a SOAP service itself, which acts as a client of the "core" services (plus a GeoIP service)
client - a couple of test drivers which act as SOAP clients for the other two

All projects are built using maven: mvn clean compile; however, you will also need to run the bin/wsimports scripts to generate the SOAP client code for the 'mashup' and 'client' directories.

The "service" code is deployed remotely @:
http://p.opulo.us:8080/populous-1.0/city
http://p.opulo.us:8080/populous-1.0/country
http://p.opulo.us:8080/populous-1.0/language
http://p.opulo.us:8080/populous-1.0/countrylanguage
http://p.opulo.us:8080/populous-1.0/infection

Same goes for the "mashup" code @:
http://p.opulo.us:8080/mashup-1.0/mashup

To run the client code for the mashup service, execute the edu.sjsu.voidstar.mashup.client.MashupClient program.

To run the client code for the core service (simple test), execute the edu.sjsu.voidstar.service.client.ServiceClient program.

Alternatively, If you'd like to run the service and mashup SOAP services yourself, you will need to either "mvn compile package" and deploy the .war file from the target/ directory of each -OR- use the Endpoint.publish() driver classes we have provided:

For the service, that is us.opulo.p.project3.PublishServices class 

For the mashup, that is edu.sjsu.voidstar.mashup.publish.PublishMashupService

Also, before compiling the mashup, you will need to re-generate SOAP client code so that they point at your locally running copy of the service. There are scripts in the 'bin' folder for the mashup that you can execute to do this.