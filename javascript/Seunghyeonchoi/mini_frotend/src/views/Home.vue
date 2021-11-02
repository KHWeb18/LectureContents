<template>
    <div class="home">
        <div id="header">
            <router-link :to="{ name: 'Home' }"
                    class="nav-link"
                    active-class="active">
                Home
            </router-link>  
            <router-link :to="{ name: 'NoticeBoardListPage' }"
                    class="nav-link"
                    active-class="active">
                NoticeBoard
            </router-link>
            <router-link :to="{ name: 'VuetifyAllOneTestPage' }"
                    class="nav-link"
                    active-class="active">
                Vuetify 활용
            </router-link>
            <router-link :to="{ name: 'MainPage' }"
                    class="nav-link"
                    active-class="active">
                MainPage
            </router-link>
            
        </div>
    </div>
</template>

<script>
export default {
    name: 'Home'
}

</script>