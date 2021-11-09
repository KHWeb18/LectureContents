<template>
    <div>
        <p>
            <input v-model="inputFilter"/>
        </p>
        <!-- 자식 컴포넌트 -> 부모 컴포넌트로 데이터 전달 --> 
        <slot :childitems="childitems"/>
        <!-- 부모 컴포넌트 ->자식 컴포넌트 맵핑 부분-->
        <slot :items="filteredList"/>
    </div>
</template>

<script>

export default {
    props: ["items"],
    data(){
        return{
            inputFilter: "",
            childitems: ['one','two', 'three']
        }
    },
    computed:{
        filteredList(){
            if(this.items){
                // filter() 메서드는 주어진 함수의 테스트를 통과하는 모든 요소를 모아 새로운 배열로 반환합니다.(조건이 만족되는놈만 살림)
                // '=>' 뜻은 맵핑(할당)
                // items는 알겠는데 item은 뭐지 ?
                // 기본적으로 javascript에서는 filter()를 사용할때
                // 배열의 요소 하나하나를 순회하도록 자동화처리가 수행된다.
                // inputfilter 는 공백이 나옴 처음  
                // test 맵핑 하는 것 
                // fliter 모두 참이기 때문에 모두 참이기 때문에 걸러지지 않는다.
                //return this.items.filter(item => item.includes(this.inputFilter))
                return this.items.filter(item => item.length > 5) //5글자 이상만 필터
            }
            return null
        }
        
    }
    
}
</script>