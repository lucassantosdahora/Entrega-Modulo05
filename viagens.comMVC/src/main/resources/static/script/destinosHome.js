// Obtenha todos os elementos com a classe 'card-local'
const cards = document.querySelectorAll('.card-home');

// Mapeamento manual entre os IDs dos cards e os caminhos das imagens
const imagensPorCard = {
  'card-1': '/img/destinos/salvador.jpg',
  'card-2': '/img/destinos/sao_paulo.jpg',
  'card-3': '/img/destinos/rio_de_janeiro.jpg',
  'card-4': '/img/destinos/porto_galinhas.jpg',
  'card-5': '/img/destinos/madri.jpg',
  'card-6': '/img/destinos/londres.jpg',
  'card-7': '/img/destinos/bariloche.jpg',
  'card-8': '/img/destinos/puntadeleste.jpg',
};

// Adicione o evento de clique a cada card
cards.forEach(function(card) {
  card.addEventListener('click', function() {
    // Obtenha o ID do card clicado
    const cardId = this.id;

    // Crie um objeto com os dados do destino
    const destinoData = {
      id: cardId,
      titulo: this.querySelector('.card-titulo').innerText,
      descricao: this.querySelector('.descricao').innerText,
      imagem: imagensPorCard[cardId] || '/caminho/para/uma/imagem/default.jpg',
    };

    // Armazene os dados no localStorage
    localStorage.setItem('destinoData', JSON.stringify(destinoData));

    // Redirecione para a página de destino
    window.location.href = '/orcamento';
  });
});
