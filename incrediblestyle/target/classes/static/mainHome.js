//creato funzioni menu hamburger
$(document).ready(function () {

    $(".cross").hide();
    $(".menu").hide();
    $(".hamburger").click(function () {
        $(".menu").slideToggle("slow", function () {
            $(".hamburger").hide();
            $(".cross").show();
        });
    });

    $(".cross").click(function () {
        $(".menu").slideToggle("slow", function () {
            $(".cross").hide();
            $(".hamburger").show();
        });
    });

});

//funzione per menù a tendina

$(document).ready(function () {

    $('#nav li').hover(
        function () {
            //mostra sottomenu
            $('ul', this).stop(true, true).delay(50).slideDown(100);

        },
        function () {
            //nascondi sottomenu
            $('ul', this).stop(true, true).slideUp(200);
        }
    );


});
 