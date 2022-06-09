$(document).ready(function () {

    // read-render  prodotti-articoli
    function getProdotto() {
        $.get('articoli', function (res) {
            for (const p of res.object) {
                $(`<div class="riga">
                        <div class="cella">${p.codiceArticolo}</div>
                        <div class="cella">${p.nome}</div>
                        <div class="cella">${p.foto}</div>
                        <div class="cella">${p.prezzo}</div>
                        <div class="cella">${p.colore}</div>
                        <div class="cella">${p.taglia}</div>
                        <div class="cella">${p.quantita}</div>
                        <div class="cella">${p.sesso}</div>
                        <div class="cella">${p.categoria.tipo}</div>

				   		<div class="cella">
				   		<button class='btn' data-id='${p.codiceArticolo}'>Elimina</button></div>
                        <div class="cella">
				   		<button class='btn' data-id='${p.codiceArticolo}'>Modifica</button>
				   		</div>
				   </div>`).appendTo($('#tabella-articoli'));
            }
        });
    }

    getProdotto();


    // click modale prodotti
    $("#btn-aggiungi").on("click", function () {
        $("#modale-prodotto").show();
    })

    // funzione chiamata quando faccio click sul pulsante aggiungi 
    $("#btn-aggiungi-modale").on("click", function () {
        $("#modale-prodotto").hide();
        const prodotto = { nome: $("#nome").val(), foto: $("#foto").val(), prezzo: $("#prezzo").val(), colore: $("#colore").val(), taglia: $("#taglia").val(), quantita: $("#quantita").val(), sesso: $("#sesso").val(), categoria: { id: $("#categorie").val(), tipo: null } };
        console.log(prodotto);
        aggiungiProdotto(prodotto);

    })

    $("#btn-chiudi-modale").on("click", function () {
        $("#modale-prodotto").hide();
    })

    // create-aggiungi prodotto
    function aggiungiProdotto(prodotto) {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            data: JSON.stringify(prodotto),
            url: "articoli",
            type: "POST",
            success: function () {
                $("#tabella-articoli").html('');
                getProdotto();
            }
        })
    }





    //CATEGORIA
    // read-render categorie
    function getCategorie() {
        $.get('categorie', function (res) {
            for (const c of res.object) {

                $(`<div class ="riga">
                        <div class= "cella">${c.id}</div>
                        <div class= "cella">${c.tipo}</div>
            
                        <div class= "cella">
                        <button class="btn" data-id='${c.id}'>Elimina</button></div>
                        <div class="ccella">
				   		<button class="btn" data-id='${c.id}'>Modifica</button></div>
                    </div>`).appendTo($('#tabella-categoria'));

                $(`<option value="${c.id}">${c.tipo}</option>`).appendTo($("#categorie"));
            }
        });
    }

    getCategorie();


    // click modale categorie
    $("#btn-aggiungi-categoria").on("click", function () {
        $("#modale-categoria").show();
    })

    // funzione chiamata quando faccio click sul pulsante aggiungi 
    $("#btn-aggiungi-modale-categoria").on("click", function () {
        $("#modale-categoria").hide();
        let categ = { tipo: $("#tipo") };
        aggiungiCategoria(categ);
    })

    $("#btn-chiudi-modale-categoria").on("click", function () {
        $("#modale-categoria").hide();
    })

    // create-aggiungi categoria
    function aggiungiCategoria(categ) {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            data: JSON.stringify(categ),
            url: "articoli",
            type: "POST",
            success: function () {
                $("#tabella-categoria").html('');
                getCategoria();
            }
        })
    }
})

