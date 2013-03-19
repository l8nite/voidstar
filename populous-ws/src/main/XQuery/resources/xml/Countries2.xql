xquery version "1.0";
for $hos  in doc("Countries.xml")/Countries/Country
let  $h  :=  $hos /HeadOfState
where $hos /GNP>5000
 order by
      $hos /Name
return $h