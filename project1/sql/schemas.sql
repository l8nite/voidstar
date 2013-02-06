DROP TABLE IF EXISTS `Country`;
CREATE TABLE `Country` (
    `Code` char(3) NOT NULL DEFAULT '',
    `Name` char(52) NOT NULL DEFAULT '',
    `Continent` char(13) NOT NULL DEFAULT 'Asia',
    `Region` char(26) NOT NULL DEFAULT '',
    `SurfaceArea` float(10 , 2 ) NOT NULL DEFAULT '0.00',
    `IndepYear` smallint(6) DEFAULT NULL,
    `Population` int(11) NOT NULL DEFAULT '0',
    `LifeExpectancy` float(3 , 1 ) DEFAULT NULL,
    `GNP` float(10 , 2 ) DEFAULT NULL,
    `GNPOld` float(10 , 2 ) DEFAULT NULL,
    `LocalName` char(45) NOT NULL DEFAULT '',
    `GovernmentForm` char(45) NOT NULL DEFAULT '',
    `HeadOfState` char(60) DEFAULT NULL,
    `Capital` int(11) DEFAULT NULL,
    `Code2` char(2) NOT NULL DEFAULT '',
    PRIMARY KEY (`Code`)
)  ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `CountryLanguage`;
CREATE TABLE `CountryLanguage` (
    `CountryCode` char(3) NOT NULL,
    `LanguageID` int(11) NOT NULL,
    `IsOfficial` char(1) NOT NULL DEFAULT 'F',
    `Percentage` float(4 , 1 ) NOT NULL DEFAULT '0.0',
    FOREIGN KEY (CountryCode)
        REFERENCES Country (Code)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (LanguageID)
        REFERENCES Language (ID)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Language`;
CREATE TABLE `Language` (
    `ID` int(11) NOT NULL AUTO_INCREMENT,
    `Language` char(30) NOT NULL DEFAULT '',
	PRIMARY KEY (`ID`)
)  ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `City`;
CREATE TABLE `City` (
    `ID` int(11) NOT NULL AUTO_INCREMENT,
    `Name` char(35) NOT NULL DEFAULT '',
    `CountryCode` char(3) NOT NULL DEFAULT '',
    `District` char(20) NOT NULL DEFAULT '',
    `Population` int(11) NOT NULL DEFAULT '0',
    PRIMARY KEY (`ID`),
    FOREIGN KEY (CountryCode)
        REFERENCES Country (Code)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=MyISAM AUTO_INCREMENT=4080 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Infection`;
CREATE TABLE `Infection` (
	`ID` int(11) NOT NULL AUTO_INCREMENT,
    `CityID` int(11) NOT NULL,
    `Zombies` int(11) NOT NULL DEFAULT '0',
    PRIMARY KEY (`ID`),
    FOREIGN KEY (CityID)
        REFERENCES Country (Code)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=MyISAM AUTO_INCREMENT=4080 DEFAULT CHARSET=latin1;

