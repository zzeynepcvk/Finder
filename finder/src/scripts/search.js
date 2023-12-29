const container = document.querySelector('.container');
        const emojis = ['🛒', '💻', '🎧', '🎮', '⌨️', '☎️'];

        function addEmoji() {
            const emoji = document.createElement('div');
            emoji.classList.add('emoji');
            emoji.textContent = emojis[Math.floor(Math.random() * emojis.length)];
        
            emoji.style.left = Math.random() * (window.innerWidth - 20) + 'px';
            emoji.style.top = Math.random() * (window.innerHeight - 20) + 'px';
        
            // Ekleme öncesi kontrol
            if (!container.contains(emoji)) {
                container.appendChild(emoji);
            }
        
            setTimeout(() => {
                emoji.style.opacity = 0;
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
            var searchButton = document.getElementById('search-button');
            var items = document.getElementById('itemList');

            if (!searchInput || !searchButton || !items || !container) {
                console.error('Required elements not found.');
                return;
            }

            searchInput.addEventListener('input', function () {
                updateURL();
                fetchResults();
            });

        
            searchButton.addEventListener('click', function () {
                updateURL();
                fetchResults();
            });

            function updateURL() {
                const searchTerm = searchInput.value;
                const currentUrl = new URL(window.location.href);
                currentUrl.searchParams.set('q', searchTerm);
                history.pushState({}, '', currentUrl);
            }

            function fetchResults() {
                const searchTerm = searchInput.value;
                fetch(`http://localhost:5000/autocomplete?q=${searchTerm}`)
                    .then(response => response.json())
                    .then(data => {
                        displayResults(data);
                    })
                    .catch(error => {
                        console.error('Error fetching data:', error);
                    });
            }

            function displayResults(results) {
            items.innerHTML = '';

            if (results.data && results.data.length > 0) {
                results.data.forEach(result => {
                    const listitemleri = document.createElement('li');
                    listitemleri.textContent = result.title;
                    items.appendChild(listitemleri);
                });
            } else {
                const listitemleri = document.createElement('li');
                listitemleri.textContent = 'No results found.';
                items.appendChild(listitemleri);
            }
        }

            function redirectToProductPage() {
                const productPageUrl = 'product.html';
                window.location.href = productPageUrl;
            }

            items.addEventListener('click', function (event) {
                if (event.target.tagName === 'LI') {
                    const clickedResult = event.target.textContent;
                    searchInput.value = clickedResult;
                    updateURL();
                    fetchResults();
                    redirectToProductPage();
                }
            });
        });