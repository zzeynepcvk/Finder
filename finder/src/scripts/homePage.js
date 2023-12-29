const container = document.querySelector('.container');
const emojis = ['🛒', '💻', '🎧', '🎮', '⌨️', '☎️','🔍'];

function addEmoji() {
 const emoji = document.createElement('div');
 emoji.classList.add('emoji');
 emoji.textContent = emojis[Math.floor(Math.random() * emojis.length)];
 

 emoji.style.left = Math.random() * (window.innerWidth - 20) + 'px';
 emoji.style.top = Math.random() * (window.innerHeight - 20) + 'px';
 
 container.appendChild(emoji);
 
 setTimeout(() => {
  emoji.style.opacity = 0;
  // Kaldırma işlemi tamamlandıktan sonra DOM'dan da kaldır
  setTimeout(() => {
      container.removeChild(emoji);
  }, 200);
}, 5000);
 

 emoji.addEventListener('click', () => {
    container.removeChild(emoji);
 });
}


let intervalId = setInterval(addEmoji, 650); 

for (let i = 0; i < 9; i++) { 
    setTimeout(addEmoji, 1000 * i);
    
}

document.addEventListener('DOMContentLoaded', function () {
  var searchInput = document.getElementById('search-bar');
  var itemList = document.getElementById('itemList');
  var items = itemList.getElementsByTagName('li');

  searchInput.addEventListener('input', function () {
    var searchTerm = searchInput.value.toLowerCase();

    // Kullanıcı bir değer girdiğinde liste görünür hale gelsin
    itemList.style.display = searchTerm ? 'block' : 'none';

    for (var i = 0; i < items.length; i++) {
      var itemText = items[i].innerText.toLowerCase();
      if (itemText.includes(searchTerm)) {
        items[i].style.display = 'block';
      } else {
        items[i].style.display = 'none';
      }
    }
  });
});




