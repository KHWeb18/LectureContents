<template>
    <div>
        <p>
            <input v-model="inputFilter"/>
        </p>
        <!-- 자식 컴포넌트 -> 부모 컴포넌트로 데이터 전달 -->
        <slot :childitems="childitems"/>

        <!--부모 컴포넌트 -> 자식 컴포넌트로 데이터 전달 -->
        <slot :items="filteredList"/>
    </div>
</template>

<script>
export default {
    props: ["items"],
    data () {
        return {
            inputFilter: "",
            childitems: ['one', 'two', 'three']
        }
    },
    computed: {
        filteredList () {
            if (this.items) {
                return this.items.filter(item => item.includes(this.inputFilter))
            }
            return null
        }
    }
}
</script>