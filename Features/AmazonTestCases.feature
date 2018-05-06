Feature: Amazon.in page Automation

Scenario Outline:


Given User is on Amazon page
When User searches "<laptop1>","<laptop2>", "<laptop3>", "<laptop4>", "<laptop5>" and adds five laptops to the cart individually 
#And User searches "<laptop2>" and adds the second laptop to cart
#And User searches "<laptop3>" and adds the third laptop to cart
#And User searches "<laptop4>" and adds the fourth laptop to cart
#And User searches "<laptop5>" and adds the fifth laptop to cart
Then User verifies whether all the selected laptops were in cart or not

Examples:
|laptop1|laptop2|laptop3|laptop4|laptop5|
|Dell|HP|Acer|Asus|Lenovo Laptop|
