
-- Step 1: Disable foreign key checks
SET foreign_key_checks = 0;

-- Step 2: Truncate the table
TRUNCATE TABLE orders;
truncate table orderitems;
-- Step 3: Enable foreign key checks
SET foreign_key_checks = 1;