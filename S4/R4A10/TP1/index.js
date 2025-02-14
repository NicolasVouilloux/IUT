let aside = document.getElementById("asideIndex");
let asideButton = document.getElementById("asideButton");


function rajoute_un_clic()
{
    if (asideButton.innerText === "Hello !"){
        asideButton.innerText = "Bien ou quoi ?"
        alert("OUI TA CLICKER SUR MOOI")
    }
    else alert("PLUS JAMAIS TU ME CLICK DESSUS T FOU ?")
}

function rajoute_un_clic_alt(that)
{
    if (that.innerText === "Hello !"){
        that.innerText = "Bien ou quoi ?"
        alert("OUI TA CLICKER SUR MOOI")
    }
    else alert("PLUS JAMAIS TU ME CLICK DESSUS T FOU ?")
}