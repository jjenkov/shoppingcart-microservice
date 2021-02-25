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


## Test Notes
In this particular case there are not a lot of unit tests implemented. This is not because I do not believe in unit tests,
but simply because most of the code in this project is simple "plumming" - transportation of data - so most of the
code will be tested via integration tests anyways. In a real production setting I would have implemented more unit tests
for the components in this app.


## Service URLS:

- [http://localhost/create?cartId=cartId](http://localhost/create?cartId=cartId)
- [http://localhost/add?cartId=cartId&productId=prodId&quantity=123](http://localhost/add?cartId=cartId&productId=prodId&quantity=123)
- [http://localhost/remove?cartId=cartId&productId=prodId](http://localhost/remove?cartId=cartId&produdctId=prodId)
- [http://localhost/changeQnt?cartId=newCartId&productId=prodId&quantity=456](http://localhost/changeQnt?cartId=newCartId&productId=prodId&quantity=456)
- [http://localhost/list?cartId=cartId](http://localhost/list?cartId=cartId)

