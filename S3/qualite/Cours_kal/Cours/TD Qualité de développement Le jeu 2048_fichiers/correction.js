function display_correction(my_id) {
  var x = document.getElementById(my_id);
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}