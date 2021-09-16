
export default{
      // 게시판
      boards: [],
      board: null,
      // 리뷰
      reviews: [],
      review: null,      
//========= Rules =========//
userIdRules: [
      v => !!v || '아이디를 입력해주세요.',
      v => /^[a-zA-Z0-9]*$/.test(v) || '아이디는 영문+숫자만 입력 가능합니다.',
      v => !( v && v.length >= 15) || '아이디는 15자 이상 입력할 수 없습니다.',
],
passwordRules: [
      v => !!v || '비밀번호를 입력해주세요.',
      v => !(v && v.length >= 20) || '패스워드는 20자 이상 입력할 수 없습니다.',
],
nameRules: [
      v => !!v || '이름을 작성해주세요.',
      v => !/[~!@#$%^&*()_+<>?:{}]/.test(v) || '이름에는 특수문자를 입력할 수 없습니다.',
],
phoneNumberRules: [
      v => !!v || '핸드폰 번호를 입력해주세요.',
      v => /^[0-9]*$/.test(v) || '숫자만 입력 가능합니다.',
],
emailRules: [
      v => !!v || '이메일 형식으로 작성해주세요.',
      v => /.+@.+\..+/.test(v) || '이메일 형식으로 작성해주세요.',
],
dateOfBirthRules: [
      v => !!v || '생년월일을 입력해주세요.',
      v => /^[0-9]*$/.test(v) || '숫자만 입력 가능합니다.',
],
//============================//
    // 크롤링
    lists: [],
    //세션
    session: [],

isLogin: false,
isLoginError: true,

}