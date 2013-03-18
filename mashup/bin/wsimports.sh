#!/bin/bash

EXPECTED_ARGS=1
 
if [[ $# -ne $EXPECTED_ARGS ]]
then
	echo "Usage " $( basename $0 ) " URL"
	echo "URL: Base URL for all WSDL files"
	echo "Example: http://localhost:8123"
	exit 1
fi

wsdls=( 'city' 'country' 'countrylanguage' 'infection' 'language' )

for wsdl in $wsdls
do
	 wsimport -verbose -s src/main/java/ -d target/ ${1}/${wsdl}?wsdl	
done

wsimport -verbose -extension -s src/main/java/ -d target/ http://www.webservicex.net/geoipservice.asmx?WSDL

