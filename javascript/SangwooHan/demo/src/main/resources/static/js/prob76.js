var state = 1;
function toggleButton (){
    var list = document.querySelectorAll('#vueapp p');

    
        for(var i = 0; i< list.length; i++){
           // state 값이 0이면 짝수 번째, 1이면 홀수번째
           // 루프전체는 6개
           // 1의경우엔 1 3 5
           //0의경우엔  0 2 4

            if (!((i + state)% 2)){
                list[i].style.visibility = "visible";

            }else{
            list[i].style.visibility = "hidden";

            }
        }

    if (state ==1){
        state = 0;
    }else{
        state =1;
    }
        
}
   
