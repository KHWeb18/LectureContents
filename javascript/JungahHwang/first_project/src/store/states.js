export default {
  idRules: [
    id => !!id || '아이디를 입력해주세요!'
  ],
  pwRules: [
    pw => !!pw || '비밀번호를 입력해주세요!',
  ],
  matchPwRules: [
    mpw => !!mpw || '비밀번호를 입력해주세요!',
  ],
  nameRules: [
    name => !!name || '이름을 입력해주세요!'
  ],
  birthRules: [
    birth => !!birth || '생일을 입력해주세요!'
  ],
  genderRules: [
    gender => !!gender || '성별을 입력해주세요!'
  ],
  emailRules: [
    email => !!email || '이메일을 입력해주세요!'
  ],
  phoneRules: [
    phone => !!phone || '전화번호를 입력해주세요!'
  ],
  addrRules: [
    addr => !!addr || '주소를 입력해주세요!'
  ],

}