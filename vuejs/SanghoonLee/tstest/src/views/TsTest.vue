<template>
  <div class="home">
    <p>TypeScript Test Component</p>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

// TypeScript 왜 쓸까 ?
// 1) JS가 짜증나서 어떤 부분이 짜증날까 ? 타입이 개차반
// 연장선: Java - final

let test = true
let fruit: boolean = test
console.log('TypeScript fruit: ', fruit)
console.log('typeof(fruit): ', typeof(fruit))

let num = 10
let tsNumber: number = num
console.log('TypeScript tsNumber: ', tsNumber)
console.log('typeof(tsNumber): ', typeof(tsNumber))

let str = '타입스크립트'
let tsString: string = str
console.log('TypeScript tsString: ', tsString)
console.log('typeof(tsString): ', typeof(tsString))

// 어떤 타입이든 다 받는다
let shape: any = test
console.log('TypeScript shape: ', shape)
console.log('typeof(shape): ', typeof(shape))

let colors: string[] = [ "red", "green", "blue" ]
console.log('TypeScript colors: ', colors)
console.log('typeof(colors): ', typeof(colors))

let numArr: number[] = [ 0.3, 4.7, 77 ]
console.log('TypeScript numArr: ', numArr)
console.log('typeof(numArr): ', typeof(numArr))

function disp(): void {
  console.log('function disp() return void')
}
disp()

function add(n1: number, n2: number): number {
  return n1 + n2
}
console.log('n1 + n2 = ', add(3, 7))

class TsObj {
  // 멤버 변수
  public name = "TsObj"

  // 생성자
  constructor () {
    console.log('생성자 호출!')
  }

  // 매서드
  getName(): string {
    return this.name
  }
  setName(name: string): void {
    this.name = name
  }
  disp() {
    console.log(this.name)
  }
}
let tsObj = new TsObj()
tsObj.disp()
tsObj.setName("타입스크립트")
tsObj.disp()

class TsObj2 {
  // 멤버 변수
  private name = "TsObj"

  // 생성자
  constructor () {
    console.log('생성자 호출!')
  }

  // 매서드
  get tsname(): string {
    return this.name
  }
  set tsname(name: string) {
    this.name = name
  }
  allocName(name: string) {
    this.name = name
  }
  disp() {
    console.log(this.name)
  }
}
let tsObj2 = new TsObj2()
tsObj2.disp()
//tsObj2.name = "private 적용"
tsObj2.allocName('private 적용')
tsObj2.disp()

@Component({
  components: {
  },
  mounted () {
    let obj = {
      name: "TypeScript EDDI",
      price: 7200
    }
    // 앞에는 스트링 값(키)
    // 밸류값에 해당하는것은 unknown이니
    // 맘대로 아무거나 막 집어넣으세요!
    let tsObject: Record<string, unknown> = obj
    console.log('TypeScript tsObject: ', tsObject)
    console.log('typeof(tsObject): ', typeof(tsObject))
  }
})
export default class Home extends Vue {}
</script>
