#!/bin/bash
for table in City Country CountryLanguage Infection Language; do
    echo "Dumping $table into $table.xml"
    mysqldump -ushaun -pnuahs se157bproject1 --xml $table | xsltproc mysql.xsl - > $table.xml
done;
