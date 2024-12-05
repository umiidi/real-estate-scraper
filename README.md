# Real Estate Scraper

## Açıqlama

Layihə 2 servisdən ibarətdir:

### scraper-service

Necə işləyir?

* Bina.az API-dən elanların ID-lərini çəkir 
* Bu ID-lərə görə yenidən API-də sorğu ataraq detallı məlumatları alır. 
* Sonra lazım olan məlumatları kafka-ya göndərir.
* Həmin ID-ləri bazada saxlayır ki, daha sonra eyni id-li elan yenidən proses olunmasın.
* Periodik olaraq 10 dəqiqədən bir proses təkrarlanır.
---
### api-service

Necə işləyir?

* Kafka Consumer olaraq göndərilmiş elan məlumatlarını qəbul edir və bazaya əlavə edir.
* REST API vasitəsilə elan məlumatlarını təqdim edir:
  * Pagination (səhifələmə) imkanı verir.
  * Sorting (sıralama) funksiyasını təmin edir.
  * Filtering (filtrləmə) funksiyası ilə istifadəçilər yalnız müəyyən meyarlara uyğun elanları əldə edir.

---

## Tələblər

* Java: 17 və ya yuxarı
* Docker
* Gradle

----

## Necə çalışdırmaq olar?

İlk öncə postgers və kafka servislərini işə salmaq lazımdır. 
Bunun üçün proyektin faylına keçid etmək və sonra  aşağıdakı komandanı icra etmək lazımdır.

```
docker compose up
```

Daha sonra servisləri işə sala bilərik.

**scraper-service üçün**

```
cd scraper-service
gradlew bootRun
```

**api-service üçün**

```
cd api-service
gradlew bootRun
```
