xquery version "1.0";


for $pop in doc("Cities.xml")/Cities/City
let $p:= $pop /Name
where $pop/Population>300000
order by $pop /ID
return $p 