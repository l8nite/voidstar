xquery version "1.0";
for $hos in doc("Countries.xml")/Country
let  $h  :=  $hos /HeadOfState
where $hos /GNP>5000
 order by
      $hos /Name
return $h