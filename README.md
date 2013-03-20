Copyright (c) 2013 Jason Campos, Shaun Guth, Ash Islam

MIT License
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), 
to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS 
IN THE SOFTWARE.

PROJECTS
populous-client - Clients to the populous-ws project. Code here should remain GWT compatible.
populous-core - DAO, Constants, and utility classes.
populous-mashup - Web services mashups from the populous-ws project.
populous-server - Server core. Provides service interfaces for the various DAO classes and a means of persisting (hibernate) the entities to an RDBMS.
populous-simulator - Zombie infection simulator.
populous-ws - Web service interfaces to the populous-server project.

All projects are built using maven: mvn clean compile; 

CURRENT DEPLOYMENT
Web services are currently being hosted at
http://p.opulo.us:8080/populous-1.0/city
http://p.opulo.us:8080/populous-1.0/country
http://p.opulo.us:8080/populous-1.0/language
http://p.opulo.us:8080/populous-1.0/countrylanguage
http://p.opulo.us:8080/populous-1.0/infection
http://p.opulo.us:8080/mashup-1.0/mashup

* Services not guaranteed to be up 24/7

DEVELOPMENT NOTES

populous-mashup & populous-client projects
	- Run ./bin/wsimports.sh <wsdllocation> to generate the necessary java classes. 

populous-mashup & populous-ws 
	- Both projects contain a development endpoint for adding new web services and local testing. 
		mashup:  edu.sjsu.voidstar.mashup.client.MashupClient program.
		poulous: us.opulo.p.ws.endpoint.DevEndpoint
	- Alternatively, execute 'mvn compile package' and deploy the .war files to your desired application server.

populous-client
	- To test a mashup client, a mashup service must be running. To run a mashup, a populous-ws must be running. 
	- GWT application coming soon


