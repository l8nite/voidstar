#!/bin/bash

EXPECTED_ARGS=1
 
if [[ $# -ne $EXPECTED_ARGS ]]
then
	echo "Usage " $( basename $0 ) " URL"
	echo "URL: Base URL for all WSDL files"
	echo "Example: http://localhost:8123"
	exit 1
fi

wsdls=( 'mashup' )

for wsdl in ${wsdls[@]}
do
	 wsimport -verbose -s src/main/java/ -d target/ ${1}/${wsdl}?wsdl	
done

