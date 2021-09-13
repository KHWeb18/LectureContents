export default {
    concert: null,
    //likedList: [0, 0, 0, 0], 필요 없음

    members: [],
    member: null,

    isLoggedIn: false,
    loggedInID: '',
    userIdentity: '',
    userProfile: [],

    newsList: [],

    likedList: [],
    notLikedYet: false, //해당 ConcertDetailPage의 공연이 이 멤버에게 찜된건지 아닌지를 판별해서 찜하기, 취소 버튼 구별

    boards: [],
    board: null,

    replyList: [],

    notDecidedYet: false,

    taste: null,

    userName: '',

    concertRequestList: [],
    concertRequest: null,

    myRequestList: []
}