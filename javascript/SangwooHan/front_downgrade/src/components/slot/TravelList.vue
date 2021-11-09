<template>
    <div>
        <p>
            <input v-model="inputFilter"/>
        </p>
        <slot :childitems="childitems"/>
        <slot :items="filterdList"/>
    </div>
</template>

<script>
export default {
  props: ["items"],
   
    data(){
        return{
                inputFilter: "",
                childitems: ['one','two','three']
        }
    },
    computed: {
        filterdList(){
            //items는 알겠는데 item은 뭘까?
            // 기본적으로 javascript에서 filter()를 사용하면,
            // 배열요소 하나하나를 순회하도록 자동화처리를 수행한다.
            if (this.items){
            return this.items.filter(item => item.includes(this.inputFilter))
            }
            return null
        }
    }
}
</script>