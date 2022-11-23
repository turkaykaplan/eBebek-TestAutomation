Feature: Sepete Ürün Ekleme Testi

  Scenario: E-Bebek sitesinden sepete ürün ekleme.


    Given Main page opens. (www.e-bebek.com)
    And type biberon in the search bar.
    And the search is done.
    And Click on the first product
    And Click the Add to Cart button.
    And Click on See Cart button.
    And it is checked that the product has been added to the cart.

