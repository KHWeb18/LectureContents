<template>
   
            <div class="container">

            <div class="row flex">
                
                    <div class="col s2 m2 12 x12 red" >
                    <p>column 2</p>
                    </div>
                    <div class="col s4 m4 14 x14 blue">
                   <p>column 4</p>
                    </div>
                    <div class="col s6 m6 16 x16 green">
                   <p>column 6</p>
                    </div>
                    <div class="col s12 m12 12 xl13 teal">
                   <p>column 12</p>
                    </div>
                
            </div>
            <div class="row">
                <a class="btn waves-effect waves-red blue" @click="showMessage()">
                    Wi-Fi On!
                </a>
                <a class="btn-flat waves-effect waves-teal" @click="showMessage()">
                    <i class="material-icons left">cloud</i>
                    Cloud
                </a>
                <a class="btn-floating waves-effect waves-yellow" @click="showMessage()">
                    <i class="material-icons left">wifi</i>
                    Wi-Fi
                </a>
            </div>
        </div>
 
</template>

<script>
export default {
    name: 'MaterializeGridTestPage',
    methods: {
        showMessage($event) {
            alert($event)
        }
    }
}
</script>