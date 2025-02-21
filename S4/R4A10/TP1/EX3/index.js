
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

