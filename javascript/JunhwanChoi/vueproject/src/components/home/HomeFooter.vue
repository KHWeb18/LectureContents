<template>
    <div>
        <div id="footer">

        <router-link :to="{name:'MemberListPage'}">
                <div class="listpage">list page</div>
        </router-link>
          
        </div>
    </div>

</template>

<script>
export default {
    name: 'HomeFooter',
}
</script>


<style>
    .listpage{
        margin-top: 100px;
        text-align: center;
        color : white;
    }
    
</style>



