"use strict";

/* ------------------------------------------------------------ */

document.addEventListener("DOMContentLoaded", (event) => {
    const input = document.getElementById("input")
    initButton()
})

function initButton(){
    let calculette = document.getElementById("nb_&_op")
    for (let i=0; i<10; i++){
        let btn = document.createElement("button");
        btn.textContent = i
        btn.addEventListener("click", numbersInput)
        calculette.appendChild(btn)
    } 

    initSign()

    let btnEquals = document.getElementById("Equals")  
    btnEquals.addEventListener("click", equals)
    let btnReset = document.getElementById("Reset")  
    btnReset.addEventListener("click", reset)
}

function initSign(){
    let btnAdd = document.createElement("button");
    btnAdd.textContent = "+"
    btnAdd.addEventListener("click", numbersInput)
    calculette.appendChild(btnAdd)

    let btnSub = document.createElement("button");
    btnSub.textContent = "-"
    btnSub.addEventListener("click", numbersInput)
    calculette.appendChild(btnSub)

    let btnDivid = document.createElement("button");
    btnDivid.textContent = "/"
    btnDivid.addEventListener("click", numbersInput)
    calculette.appendChild(btnDivid)

    let btnMult = document.createElement("button");
    btnMult.textContent = "*"
    btnMult.addEventListener("click", numbersInput)
    calculette.appendChild(btnMult)

}

function numbersInput(event){
    let val = event.target.textContent
    console.log(val)
    let actVal = input.value
    let newVal = input.value + val
    input.value = newVal
}


function equals(event){
    let calcule = input.value
    let res = eval(calcule)
    input.value= res
}


function reset(event){
    input.value=""
    console.log("reset")
}
/* ------------------------------------------------------------ */
