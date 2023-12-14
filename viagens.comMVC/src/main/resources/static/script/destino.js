// Obtenha todos os elementos com a classe 'card-local'
const cards = document.querySelectorAll('.card-local');

// Mapeamento manual entre os IDs dos cards e os caminhos das imagens
const imagensPorCard = {
  'card-1': '/img/destinos/salvador.jpg',
  'card-2': '/img/destinos/sao_paulo.jpg',
  'card-3': '/img/destinos/rio_de_janeiro.jpg',
  'card-4': '/img/destinos/porto_galinhas.jpg',
  'card-5': '/img/destinos/chapada_dos_veadeiros.jpg',
  'card-6': '/img/destinos/fortaleza.jpg',
  'card-7': '/img/destinos/foz_iguacu.jpg',
  'card-8': '/img/destinos/lencois_maranhenses.jpg',
  'card-9': '/img/destinos/lisboa.jpg',
  'card-10': '/img/destinos/porto.jpg',
  'card-11': '/img/destinos/roma.jpg',
  'card-12': '/img/destinos/veneza.jpg',
  'card-13': '/img/destinos/madri.jpg',
  'card-14': '/img/destinos/londres.jpg',
  'card-15': '/img/destinos/bariloche.jpg',
  'card-16': '/img/destinos/puntadeleste.jpg',
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
