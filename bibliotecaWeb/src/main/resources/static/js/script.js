$(document).ready(function() {
    $('#searchButton').click(function() {
        pesquisarLivro();
    });

    $('#searchInput').on('input', function() {
        pesquisarLivro();
    });
    
    
});

function voltar() {
        window.history.back();
    }

function pesquisarLivro() {
    var input = $('#searchInput').val();
    var url = '/pesquisarLivro?search=' + input;
    $.get(url, function(data) {
        var tableBody = $('#resultTable tbody');
        tableBody.empty();
        $.each(data, function(index, livro) {
            var newRow = $('<tr>');
            newRow.append($('<td>').text(livro.titulo));
            newRow.append($('<td>').text(livro.autor));
            newRow.append($('<td>').html(
                '<a href="/detalhes?id=' + livro.id + '" class="btn btn-info me-2">Ver Livro</a>' +
                '<a href="/baixar?id=' + livro.id + '" class="btn btn-success">Baixar Livro</a>'
            ));
            tableBody.append(newRow);
        });
    });
}



