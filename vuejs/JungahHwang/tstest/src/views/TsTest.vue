<template>
  <div class="home">
    <p>TypeScript Test Component</p>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

// boolean
let test = true
let fruit: boolean = test
console.log('TypeScript fruit: ', fruit)
console.log('typeof(fruit): ', typeof(fruit))

// number
let num = 10
let tsNumber: number = num
console.log('TypeScript tsNumber: ', tsNumber)
console.log('typeof(tsNumber): ', typeof(tsNumber))

// string
let str = '타입스크립트'
let tsString: string = str
console.log('TypeScript tsString: ', tsString)
console.log('typeof(tsString): ', typeof(tsString))

// any: 어떤 타입이던 상관없음
let shape: any = str
console.log('TypeScript shape: ', shape)
console.log('typeof(shape): ', typeof(shape))

// string array
let colors: string[] = ['red', 'green', 'blue']
console.log('TypeScript colors: ', colors)
console.log('typeof(colors): ', typeof(colors))

// number array
let numArr: number[] = [2, 0.6, 88]
console.log('TypeScript numArr: ', numArr)
console.log('typeof(numArr): ', typeof(numArr))

// methode: 메서드명 옆에 리턴타입 명시
function disp(): void {
  console.log('function disp() return void')
}
disp()

function add(n1: number, n2: number): number {
  return n1 + n2
}
console.log('3 + 7 = ', add(3, 7))

// class
class TsObj {
  // 변수
  public name = 'tsObj'

  // 생성자
  constructor () {
    console.log('TsObj 생성자')
  }

  // 메서드
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
tsObj.setName('타입스크립트')
tsObj.disp()

class TsObj2 {
  private name = 'TsObj'

  constructor () {
    console.log('TsObj2 생성자')
  }

  get tsname(): string {
    return this.name
  }
  set tsname(name: string) {
    this.name = name
  }
  allocName(name: string) {
    this.name = name
  }
  disp () {
    console.log(this.name)
  }
}
let tsObj2 = new TsObj2()
tsObj2.disp()
tsObj2.allocName('private 적용')

abstract class AbstractObj {
  protected name = '추상클래스'

  constructor () {
    console.log('name: ', this.name)
  }
  getName(): string {
    return this.name
  }
  setName(name: string): void {
    this.name = name
  }
}

class AbstractObjImpl extends AbstractObj {
  constructor () {
    super()
  }

  display () {
    console.log('추상클래스에 추가한 display()')
  }
}

let aoi = new AbstractObjImpl()
aoi.display()
aoi.setName('자바랑 똑같넹')
console.log(aoi.getName())

@Component({
  components: {
  },
  mounted() {
    // object
    let obj = {
      name: 'TypeScript',
      price: 80000
    }
    // 첫 번째는 스트링 값, 키이고 두 번째는 밸류값
    let tsObject: Record<string, unknown> = obj
    console.log('TypeScript tsObject: ', tsObject)
    console.log('typeof(tsObject): ', typeof(tsObject))
  }
})
export default class Home extends Vue {}
</script>