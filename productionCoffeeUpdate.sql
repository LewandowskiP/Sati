UPDATE `satiproduction`.`productioncoffee` as A
SET
`producedBy` = null
WHERE productionCoffee_id >0;

UPDATE `satiproduction`.`productioncoffee` as A
SET
`producedBy` = (SELECT roastraport.completedBy_id FROM roastraport where roastraport.productionCoffee_id = A.productionCoffee_id LImit 1)
WHERE `producedBy` is null AND productionCoffee_id >0;

UPDATE `satiproduction`.`productioncoffee` as A
SET
`producedBy` = (SELECT instantcoffeemixraport.mixedBy FROM instantcoffeemixraport where instantcoffeemixraport.productionCoffee_id = A.productionCoffee_id)
WHERE `producedBy` is null AND productionCoffee_id >0;

UPDATE `satiproduction`.`productioncoffee` as A
SET
`producedBy` = (SELECT productionraportpart.employee_id FROM productionraportpart where productionraportpart.productionRaportPart_id = 
(select returnedproduct.productionRaportPart_id from returnedproduct where returnedproduct.productionCoffee_id = A.productionCoffee_id))
WHERE `producedBy` is null AND productionCoffee_id >0;

UPDATE `satiproduction`.`productioncoffee` as A
SET
`producedBy` = (SELECT productionraportpart.employee_id FROM productionraportpart where productionraportpart.productionRaportPart_id = 
(select productioncoffeeexternalreturn.productionRaportPart_id from productioncoffeeexternalreturn where productioncoffeeexternalreturn.productionCoffee_id = A.productionCoffee_id))
WHERE `producedBy` is null AND productionCoffee_id >0;

UPDATE `satiproduction`.`productioncoffee` as A
SET
`producedBy` = 3
WHERE `producedBy` is null AND productionCoffee_id >0;

SELECT * FROM satiproduction.productioncoffee;
