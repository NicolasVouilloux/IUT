"use strict";
let tableau = document.getElementById("le_tableau")

/* ------------------------------------------------------------ */
document.addEventListener("DOMContentLoaded", (event) => {
    let ptitecases = document.querySelectorAll("table tbody tr td")
    ptitecases.forEach((element)=>{
        element.addEventListener("click",onclick)
    })
})

function onclick(event){
    let ptitecase = event.target
    ptitecase.textContent = ""
    let cell1 = document.createElement("input");
    cell1.addEventListener("keyup", entrerLaValue)
    ptitecase.appendChild(cell1)

}
//tester si une string est un nombre entre 1 et 20:
const re = new RegExp('^(1?[0-9]|20)$'); 
//utilisation : 
// if( re.test( __la_string__ ) ){ /* oui */ }else{ /* non */}

function entrerLaValue(event){
    if(event.key === 'Enter'){
        let str = event.target.value
        let newcell = event.target.parentElement
        
        if( re.test(str) ){
            newcell.className = ""
            newcell.innerHTML = ""
            newcell.textContent = str
        } else{
            newcell.innerHTML = ""
            newcell.textContent ="err"
            newcell.className = "incorrecte"
            
        }
    }
}

//sur 'keyup', la touche entree se teste avec :
//  if( ev.key === 'Enter' )


// __element__.focus(); peut vous être utile

/* ------------------------------------------------------------ */
