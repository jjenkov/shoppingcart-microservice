# Shopping Cart Microservice
A simplified shopping cart microservice supporting the following functionality:

 - Create basket
 - Add to basket
 - Remove from basket
 - List basket
 - Change quantity



## Implementation Notes
Exception handling is overly "lax" - meaning some methods simply throws Exception where they could throw more narrowly
defined exceptions. However, exception handling strategies vary quite a bit between companies, so to implement it
"correctly" would require knowing the exact strategy chosen by the company.

Infrastructure (e.g. choice of web server, REST / JSON frameworks etc.) is also highly company dependent, and 
is thus subject to customization based on the choices of the company.

Store operations are missing. In a real implementation there would have been calls to the DAO components to store
the created / changed data objects. These are left out this implementation for brevity.


## Missing Validations and Polishing
 - It is possible to add the same product multiple times. When removing a product from the cart, only the first entry with the given productId will be removed.
   A solution could be to give each shopping cart entry a unique ID, instead of identifying the entry by the product ID of that entry.
 - Query parameters are not currently validated - neither for their name, nor their values.


## Test Notes
Only the core domain classes have been tested. The classes in the com.jenkov.shoppingcart.undertow package have not been
tested, as these are typically tested during integration tests.

Test coverage is 83% of classes, 55% of lines in total, but a lot higher within core classes (without the undertow package).


## Service URLS:

- [http://localhost/create?cartId=cartId](http://localhost/create?cartId=cartId)
- [http://localhost/add?cartId=cartId&productId=prodId&quantity=123](http://localhost/add?cartId=cartId&productId=prodId&quantity=123)
- [http://localhost/remove?cartId=cartId&productId=prodId](http://localhost/remove?cartId=cartId&productId=prodId)
- [http://localhost/changeQnt?cartId=cartId&productId=prodId&quantity=456](http://localhost/changeQnt?cartId=cartId&productId=prodId&quantity=456)
- [http://localhost/list?cartId=cartId](http://localhost/list?cartId=cartId)

