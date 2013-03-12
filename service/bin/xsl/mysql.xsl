<?xml version="1.0" encoding="ISO-8859-1"?>
<!--

                                  .__
    ______      ____ ______  __ __|  |   ____      __ __  ______
    \____ \    /  _ \\____ \|  |  \  |  /  _ \    |  |  \/  ___/
    |  |_> >  (  <_> )  |_> >  |  /  |_(  <_> )   |  |  /\___ \
    |   __/ /\ \____/|   __/|____/|____/\____/ /\ |____//____  >
    |__|    \/       |__|                      \/            \/


    Copyright (c) 2013 Jason Campos <jcampos8782@gmail.com>, Shaun Guth, Ash Islam
    All Rights Reserved.

    This software is licensed under The MIT License (MIT)
    http://opensource.org/licenses/MIT

-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="xml" version="1.0" indent="yes"/>

    <xsl:template match="@* | node()">
        <xsl:apply-templates select="@* | node()"/>
    </xsl:template>

    <xsl:template match="/mysqldump/database/table_data">
        <xsl:element name="{@name}s">
            <xsl:for-each select="row">
                <xsl:element name="{../@name}">
                    <xsl:for-each select="field">
                        <xsl:element name="{@name}">
                            <xsl:value-of select="."/>
                        </xsl:element>
                    </xsl:for-each>
                </xsl:element>
            </xsl:for-each>
        </xsl:element>
    </xsl:template>

</xsl:stylesheet>
