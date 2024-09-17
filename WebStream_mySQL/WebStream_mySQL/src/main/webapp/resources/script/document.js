
// Accordion
var headers = document.querySelectorAll('.accordion-list .accordion-head');

for(var i = 0; i < headers.length; i++) {
    openCurrAccordion(  headers[i]);
}

//Use this as the callback if you would like multiple dropdowns to be open
function openAccordion(e) {
    var parent = this.parentElement;
    var article = this.nextElementSibling;

    if (!parent.classList.contains('open')) {
        parent.classList.add('open');
        article.style.maxHeight = article.scrollHeight + 'px';
    }
    else {
        parent.classList.remove('open');
        article.style.maxHeight = '0px';
    }
}


//Use this as the callback if you would like no more than one dropdown to be open
function openCurrAccordion(e) {
    for(var i = 0; i < headers.length; i++) {
        var parent = headers[i].parentElement;
        var article = headers[i].nextElementSibling;

        parent.classList.add('open');
        article.style.maxHeight = article.scrollHeight + 'px';
        article.style.display="contents"

    }
}

$(document).ready(function() {
    $('.js-example-basic-multiple').select2({
        placeholder: 'Select an option.'
    });
});
