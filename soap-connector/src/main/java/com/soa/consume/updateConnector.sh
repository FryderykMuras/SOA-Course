#!/bin/bash

rm -rf ../connector
mkdir ../connector
/Users/fryderykmuras/servers/wildfly-16.0.0.Final/bin/wsconsume.sh -n -k -s /Users/fryderykmuras/Projekt1/soap-connector/src/main/java -p com.soa.connector http://localhost:8080/Projekt1-ejb/Service?wsdl
rm -rf output