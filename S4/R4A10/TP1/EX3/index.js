
document.addEventListener("DOMContentLoaded", (event) => {
    let tableau = document.querySelector('table')
    let tkt = tableau.addEventListener('click',change_couleur)
}) 


function change_couleur(event)
{
    let color = event.target.innerText
    let docText = document.querySelectorAll('p')
    docText.forEach((element)=>{
        element.style.color = color
    })
}

function rajoute_un_deux_couleurs(){
     let couleur1 = document.getElementById("ColorSelect1").value;
     let couleur2 = document.getElementById("ColorSelect2").value;
 
     let newRow = document.createElement("tr");
 
     let cell1 = document.createElement("td");
     cell1.style.backgroundColor = couleur1;
     cell1.textContent = couleur1;
 
     let cell2 = document.createElement("td");
     cell2.style.backgroundColor = couleur2;
     cell2.textContent = couleur2;
 
     newRow.appendChild(cell1);
     newRow.appendChild(cell2);
 
     document.querySelector("tbody").appendChild(newRow);
}
