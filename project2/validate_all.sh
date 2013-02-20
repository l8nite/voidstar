#!/bin/bash
for table in City Country CountryLanguage Infection Language; do
    xmllint --noout --schema $table.xsd $table.xml
done;
