<template>
    <div class="container">
        <div class="row">
            <div class="col s2 m2 l2 xl2 red">
                column 2
            </div>

            <div class="col s4 m4 l4 xl4 blue">
                column 4
            </div>

            <div class="col s6 m6 l6 xl6 green">
                column 6
            </div>

            <div class="col xs12 md12 lg12 xl12 teal">
                column 12
            </div>
        </div>

        <div class="row">
            <a class="btn-flat waves-effect waves-green pink" @click="showMessage">
                Wi-Fi ON
            </a>
            <!-- a로 감싸는거랑 그냥 i랑 차이?? -->
            <a class="btn-flat waves-effect waves-teal" @click="showMessage($event)">
                <i class="material-icons right">cloud</i>
            </a>
            <a class="btn-floating waves-effect waves-red" @click="showMessage($event)">
                <i class="material-icons left">wifi</i>
                
            </a>
        </div>
        
    </div>
</template>

<script>
export default {
    name: 'MaterializeGridTestPage',
    methods: {
        showMessage($event) {
            alert($event.target.innerHTML + ' 버튼이닷!')
        }
    }
}
</script>