function openNav() {
    document.getElementById("sidebar").style.width = "250px";
}

function closeNav() {
    document.getElementById("sidebar").style.width = "0";
}

function changeNavbarColor() {
    var navbar = document.getElementById('transparencia');
    var scrollPosition = window.scrollY;
 
    console.log('Scroll Position:', scrollPosition);
 
    var scrollThreshold = 200;
 
    if (scrollPosition > scrollThreshold) {
       navbar.style.backgroundColor = '#0d7bbbcf';
         /*cor de trasparência*/
    } else {
       navbar.style.backgroundColor = '#0d7bbb';
       /*cor padrão*/ 
    }
 }
 
 window.addEventListener('scroll', changeNavbarColor);
 