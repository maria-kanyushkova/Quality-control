#Наименования багов:

## 1. Не создается профиль пользователя
**Priority:** Blocker

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Нажать на кнопку "Account" в header
- В появившемся окне нажать на "Регистрация"
- Ввести login: login
- Ввести password: password
- Ввести имя: name
- Ввести email: email@email.email
- Ввести address: address
- Нажать на кнопку "Зарегистрироваться"

**Result:**
Пользователь не зарегистрировался

**Expected Result:**
Пользователь зарегистрировался

![bug1](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/1.jpg)

## 2. Нельзя прочесть ошибку регистрации
**Priority:** Major

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Нажать на кнопку "Account" в header
- В появившемся окне нажать на "Регистрация"
- Ввести login: login
- Ввести password: password
- Ввести имя: name
- Ввести email: email@email.email
- Ввести address: address
- Нажать на кнопку "Зарегистрироваться"

**Result:**
Не показывается текст ошибки

**Expected Result:**
Показывается текст ошибки

![bug2](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/2.jpg)

## 3. Некорректно высчитывается скидка на товар
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Нажать на кнопку "Men" в menubar

**Result:**
Скидка не соответствует изменению стоимости

**Expected Result:**
Скидка соответствует изменению стоимости

![bug3](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/3.jpg)

## 4. Не корректно подгружается страница при изменении фильтров
**Priority:** Critical

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Ввести в поле поиска "111"
- Нажать в фильтрах discount: "50% and above"
- Как только подгрузится нажать в фильтрах discount: "60% and above"

**Result:**
Появляется дубляж страницы

**Expected Result:**
Страница подгружается без дубляжа

![bug4](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/4.jpg)

## 5. Не отображается первоначальная цена после применения скидки
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Нажать на кнопку "Men" в menubar
- Найти товар с наименованием "ЧАСЫ 8"

**Result:**
Первоначальная цена не отображается

**Expected Result:**
Первоначальная цена отображается

![bug5](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/5.jpg)

## 6. Отрицательная стоимость товара
**Priority:** Major

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Нажать на кнопку "Men" в menubar
- Найти товар с наименованием "TEST TITLE"

**Result:**
Отображается несуществующая стоимость

**Expected Result:**
Отображается существующая стоимость

![bug6](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/6.jpg)

## 7. Показывается скидка на товар, где скидки нет
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Нажать на кнопку "Men" в menubar
- Найти товар с наименованием "TITLE"

**Result:**
Скидка показывается

**Expected Result:**
Скидка не показывается

![bug7](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/7.jpg)

## 8. Некорректное именование фильтров в поиске
**Priority:** Trivial

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Ввести в поле поиска "111"

**Result:**
Наименование с маленькой буквы

**Expected Result:**
Наименование с большой буквы

![bug8](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/8.jpg)

## 9. Некорректное применение фильтров цвета товара в поиске
**Priority:** Critical

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Ввести в поле поиска "111"
- Нажать на первый цвет в COLOUR

**Result:**
Переходит на главную страницу

**Expected Result:**
Фильтр цвета применяется

## 10. При нажатии на кнопку "в конец списка" в пагинации, показывается, что нет товара
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Нажать на кнопку "Men" в menubar
- Долистать до конца списка товаров
- Кликнуть на кнопку ">>"

**Result:**
Показывается, что ничего не найдено

**Expected Result:**
Показываются товары

![bug10](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/10.jpg)

## 11. Показывается некорректное количество товаров
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Нажать на кнопку "Kids" в menubar
- Долистать до конца списка

**Result:**
Количество товаров показывается больше чем разрешено пагинацией

**Expected Result:**
Количество товаров показывается меньше или равно разрешенному числу товара пагинации

![bug11](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/11.jpg)

## 12. Не подгрузились шрифты для фильтров
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Нажать на кнопку "Women" в menubar

**Result:**
Показываются стандартные шрифты

**Expected Result:**
Показываются шрифты по дизайну

![bug12](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/12.jpg)

## 13. Не работает поиск
**Priority:** Critical

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Ввести в поле поиска "111"

**Result:**
Поиск показывает не релевантные результаты

**Expected Result:**
Поиск показывает релевантные результаты

![bug13](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/13.jpg)

## 14. Не соответствует количество отзывов в оценке и reviews
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Пролистать до списка товаров вниз
- Кликнуть на "Casio MRP-700-1AVEF"

**Result:**
Показывается оценка не по всем отзывам

**Expected Result:**
Показывается оценка по всем отзывам

![bug14](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/14.jpg)

## 15. Можно добавить в корзину отрицательное количество товаров
**Priority:** Critical

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Пролистать до списка товаров вниз
- Кликнуть на "Casio MRP-700-1AVEF"
- Ввести в количество "-100"
- Нажать на кнопку "ADD TO CARD"

**Result:**
Товар в отрицательном количестве добавляется в корзину

**Expected Result:**
При вводе значения меньше 1 появляется ошибка поля

![bug15](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/15.jpg)

## 16. Можно добавить в корзину товар, не выбрав все параметры
**Priority:** Critical

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Пролистать до списка товаров вниз
- Кликнуть на "Casio MRP-700-1AVEF"
- Нажать на кнопку "ADD TO CARD"

**Result:**
Товар с невыбранным цветом можно добавить в корзину

**Expected Result:**
Товар с невыбранным цветом нельзя добавить в корзину

![bug161](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/16-1.jpg)
![bug16-2](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/16-2.jpg)

## 17. Можно добавить в корзину бесконечное количество товаров
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Пролистать до списка товаров вниз
- Кликнуть на "Casio MRP-700-1AVEF"
- Ввести в количество "10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"
- Нажать на кнопку "ADD TO CARD"

**Result:**
Товар добавляется не весь

**Expected Result:**
Ошибка поля ввода

![bug17](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/17.jpg)

## 18. Не оформляется заказ с корзины
**Priority:** Blocker

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Пролистать до списка товаров вниз
- Кликнуть на "Citizen BJ2111-08E"
- Нажать "ADD TO CARD"
- Нажать "Оформить заказ"
- Ввести login: login
- Ввести password: password
- Ввести имя: name
- Ввести email: email@email.email
- Ввести address: address
- Ввести note: note
- Нажать "Оформить"

**Result:**
Заказ не оформляется

**Expected Result:**
Заказ оформляется

![bug18](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/18.jpg)

## 19. Не получается подписаться на рассылку
**Priority:** Major

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Листаем страницу до конца (footer)
- Вводим в email (temp mail): yotiw63517@aalyaa.com
- Нажимаем на "Subscribe"

**Result:**
Страница обновилась, не было никакого уведомления что подписка оформилась

**Expected Result:**
Произошла подписка на обновления и рекламу

## 20. При клике на производителей часов не переходит в их каталог
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Прокрутить ниже слайдера к производителям часов
- Кликнуть на Casio

**Result:**
Ничего не происходит

**Expected Result:**
Происходит переход к товарам этого производителя

![bug20](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/20.jpg)

## 21. Не переходит на страницу Facebook от Luxury watches
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Листаем страницу до конца (site map)
- Нажимаем на кнопку Facebook

**Result:**
Перезагружается страница

**Expected Result:**
Переход на Facebook

## 22. Не переходит на страницу Twitter от Luxury watches
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Листаем страницу до конца (site map)
- Нажимаем на кнопку Twitter

**Result:**
Перезагружается страница

**Expected Result:**
Переход на Twitter

## 23. Не переходит на страницу Google+ от Luxury watches
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Листаем страницу до конца (site map)
- Нажимаем на кнопку Google+

**Result:**
Перезагружается страница

**Expected Result:**
Переход на Google+

## 24. Не переходит на страницу Specials
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Листаем страницу до конца (site map)
- Нажимаем на кнопку Specials

**Result:**
Перезагружается страница

**Expected Result:**
Переход на страницу Specials

## 25. Не переходит на страницу New Production
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Листаем страницу до конца (site map)
- Нажимаем на кнопку New Production

**Result:**
Перезагружается страница

**Expected Result:**
Переход на страницу New Production

## 26. Не переходит на страницу Our Stores
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Листаем страницу до конца (site map)
- Нажимаем на кнопку Our Stores

**Result:**
Перезагружается страница

**Expected Result:**
Переход на страницу Our Stores

## 27. Не переходит на страницу Contact Us
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Листаем страницу до конца (site map)
- Нажимаем на кнопку Contact Us

**Result:**
Появляется ошибка

**Expected Result:**
Отображается страница Specials

![bug27](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/27.jpg)

## 28. Не переходит на страницу Top Sellers
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Листаем страницу до конца (site map)
- Нажимаем на кнопку Top Sellers

**Result:**
Перезагружается страница

**Expected Result:**
Переход на страницу Top Sellers

## 29. Не отображается страница My Account
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Листаем страницу до конца (site map)
- Нажимаем на кнопку My Account

**Result:**
Появляется ошибка

**Expected Result:**
Отображается страница My Account

![bug29](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/29.jpg)

## 30. Не переходит на страницу My Credit slips
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Листаем страницу до конца (site map)
- Нажимаем на кнопку My Credit slips

**Result:**
Перезагружается страница

**Expected Result:**
Переход на страницу My Credit slips

## 31. Не переходит на страницу My Merchendise returns
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Листаем страницу до конца (site map)
- Нажимаем на кнопку My Merchendise returns

**Result:**
Перезагружается страница

**Expected Result:**
Переход на страницу My Merchendise returns

## 32. Не переходит на страницу My Personal info
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Листаем страницу до конца (site map)
- Нажимаем на кнопку My Personal info

**Result:**
Перезагружается страница

**Expected Result:**
Переход на страницу My Personal info

## 33. Не переходит на страницу My Addresses
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Листаем страницу до конца (site map)
- Нажимаем на кнопку My Addresses

**Result:**
Перезагружается страница

**Expected Result:**
Переход на страницу My Addresses

## 34. Не отображается информация о товаре
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Пролистать до списка товаров вниз
- Кликнуть на "Casio MRP-700-1AVEF"

**Result:**
Пишется стандартный текст во всех из 5 разделах

**Expected Result:**
Есть полное описание товара

![bug34](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/34.jpg)

## 35. Не отображается корректно слайдер в профиле товара
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Пролистать до списка товаров вниз
- Кликнуть на "Casio MRP-700-1AVEF"

**Result:**
Слайдер показывает половину предыдущего изображения и половину следующего

**Expected Result:**
Слайдер показывает текущее изображение без половин

![bug35](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/35.jpg)

## 36. Не получается посмотреть отзывы о товаре
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Пролистать до списка товаров вниз
- Кликнуть на "Casio MRP-700-1AVEF"

**Result:**
Происходит переход на главную страницу

**Expected Result:**
Появляются отзывы о товаре

## 37. Поле подписки на рассылку не выровнено
**Priority:** Minor

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Листаем страницу до конца (footer)

**Result:**
Поле почты и кнопка подписки не имеют одинаковую высоту и находятся не на одном уровне

**Expected Result:**
Поле почты и кнопка подписки имеют одинаковую высоту и находятся на одном уровне

![bug37](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/37.jpg)

## 38. Кнопки header menu не выровнены по высоте
**Priority:** Trivial

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Листаем страницу до самого начала (header)

**Result:**
Поля имеют разный размер шрифта и кнопки не имеют одинаковую высоту и находятся не на одном уровне

**Expected Result:**
Поля имеют одинаковый размер шрифта и кнопки имеют одинаковую высоту и находятся на одном уровне

![bug38](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/38.jpg)

## 39. Имеется не обновленный до текущего года копирайтинг
**Priority:** Trivial

**Device:** Windows Chrome 86.0.4240.75

**Steps:**
- Листаем страницу до конца (footer)

**Result:**
Показывается копирайтинг 2015 года

**Expected Result:**
Показывается копирайтинг 2020 года

![bug39](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/39.jpg)

## 40. Поле поиска имеет маленький размер
**Priority:** Minor

**Device:** iPhone 7 iOs 14 Safari

**Steps:**
- Листаем страницу до поля поиска

**Result:**
Поле поиска имеет не удобочитаемый размер

**Expected Result:**
Поле поиска имеет удобочитаемый размер

![bug40](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/40.jpg)

## 41. Кнопки header menu не выровнены по высоте (мобилка)
**Priority:** Minor

**Device:** iPhone 7 iOs 14 Safari

**Steps:**
- Листаем страницу до самого начала (header)

**Result:**
Поля имеют разный размер шрифта и кнопки не имеют одинаковую высоту и находятся не на одном уровне

**Expected Result:**
Поля имеют одинаковый размер шрифта и кнопки имеют одинаковую высоту и находятся на одном уровне

![bug41](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/41.jpg)

## 42. Не отображается корректно информация о товаре (мобилки)
**Priority:** Minor

**Device:** iPhone 7 iOs 14 Safari

**Steps:**
- Пролистать до списка товаров вниз
- Кликнуть на "Casio MRP-700-1AVEF"

**Result:**
Текст из раздела наползает на заглавие других разделов

**Expected Result:**
Текст из раздела не наползает на заглавие других разделов

![bug42](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/42.jpg)

## 43. Съехали кнопки добавления товара в корзину (мобилки)
**Priority:** Minor

**Device:** iPhone 7 iOs 14 Safari

**Steps:**
- Пролистать до списка товаров вниз
- Кликнуть на "Casio MRP-700-1AVEF"

**Result:**
Поля находятся на разном уровне

**Expected Result:**
Поля находятся на одинаковом уровне

![bug43](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/43.jpg)

## 44. Некорректное отображение корзины на мобильных устройствах
**Priority:** Minor

**Device:** iPhone 7 iOs 14 Safari

**Steps:**
- Пролистать до списка товаров вниз
- Кликнуть на "Casio MRP-700-1AVEF"
- Нажать на кнопку "ADD TO CARD"

**Result:**
Сводная таблица товаров не помещается в ширину экрана мобильного телефона

**Expected Result:**
Сводная таблица товаров помещается в ширину экрана мобильного телефона

![bug44](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/44.jpg)

## 45. Некорректное отображение кнопок управления корзины на мобильных устройствах
**Priority:** Minor

**Device:** iPhone 7 iOs 14 Safari

**Steps:**
- Пролистать до списка товаров вниз
- Кликнуть на "Casio MRP-700-1AVEF"
- Нажать на кнопку "ADD TO CARD"

**Result:**
Кнопки слиплись воедино, не имеют отступов между собой

**Expected Result:**
Кнопки разделены отступами

![bug45](https://github.com/maria-kanyushkova/Quality-control/blob/master/src/main/resources/lab7/45.jpg)

## 46. Нельзя проверить работу логинации пользователя
**Priority:** Minor

**Device:** iPhone 7 iOs 14 Safari

**Steps:**
- Нажать на кнопку "Account" в header
- Ввести login: login
- Ввести password: password
- Нажать на кнопку "Вход"

**Result:**
Нельзя проверить вход в профиль, так как пользователи не создаются

**Expected Result:**
Пользователь зашел в свой профиль

