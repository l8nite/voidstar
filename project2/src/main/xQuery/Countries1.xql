xquery version "1.0";

for $country in doc("Countries.xml")/Country
let $c :=$country /Name
where $country/LifeExpectancy>75
 order by
      $country/Continent
return $c 