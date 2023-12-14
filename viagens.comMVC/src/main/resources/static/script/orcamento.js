function obterDadosDestino() {
    // Recupere os dados do localStorage
    const destinoDataString = localStorage.getItem('destinoData');

    // Verifique se há dados armazenados
    if (destinoDataString) {
        const destinoData = JSON.parse(destinoDataString);
        
        // Pegar os dados, exiba-os na página
        document.getElementById('viagemImagem').src = destinoData.imagem;
        document.getElementById('viagemTitulo').innerText = destinoData.titulo;
        document.getElementById('viagemDescricao').innerText = destinoData.descricao;

        // Limpe os dados do localStorage após usá-los
        localStorage.removeItem('destinoData');
    }
}

// Chame a função para obter os dados quando a página de destino carregar
obterDadosDestino();