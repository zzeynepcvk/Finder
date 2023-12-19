document.addEventListener("DOMContentLoaded", function() {
    // Form elemanını seç
    var loginForm = document.querySelector('.login-container form');

    // Form submit olduğunda çalışacak fonksiyon
    loginForm.addEventListener('submit', function(event) {
        // Sayfa yenilemeyi önle
        event.preventDefault();

        // Kullanıcının girdiği verileri al
        var email = document.getElementById('email').value;
        var password = document.getElementById('password').value;

        // Veritabanından kullanıcıyı kontrol et (bu kısmı kendi veritabanınıza uyarlamalısınız)
        var isUserAuthenticated = authenticateUser(email, password);

        if (isUserAuthenticated) {
            // Başarılı giriş durumu
            alert('Giriş başarılı!');
            // Anasayfaya yönlendir (bu kısmı kendi anasayfa yolunuza uyarlamalısınız)
            window.location.href = "/Finder/finder/src/pages/homePage.html";
        } else {
            // Başarısız giriş durumu
            alert('Giriş başarısız. Lütfen bilgilerinizi kontrol edin ve tekrar deneyin.');
        }
    });

    // Kullanıcı doğrulama fonksiyonu (localStorage kullanarak)
    function authenticateUser(email, password) {
        // localStorage'dan kayıtlı kullanıcı bilgilerini al
        var storedUsers = JSON.parse(localStorage.getItem('userData')) || [];

        // Kullanıcıyı kontrol et
        for (var i = 0; i < storedUsers.length; i++) {
            if (storedUsers[i].email === email && storedUsers[i].password === password) {
                return true; // Kullanıcı doğrulandı
            }
        }

        return false; // Kullanıcı doğrulanamadı
    }
});
