var state = 1;



function toggleButton () {
   var list = document.querySelectorAll("#vueapp p")
  
   for(var i = 0; i < list.length; i++){
       //state값이 0이면 짝수 번째, 1이면 홀수 번째
      
           if(!((i+state) % 2)) {
            list[i].style.visibility = "visible";
           } else {
           list[i].style.visibility = "hidden";
       }
   }

   if(state == 1) {
       state = 0;
   }else {
       state = 1;
   }
  
  
}
