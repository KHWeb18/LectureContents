<template>
<form @submit.prevent="onSubmit">
    <div>
 <table>
     <tr>
         <td>밑변의 길이 </td>
         <td><input type="Number" v-model="rowss" /></td>
     </tr>
       <tr>
         <td>높이 </td>
         <td><input type="Number" v-model="height" /></td>
     </tr>
   
    <h3> 삼각형의 결과값{{ Area}}</h3>
 </table>
   <button type="submit" >삼각형의 넓이 구하기 </button>
</div>
</form>
  
</template>

<script>
export default {
    name: 'ProTestPage',
    
    component: {

    },
    data() {
        return {
            rowss: 0,
            hight: 0,
        }
    },
    methods: {

        onSubmit () {
                const { rowss, height} = this
                this.emit('submit', {rowss, height} )
        }
    }

}
</script>