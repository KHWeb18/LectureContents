<template>
    <div class="home">
        <div id="header">
            <router-link :to="{ name: 'Home' }"
                    class="nav-link"
                    active-class="active">
                Home
            </router-link>
            <router-link :to="{ name: 'Test' }"
                    class="nav-link"
                    active-class="active">
                Test
            </router-link>
            <router-link :to="{ name: 'Game' }"
                    class="nav-link"
                    active-class="active">
                Game
            </router-link>
        </div>
        <!--
        <div id="register">
        <router-link :to={"name:'GameRegister'}">
            
        </router-link>
        
        </div>-->
    </div>

</template>
<template>
</template>
<script>

export default {
    name:'Game',
    data(){
        return{
            
        }
    }
    
}
</script>