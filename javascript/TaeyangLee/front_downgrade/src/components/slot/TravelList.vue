<template>
    <div>
        <p>
            <!-- 자식 컴포넌트 -> 부모 컴포넌트로 데이터 전달-->
            <input v-model="inputFilter" />
        </p>
        <slot :childitems="childitems"/>
        <!-- 부모 컴포넌트 -> 자식컴포넌트 맵핑 부분 -->
        <slot :items="filteredList"/>
    </div>
</template>

<script>
export default {
    //부모가 자식한테 데이터를 전달할 때 프롭스를 쓴다
    props: ["items"],
    data () {
        return {
            inputFilter: "",
            childitems: ['one', 'two', 'three']
        }
    },
    computed: {
        filteredList() {
            if(this.items){
            return this.items.filter(item => item.includes(this.inputFilter))
        }
        return null
     }
    }
}
</script>