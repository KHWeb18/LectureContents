<template>
    <div><br><br>
        <ul class="icons">
          <li>
            <div class="tablemargin">
                 <v-card elevation="5">
                     <ul>
                         <li>
                            <v-simple-table>
                                <template>
                                    <thead>
                                        <tr>
                                            <th class="text-left">
                                                <h5>코로나 뉴스  <a @click="newsLink()">+더보기</a></h5>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr v-for="(list,idx) in lists" :key="idx" width="50px">
                                            <div v-show="(idx<5)">
                                                <td style="color: gray" class="tdmargin">{{ list.newsNo }}</td>
                                                <td @click="clickNews(list.address)">{{ list.title }}</td>
                                            </div>
                                        </tr> 
                                    </tbody>
                                </template>
                             </v-simple-table>
                         </li>
                     </ul>  
                 </v-card>
            </div>
            
            
          </li>

          <li>
            <div class="video-container">
                <iframe  src="https://www.youtube.com/embed/24jc8mnov9k" 
                frameborder="2" allow="accelerometer; autoplay; encrypted-midea; gyroscope; picture-in-picture" allowfullscreen>
                </iframe>
            </div>
          </li>

          
        </ul>
    </div>
</template>

<script>
//import Layout from '@/components/layout/Layout'
import { mapState } from 'vuex'
export default {
    data(){
        return {
           
        }
    },
    created(){
        this.$store.dispatch('crawlFind', 'daumnews')

    },

    components: {
       // Layout
    },
    computed: {
        ...mapState ({
            lists: state => state.lists
        })
    },
    methods: {
        clickNews(address){
            window.open(address, 'newslink', 'width: 200px, height: 200px')
        },
        newsLink(){
            this.$router.push({name:'InfoNews'})    
        }

    }
    
}
</script>

<style scoped>

 a{
     margin-left: 30px;
     margin-top: 30px;
     font-size: 13px;
 }
 .intro_bg{
  width: 100%;
  height: 360px;
}
.responsive-img{
    width: 100%;
    height: 100%;
}  

.contents1{
  font-size: 20px;
  font-weight: lighter;
  margin-top:-13px;
}

.contents2{
  font-size: 18px;
}
.contents3 {
  font-size: 14px;
  font-weight: 100;
}
.contents1_bold{
  font-size: 18px;
  font-weight: bold;
}

.result{
  font-size: 24px;
}

.amount{
  position: relative;
  top:-60px;
  display: flex;
  width:1200px;
  background: white;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
  margin: 0px auto;
  text-align: center;

}
.amount > li {
  flex: 1;
  height: 130px;
}
.amount > li > div {
  margin-top:37px;
  height:57px;
}

.amount > li:not(:last-child) > div{
  border-right:1px solid #E1E1E1;
}


.icons{
  display: flex;
  width:1200px;
  height: 302px;
  margin:auto;
}
.icons > li {
  flex: 1;
  background: #dcdcdc;
  margin-top:49px;
  height:302px;
  text-align: center;
  border-radius: 10px;
}
.icons > li > .icon_img{
  margin-top:40px;
}

.icons > li:not(:last-child){
  margin-right: 20px;
}

.icons .contents2 {
  width:280px;
  margin:auto;
  letter-spacing: -1px;
}

.more{
  width:100px;
  height: 30px;
  background: #2F7AF4;
  color: #fff;
  font-size: 12px;
  line-height: 30px;
  margin:25px auto;
}


</style>