
document.addEventListener("DOMContentLoaded", function() {
    // Form elemanını seç
    var signUpForm = document.querySelector('.signup-container form');

    // Form submit olduğunda çalışacak fonksiyon
    signUpForm.addEventListener('submit', function(event) {
        // Sayfa yenilemeyi önle
        event.preventDefault();

        // Kullanıcının girdiği verileri al
        var email = document.getElementById('email').value;
        var phone = document.getElementById('phone').value;
        var password = document.getElementById('password').value;

        // Verileri tarayıcı yerel depolama üzerine kaydet
        var userData = {
            email: email,
            phone: phone,
            password: password
        };

        // Yerel depolama anahtarını oluştur
        var storageKey = 'userData';

        // Daha önce kaydedilmiş verileri kontrol et localstorage a kaydediyo simdilik
        var existingData = localStorage.getItem(storageKey);
        var dataArray = existingData ? JSON.parse(existingData) : [];

        // Yeni veriyi ekle
        dataArray.push(userData);

        // Veriyi JSON formatına çevirip yerel depolamaya kaydet
        localStorage.setItem(storageKey, JSON.stringify(dataArray));

        // Kullanıcıya başarılı mesajını göster (opsiyonel)
        alert('Kayıt başarılı!');

        // Formu temizle (isteğe bağlı)
        signUpForm.reset();
    });
});
