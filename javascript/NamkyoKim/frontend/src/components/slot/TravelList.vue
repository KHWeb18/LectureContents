<template>
    <div>
        <p>
            <input v-model="inputFilter"/>
        </p>
        <!-- 자식 컴포넌트 -> 부모 컴포넌트로 데이터 전달 -->
        <slot :childitems="childitems"/>
        <!-- 부모 컴포넌트 -> 자식컴포넌트 맵핑 부분 -->
        <slot :items="filteredList"/>
    </div>
</template>


<script>
export default {
    props: ["items"],
    data(){
        return {
            inputFilter: '',
            childitems: ['one','two','three']
        }
    },
    computed: {
        filteredList() {
            if(this.items){
                // items는 알겠는데 item은 뭐지>?
                // 기본적으로 javascript에서는 filter()를 사용할떄
                // 배열의 요소 하나하나를 순회하도록 자동화 처리가 수행된다.
            //return this.items.filter(item => item.includes(this.inputFilter))
            // 길이로 조건걸때는 length로 하면됨
            return this.items.filter(item => item.length >= 5)
            }
            return null
        }
    }
}
</script>