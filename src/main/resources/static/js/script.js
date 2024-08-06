document.addEventListener('DOMContentLoaded', function() {
    // Funzione per ottenere e popolare gli anime di tendenza
    fetch('http://localhost:8080/api/v1/last-episodes')
        .then(response => response.json())
        .then(data => {
            const grid = document.querySelector('.grid');
            grid.innerHTML = ''; // Pulisce il contenuto esistente

            data.forEach(episode => {
                const item = document.createElement('div');
                item.className = 'item';

                item.innerHTML = `
                    <a href="#">
                        <img src="${episode.thumbnail.original}" alt="${episode.canonicalTitle}">
                    </a>
                    <div class="text">
                        <span class="badge">TV</span>
                        <span class="badge-airdate">${episode.airdate}</span>
                        <p>${episode.canonicalTitle}</p>
                    </div>
                `;

                grid.appendChild(item);
            });
        })
        .catch(error => console.error('Error fetching trending data:', error));

    // Funzione per ottenere e popolare gli episodi recenti
    fetch('http://localhost:8080/api/v1/trending') // Assicurati che l'endpoint sia corretto
        .then(response => response.json())
        .then(data => {
            const carousel = document.querySelector('.carousel');
            carousel.innerHTML = ''; // Pulisce il contenuto esistente

            data.forEach(anime => {
                const item = document.createElement('div');
                item.className = 'carousel-item';

                item.innerHTML = `

                    <a href="/anime/${anime.slug}">
                    <img src="${anime.posterImage.original || 'https://via.placeholder.com/200x300'}" alt="${anime.titles.en_jp || 'Anime'}">
                    </a>
                    <div class="add-to-list">+ Add to My List</div>
                `;

                carousel.appendChild(item);
            });
        })
        .catch(error => console.error('Error fetching recent episodes:', error));
});
