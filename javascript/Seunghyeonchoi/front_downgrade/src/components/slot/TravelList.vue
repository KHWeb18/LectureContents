<template>
    <div>
        <p>
            <input v-model="inputFilter"/>
        </p>
        <!-- 자식컴포넌트 -> 부모 컴포넌트로 데이터 전달 -->
        <slot :childitems="childitems"/>
        <slot :items="filteredList"/>
    </div>
</template>

<script>

export default {
        //props : 부모 컴포넌트에서 자료를 가져올 때 사용
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
                // return this.items.filter(item => item.includes(this.inputFilter))
                return this.items.filter(item => item.length > 4)//5개 이상만 나오게 필터 건 거
        }

        return null;
        }
    }
}

</script>