/*
1a. Detail + Date
How many infected by Epidemic by Year
*/

SELECT
    InfectionEventDetail.Epidemic, 
    InfectionEventDate.Year, 
    SUM(InfectionEvent.Infected) 
FROM 
    InfectionEvent 
    INNER JOIN InfectionEventDetail ON InfectionEvent.InfectionEventDetailID = InfectionEventDetail.ID 
    INNER JOIN InfectionEventDate ON InfectionEvent.InfectionEventDateID = InfectionEventDate.ID 
GROUP BY 
    InfectionEventDetail.Epidemic, InfectionEventDate.Year
ORDER BY 
    InfectionEventDate.Year, InfectionEventDetail.Epidemic;


/*
1b. City + Detail
How many infected in City by Vector
*/

SELECT 
    CONCAT(City.Name, CONCAT(", ", Country.Name)) as CityCountry, 
    InfectionEventDetail.Vector, 
    SUM(InfectionEvent.Infected)
FROM 
    InfectionEvent 
    INNER JOIN City ON InfectionEvent.CityID = City.ID 
    INNER JOIN Country ON City.CountryCode = Country.Code 
    INNER JOIN InfectionEventDetail ON InfectionEvent.InfectionEventDetailID = InfectionEventDetail.ID 
GROUP BY 
    CityCountry, InfectionEventDetail.Vector
ORDER BY
    CityCountry, InfectionEventDetail.Vector;


/*
1c. City + Date
How many infected in City by Year
*/

SELECT
    CONCAT(City.Name, CONCAT(", ", Country.Name)) as CityCountry,
    InfectionEventDate.Year,
    SUM(InfectionEvent.Infected)
FROM
    InfectionEvent 
    INNER JOIN City ON InfectionEvent.CityID = City.ID 
    INNER JOIN Country ON City.CountryCode = Country.Code
    INNER JOIN InfectionEventDate ON InfectionEvent.InfectionEventDateID = InfectionEventDate.ID 
GROUP BY 
    CityCountry, InfectionEventDate.Year
ORDER BY
    InfectionEventDate.Year;


/*
2. Drill up & Down 
2a. Base Report: How many infected by Strain within a single Epidemic by Year
*/

SELECT
    InfectionEventDetail.Strain,
    InfectionEventDetail.Epidemic,
    InfectionEventDate.Year,
    SUM(InfectionEvent.Infected)
FROM
    InfectionEvent 
    INNER JOIN InfectionEventDetail ON InfectionEvent.InfectionEventDetailID = InfectionEventDetail.ID 
    INNER JOIN InfectionEventDate ON InfectionEvent.InfectionEventDateID = InfectionEventDate.ID
WHERE
    InfectionEventDetail.Epidemic = '209efbc0-6900-4b8f-a296-9b1129654722'
GROUP BY 
    InfectionEventDetail.Strain, InfectionEventDate.Year 
ORDER BY 
    InfectionEventDate.Year, InfectionEventDetail.Strain; 


/*
2b. Drill down: How many infected by Mutation within "Alpha Zero" Strain within a single Epidemic by Year
*/

SELECT 
    InfectionEventDetail.Mutation, 
    InfectionEventDetail.Strain,
    InfectionEventDetail.Epidemic,
    InfectionEventDate.Year,
    SUM(InfectionEvent.Infected)
FROM
    InfectionEvent
    INNER JOIN InfectionEventDetail ON InfectionEvent.InfectionEventDetailID = InfectionEventDetail.ID 
    INNER JOIN InfectionEventDate ON InfectionEvent.InfectionEventDateID = InfectionEventDate.ID 
WHERE
    InfectionEventDetail.Epidemic = '209efbc0-6900-4b8f-a296-9b1129654722'
    AND InfectionEventDetail.Strain = 'Alpha Zero'
GROUP BY 
    InfectionEventDetail.Mutation, InfectionEventDate.Year 
ORDER BY
    InfectionEventDate.Year, InfectionEventDetail.Mutation;


/*
2c. Drill up: How many infected by Epidemic by Year (re-use from 1a)
*/

SELECT
    InfectionEventDetail.Epidemic, 
    InfectionEventDate.Year, 
    SUM(InfectionEvent.Infected) 
FROM 
    InfectionEvent 
    INNER JOIN InfectionEventDetail ON InfectionEvent.InfectionEventDetailID = InfectionEventDetail.ID 
    INNER JOIN InfectionEventDate ON InfectionEvent.InfectionEventDateID = InfectionEventDate.ID 
GROUP BY 
    InfectionEventDetail.Epidemic, InfectionEventDate.Year
ORDER BY 
    InfectionEventDate.Year, InfectionEventDetail.Epidemic;


/*
3. Slice & Dice
3a. Base report: How many infected by Strain within a single Epidemic by Year
*/

SELECT
    InfectionEventDetail.Strain,
    InfectionEventDetail.Epidemic,
    InfectionEventDate.Year,
    SUM(InfectionEvent.Infected)
FROM
    InfectionEvent 
    INNER JOIN InfectionEventDetail ON InfectionEvent.InfectionEventDetailID = InfectionEventDetail.ID 
    INNER JOIN InfectionEventDate ON InfectionEvent.InfectionEventDateID = InfectionEventDate.ID
WHERE
    InfectionEventDetail.Epidemic = '209efbc0-6900-4b8f-a296-9b1129654722'
GROUP BY 
    InfectionEventDetail.Strain, InfectionEventDate.Year 
ORDER BY 
    InfectionEventDate.Year, InfectionEventDetail.Strain; 


/*
3b. Slice: How many infected by Strain within a single Epidemic in 2013 (sliced by Year)
*/
SELECT
    InfectionEventDetail.Strain,
    InfectionEventDetail.Epidemic,
    InfectionEventDate.Year,
    SUM(InfectionEvent.Infected)
FROM
    InfectionEvent
    INNER JOIN InfectionEventDetail ON InfectionEvent.InfectionEventDetailID = InfectionEventDetail.ID
    INNER JOIN InfectionEventDate ON InfectionEvent.InfectionEventDateID = InfectionEventDate.ID
WHERE
    InfectionEventDetail.Epidemic = '209efbc0-6900-4b8f-a296-9b1129654722'
    AND InfectionEventDate.Year = '2013'
GROUP BY
    InfectionEventDetail.Strain, InfectionEventDate.Year
ORDER BY
    InfectionEventDate.Year, InfectionEventDetail.Strain;


/*
3c. Dice: How many infected by Strain Alpha Zero or Beta One within a single Epidemic by Years 2000 through 2013
*/

SELECT 
    InfectionEventDetail.Strain, 
    InfectionEventDetail.Epidemic, 
    InfectionEventDate.Year, 
    SUM(InfectionEvent.Infected) 
FROM 
    InfectionEvent 
    INNER JOIN InfectionEventDetail ON InfectionEvent.InfectionEventDetailID = InfectionEventDetail.ID 
    INNER JOIN InfectionEventDate ON InfectionEvent.InfectionEventDateID = InfectionEventDate.ID 
WHERE 
    InfectionEventDetail.Epidemic = '209efbc0-6900-4b8f-a296-9b1129654722' 
    AND CAST(InfectionEventDate.Year AS UNSIGNED) >= 2000
    AND CAST(InfectionEventDate.Year AS UNSIGNED) <= 2013 
    AND (
        InfectionEventDetail.Strain = 'Alpha Zero'
        OR InfectionEventDetail.Strain = 'Beta One'
    )
GROUP BY 
    InfectionEventDetail.Strain, InfectionEventDate.Year
ORDER BY
    InfectionEventDate.Year, InfectionEventDetail.Strain; 


/*
4. Pivot
4a. Normal: Infections by City and Vector (3rd dimension Year) for "Canada"
*/

SELECT 
    CONCAT(City.Name, CONCAT(", ", Country.Name)) as CityCountry, 
    InfectionEventDetail.Vector, 
    SUM(InfectionEvent.Infected)
FROM 
    InfectionEvent 
    INNER JOIN City ON InfectionEvent.CityID = City.ID 
    INNER JOIN Country ON City.CountryCode = Country.Code 
    INNER JOIN InfectionEventDetail ON InfectionEvent.InfectionEventDetailID = InfectionEventDetail.ID 
WHERE
    Country.Code = 'CAN'
GROUP BY 
    CityCountry, InfectionEventDetail.Vector
ORDER BY
    CityCountry, InfectionEventDetail.Vector;


/*
4b. Pivot: Infections by City and Year (3rd dimension is now vector) for "Canada"
*/

SELECT
    CONCAT(City.Name, CONCAT(", ", Country.Name)) as CityCountry,
    InfectionEventDate.Year,
    SUM(InfectionEvent.Infected)
FROM
    InfectionEvent 
    INNER JOIN City ON InfectionEvent.CityID = City.ID 
    INNER JOIN Country ON City.CountryCode = Country.Code
    INNER JOIN InfectionEventDate ON InfectionEvent.InfectionEventDateID = InfectionEventDate.ID 
WHERE
    Country.Code = 'CAN'
GROUP BY 
    CityCountry, InfectionEventDate.Year
ORDER BY
    InfectionEventDate.Year;