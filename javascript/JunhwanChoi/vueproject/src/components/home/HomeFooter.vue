<template>
    <div>
        <div id="footer">
           <center>
               <li>
                   <router-link :to="{ name: 'DaumNewsCrawlerPage' }">
                       <img src="../../assets/banner1.png" alt="banner1">
                   </router-link>
               </li>
               
                <li><a href="#"><img src="../../assets/banner2.png" alt="banner2"></a></li>
                <li><a href="#"><img src="../../assets/banner3.png" alt="banner3"></a></li>
                <li><a href="/reservation"><img src="../../assets/banner4.png" alt="banner4"></a></li>
           </center>
        </div>
    </div>

</template>

<script>
export default {
    name: 'HomeFooter',
}
</script>


<style>
    ul{ list-style: none;}
    a{text-decoration: none;}

    body{
        background-color: white;
        color: white;
        margin: 0;
        padding: 0;
        font-size: 1.2em;
        font-family: 'Hack';
    }
    #header{
        color:  black;
        background-color: #C8D7FF;
        padding: 15px;
    }

    #footer{
        color: black;
        background-color: #f1f1f1;
        padding: 10px;
    }


    ul{
        margin: 0;
        padding: 0;
        list-style-type: none;
        float: right;
    }

    li{
        display: inline;
        margin: 0 20px 0 0 ;
    }


    /* 전체 페이지가 가운데로 오도록 */
    #page{width: 820px; margin: 0px auto;}
    
</style>



