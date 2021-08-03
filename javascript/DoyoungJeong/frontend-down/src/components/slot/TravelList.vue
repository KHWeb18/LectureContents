<template>
    <div>
        <p>
            <input v-model="inputFilter"/>
        </p>
        <slot :childitems="childitems"/>
        <!-- 여기는 자식 컴퍼넌트에서 부모 컴퍼넌트로 정보를 보낸다. ':이름'은 받는곳에서의 이름 -->
        <slot :items="filteredList"/>
    </div>
</template>

<script>

export default {
    name: 'TravelList',
    props: ["items"],
    data() {
        return {
            inputFilter: 'P',
            childitems: ['one', 'two', 'three']
        }
    },
    computed: {
        filteredList() {
            if(this.items) {
                return this.items.filter(item => item.includes(this.inputFilter))
                //각 요소마다 검사해서 inputFilter가 포함되지 않는 요소들은 걸러짐
            }
            return null
        }
    }
}
</script>
