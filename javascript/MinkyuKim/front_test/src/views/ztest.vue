<template>
    <v-container>
        <div id="header">
            <h6>Header</h6>
        </div>
        <div id="nav">
            <h6>nav</h6>
        </div>
        <div id="left">
            <h6>left</h6>
            <div id="left-left">
                a
            </div>
            <div id="left-right">
                b
            </div>
        </div>
        <div id="right">
            <h6>right</h6>
        </div>
        <div id="footer">
            <h6>Footer</h6>
        </div>
    </v-container>
   
</template>

<script>

export default {
    name: 'ztest',
    
}
</script> 

<style scoped>
    h6 {
        text-align: center;
    }
    #header {
        background-color: orange;        
        text-align: center;
        height: 100px;
    }
    #nav {
        background-color: gray;
        display: flex;
        text-align: center;
        height: 30px;
    }
    #left {
        background-color: lightgreen;
        float: left;
        text-align: center;
        width: 85%;
        height: 400px;
    }
    #right {
        background-color: blue;
        float:  left;
        text-align: center;
        width: 15%;
        height: 400px;
    }
    #footer {
        background-color: purple;
        height: 430px;
        text-align: center;
    }
    #left-left {
        background-color: pink;
        text-align: center;
        margin-left: 10px;
        width: 48.8%;
        height: 300px;
        display: inline-block;
    }
    #left-right {
        background-color: rgba(255, 187, 0, 0.986);
        text-align: center;
        display: inline-block;
        width: 48.8%;
        height: 300px;
        margin-right: 10px;
    }
</style>