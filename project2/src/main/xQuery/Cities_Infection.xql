xquery version "1.0";

for $inf in doc("Infections.xml")/Infection

for $cit in doc("Cities.xml")/City

let
        $n := $cit/Name

where 
       Sinf/CityID = $cit/ID
and $inf/population>250000

order by $cit/Population

return $n