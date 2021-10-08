<!--- table, tr, th, td, thead, tbody, tfoot 등을 사용하여 화면을 구현한다. -->
<template>
    <v-container>        
        <table class="tb" border="3" width="50%" height="200" cellspacing="4">
                <caption class="caption" >kh 리조트 대관 안내</caption>
                <thead class="thead">
                    <tr>                        
                        <th class="thead-th">층</th>
                        <th class="thead-th">객실명</th>
                        <th class="thead-th">정원</th>
                        <th class="thead-th">가격</th>
                    </tr>
                </thead>

                <tbody class="tbody">
                    <tr>
                        <td rowspan="6">2층</td>
                        <td rowspan="2">사랑방</td>
                        <td rowspan="2">4명</td>    
                        <td>평일 : 300,000원 <button class="button">예약하기</button>  </td>                                   
                    </tr>  
                    <tr>                        
                        <td>주말 : 500,000원 <button class="button">예약하기</button>  </td>
                    </tr>
                    <tr>
                        <td rowspan="2">행복방</td>
                        <td rowspan="2">6명</td>   
                        <td>평일 : 400,000원 <button class="button">예약하기</button>  </td>
                    </tr>   
                    <tr>                        
                        <td>주말 : 600,000원 <button class="button">예약하기</button>  </td>
                    </tr>
                    <tr>
                        <td rowspan="2">코딩방</td>
                        <td rowspan="2">무제한</td>                        
                        <td>평일 : 800,000원 <button class="button">예약하기</button>  </td>
                    </tr> 
                    <tr>                        
                        <td>주말 : 90,000원 <button class="button">예약하기</button>  </td>
                        
                    </tr>
                    <tr class="bottom">
                        <td class="bottom-text" colspan="4">코딩방 예약시 커피 무제한 무료 증정!!</td>
                    </tr>
                                 
                </tbody>
            </table>
        <table>
            <h2>HTML Table</h2>
            <tr>
                <th>이름</th>
                <th>나이</th>
                <th>성별</th>
            </tr>
            <tr>
                <td>홍길동</td>
                <td>39</td>
                <td>남</td>
            </tr>
            <tr>
                <td>신사임당</td>
                <td>59</td>
                <td>남</td>
            </tr>
            <tr>
                <td>이순신</td>
                <td>55</td>
                <td>남</td>
            </tr>
        </table>
        <h2>HTML List</h2>
        <ul>
            <li>html</li>
            <li>css</li>
            <li>javascript</li>
            <li>jquery</li>
        </ul>
    </v-container> 

    
</template>

<style scoped>    
    .tb {
        border: 2px;
        
    }
    .thead {
        background-color: tomato;
        text-align: center;
    }
    .thead-th {
        text-align: center;
    }
    .caption {        
        color: orangered;
    }
    .tbody {
        background-color: orange;
    }
    .button {
        background-color: green;
        color: white;
    }
    .bottom {
        background-color: yellow;
        text-align: center;
        color: rgb(255, 102, 0);
    }
    .bottom-text {
        text-align: center;
    }
    
</style>