
1.1. Список названий товаров.
сss
.product-card h4

xpah
//div[contains(@class, 'product-card')]//h4

1.2. Список цен товаров.
сss
.product-card div[style*="font-weight:bold"]

xpah
//div[contains(@class, 'product-card')]//div[contains(text(), '₽')]

1.3. Название товара с ценой 25.
сss
div.product-card[data-price="25"] h4

xpah
//div[@class='product-card' and @data-price='25']//h4

1.4. Цена товара с названием «Стакан».
сss
div.product-card[data-name="Стакан"] div[style*="font-weight:bold"]

xpah
//div[@class='product-card' and @data-name='Стакан']//div[contains(text(), '₽')]

1.5. Список карточек товаров в корзине.
сss
#cart-items .cart-item

xpah
//div[@id='cart-items']//div[contains(@class, 'cart-item')]

1.6. Кнопка корзины.
сss
#open-cart-btn

xpah
//button[@id='open-cart-btn']