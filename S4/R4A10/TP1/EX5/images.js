function move_img(event) {
    if (event.buttons == 1) {
        let img = event.target;

        let x = +img.style.left.split('px')[0];
        let y = +img.style.top.split('px')[0];
        
        img.style.left ="" + (x + event.movementX) + "px";
        img.style.top ="" + (y + event.movementY) + "px";

    }
}

document.addEventListener("DOMContentLoaded", (event) => {
    let cadre1 = document.getElementById("cadre1");
    let cadre2 = document.getElementById("cadre2");
    let cadre3 = document.getElementById("cadre3");
    let cadre4 = document.getElementById("cadre4");

    cadre1.addEventListener("mousemove", move_img);
    cadre2.addEventListener("mousemove", move_img);
    cadre3.addEventListener("mousemove", move_img);
    cadre4.addEventListener("mousemove", move_img);
})