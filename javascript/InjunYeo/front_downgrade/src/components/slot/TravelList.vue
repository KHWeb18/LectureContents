<template>
    <div>
        <p>
            <input v-model="inputFilter"/>
        </p>

        <!--자식 컴포넌트 -> 부모컴포넌트로 데이터전달-->
        <slot :childitems="childitems"/>
        <!-- 부모 컴포넌트 -> 자식컴포넌트 맵핑부분 -->
        <slot :itemk="filteredList"/>
    </div>
</template>

<script>

export default {
    props: ["items"],
    data(){
        return {
            inputFilter: "",
            childitems: ['one', 'two', 'three']
        }
    },
    computed: {
        filteredList() {
            if(this.items){
                //기본적으로 자바스크립트에서는 필터를 사용할때 배열의 요소 하나하나를 순회하도록 자동화처리가 수행된다.
                return this.items.filter(item => item.includes(this.inputFilter))
            }
            
            return null;
        }
    }    

}
</script>