<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:output indent="yes"/>
    <xsl:template match="/">
        <items>
            <xsl:apply-templates/>
        </items>
    </xsl:template>

    <xsl:template match="//items//field">
        <item>
            <xsl:attribute name="field">
                <xsl:value-of select="."/>
            </xsl:attribute>
        </item>
    </xsl:template>
</xsl:stylesheet>