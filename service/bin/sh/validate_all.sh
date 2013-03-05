#!/bin/bash

for table in Cities CountryLanguages Languages Countries Infections; do
    xmllint --noout --schema src/main/resources/xsd/$table.xsd src/main/resources/xml/$table.xml
done;
