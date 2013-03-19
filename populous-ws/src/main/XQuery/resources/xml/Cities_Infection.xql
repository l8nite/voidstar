xquery version "1.0";

for $inf in 
	doc("Infections.xml")/Infections/Infection

for $cit in
	doc("Cities.xml")/Cities/City

where
	$inf/CityID = $cit/ID
	
and
	$inf/Zombies > 40000

order by 
	$cit/Population

return
	$cit/Name