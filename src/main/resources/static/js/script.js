document.addEventListener('DOMContentLoaded', function() {
    // Funzione per ottenere e popolare gli anime di tendenza
    fetch('http://localhost:8080/api/v1/trendig')
        .then(response => response.json())
        .then(data => {
            const grid = document.querySelector('.grid');
            grid.innerHTML = ''; // Pulisce il contenuto esistente

            data.forEach(anime => {
                const item = document.createElement('div');
                item.className = 'item';

                item.innerHTML = `
                    <img src="${anime.posterImage.original}" alt="${anime.titles.en_jp}">
                    <div class="text">
                        <span class="badge">${anime.showType}</span>
                        <p>${anime.titles.en_jp}</p>
                    </div>
                `;

                grid.appendChild(item);
            });
        })
        .catch(error => console.error('Error fetching trending data:', error));

    // Funzione per ottenere e popolare gli episodi recenti
    fetch('http://localhost:8080/api/v1/last-episodes') // Assicurati che l'endpoint sia corretto
        .then(response => response.json())
        .then(data => {
            const carousel = document.querySelector('.carousel');
            carousel.innerHTML = ''; // Pulisce il contenuto esistente

            data.forEach(episode => {
                const item = document.createElement('div');
                item.className = 'carousel-item';

                item.innerHTML = `
                    <img src="${episode.thumbnail.original || 'https://via.placeholder.com/200x300'}" alt="${episode.canonicalTitle || 'Episode'}">
                    <div class="add-to-list">+ Add to My List</div>
                `;

                carousel.appendChild(item);
            });
        })
        .catch(error => console.error('Error fetching recent episodes:', error));
});
