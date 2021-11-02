<template>
    <div>
        <p>
            <input v-model="inputFilter"/>
        </p>
        <!-- ★자식 컴포넌트 -> 부모 컴포넌트로 데이터 전달 -->
        <slot :childitems="childitems"/>
        <!-- ★부모 컴포너늩 -> 자식 컴포넌트 맵핑 부분 -->
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

            // 요약 : item-this.inputFilter를 includes(포함) 하게될 경우만 filter(출력,걸러내기) 하므로 cities를 그대로 출력하게 된다.
            // (items=inputFilter)?

            // items가 존재하면은 filter처리를 한다. (filter의 기능은 조건이 만족되는 녀석들만 살림)
            // 즉 inputFilter에 있는 것을 전부 세팅하라라는 의미.
            // 하지만 아무것도 없으니 그대로 세팅(5개-cities의 정보가 모두 참이므로 걸러지는것이 없이 모두 출력된다.)
            // =>(에로우)는 맵핑(할당)한다는 의미.
            if (this.items) {                
            // items는 알겠는데 item은 뭐지?
            // 기본적으로 javascript에서는 filter()를 사용할 때
            // 배열의 요소 하나하나를 순회하도록 자동화처리가 수행된다.        
            return this.items.filter(item => item.includes(this.inputFilter))
            }

            return null
        }
    }
}
</script>