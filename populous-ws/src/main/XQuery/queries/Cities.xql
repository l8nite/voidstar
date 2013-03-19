xquery version "1.0";

for $pop in doc("Cities.xml")/City
let $p:= $pop /Name
where $pop/population>300000
order by $pop /ID
return $p 