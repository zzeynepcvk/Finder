package design_pattern.tasarimlar_ve_amaclari;

public class  tasarimlar_ve_amaclari {

    /*
    * Her bir ürünü nesne olarak aldım bu durum çok fazlaya sebep oldu nesne sayısını azalmak için flyweight kullandım

    * Ürünlerin kendi içerisinde hiyerarşik bir yapısı vardı mesela elektronik altında telefon , telefon altında iphone telefon , android telefon gibi
       alt kategoriler vardı burada esneklik sağlamak için composite kullandım

    * Sitemizde ürünlerin diğer e-ticaret sitelerine yönledirimlesi söz  konusu idi arka taraftaki karmaşıklığı gizlemekiçin facade kullandım

    * Sayfa içerisinde ürünlerin resmi yüklenene kadar porxy tarafından geçici bir nesnenı onun yerine geçmesini sağlamak için proxy kullandım

    * Kullanıcı tarafından bildirimleri açılan ürün indirime girdiğinde  kullanıcıya haber vermesi için observer kullandım

    * Veritabanı bağlantısını globalde tanımlamak için singleton kullandım
    * */
}
