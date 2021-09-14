<template>
    <div>
        <v-toolbar dense dark>
            <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
                <v-icon>dehaze</v-icon>
            </v-app-bar-nav-icon>
            <v-toolbar-title>
                <span class="font-weight-light" style="margin-right: 40px;">NAVI</span>
            </v-toolbar-title>

            <v-toolbar-items v-if="!isLoggedIn">
                <v-btn text v-for="link in links" :key="link.name" :to="link.route" style="padding-top: 15px;" class="btn-flat waves-effect waves-red">
                    <login-dialogue v-if="link.text == 'LOG IN'"></login-dialogue>
                    <p v-else class="topBarText">{{ link.text }}</p>
                </v-btn>
            </v-toolbar-items>

            <v-toolbar-items v-if="isLoggedIn && userIdentity == 'individual'">
                <v-btn text v-for="loggedInlink in loggedInlinks" :key="loggedInlink.name" router :to="loggedInlink.route" style="padding-top: 15px;" class="btn-flat waves-effect waves-red">
                    <p class="topBarText" @click="logOut($event)">{{ loggedInlink.text }}</p>
                </v-btn>
            </v-toolbar-items>

            <v-toolbar-items v-else-if="isLoggedIn && userIdentity == 'admin'">
                <v-btn text v-for="managerLink in managerLinks" :key="managerLink.name" router :to="managerLink.route" style="padding-top: 15px;" class="btn-flat waves-effect waves-red">
                    <p class="topBarText" @click="logOut($event)">{{ managerLink.text }}</p>
                </v-btn>
            </v-toolbar-items>

            <v-toolbar-items v-else-if="isLoggedIn && userIdentity == 'artist'">
                <v-btn text v-for="artistLink in artistLinks" :key="artistLink.name" router :to="artistLink.route" style="padding-top: 15px;" class="btn-flat waves-effect waves-red">
                    <p class="topBarText" @click="logOut($event)">{{ artistLink.text }}</p>
                </v-btn>
            </v-toolbar-items>

            <div class="flex-grow-1"></div> <!-- 간격 벌리기 -->

            <v-toolbar-items>
            
                <v-icon class="material-icons small teal-text">search</v-icon>
                <input type="text" style="font-size: 13px; font-style: italic; width: 250px;" v-model="searchTest" v-on:click="blankText"/>
                <p class="btn-flat topBarText" style="padding-top: 5px;">&copy; MUSIC GHUETTO</p>
           
            </v-toolbar-items>

        </v-toolbar>

        <v-navigation-drawer v-model="nav_drawer" app temporary width="150px">
            <v-list nav>
                <v-list-item-group active-class="red--text text--accent-4">

                    <div v-if="isLoggedIn">
                        <v-list-item-avatar style="margin-left: 35%;">
                            <v-img src="@/assets/img/Net Gala2.jpg"></v-img>
                        </v-list-item-avatar>

                        <v-list-item-title style="text-align: center; font-size: 12px; line-height: 20px; margin-bottom: 10px;">
                            로그인된 ID:<br/>{{ userProfile.id }}
                        </v-list-item-title>
                    </div>

                    <div v-if="!isLoggedIn">
                        <v-list-item-avatar style="margin-left: 35%;">
                            <v-img src="@/assets/img/background.jpg"></v-img>
                        </v-list-item-avatar>

                        <v-list-item-title style="text-align: center; font-size: 10px; line-height: 20px; margin-bottom: 10px;">
                            로그인된 ID:<br/>아직 로그인되지 않았습니다.
                        </v-list-item-title>
                    </div>

                    <div v-if="userIdentity == 'artist'"> 
                        <v-list-item v-for="(link, index) in navLinksForArtist" :key="index" router :to="link.route" @click="btn_needSession(index)">
                            <v-list-item-action>
                                <v-icon>{{ link. icon }}</v-icon>
                            </v-list-item-action>
                            <v-list-item-content>
                                {{ link.text }}
                            </v-list-item-content>
                        </v-list-item>
                    </div>

                    <div v-else-if="userIdentity != 'artist'"> 
                        <v-list-item v-for="(link, index) in navLinks" :key="index" router :to="link.route" @click="btn_needSession(index)">
                            <v-list-item-action>
                                <v-icon>{{ link. icon }}</v-icon>
                            </v-list-item-action>
                            <v-list-item-content>
                                {{ link.text }}
                            </v-list-item-content>
                        </v-list-item>
                    </div>
                    
                </v-list-item-group>
            </v-list>
        </v-navigation-drawer>
    </div>
</template>

<script>
import cookies from 'vue-cookies'
import Vue from 'vue'
Vue.use(cookies)

import axios from 'axios'
import { mapState } from 'vuex'
import LoginDialogue from '@/components/concertMainDialogue/LoginDialogue'

export default {
    name: 'ConcertToolBar',
    components: {
        LoginDialogue
    },
    computed: {
        ...mapState(['isLoggedIn', 'userIdentity', 'userProfile'])
    },
    data() {
        return {
            nav_drawer: false,
            searchTest: '  찾고자 하는 장르 또는 아티스트',
            links: [
                {
                    text: 'ABOUT US',
                    icon: 'people',
                    route: '/aboutUsPage',
                },
                {
                    text: 'LOG IN',
                    icon: '/people'
                },
                {
                    text: 'SIGN UP',
                    icon: 'people',
                    route: '/signupPage',
                },
                {
                    text: 'SUPPORT',
                    icon: 'people',
                    route: '/preferenceFillInPage',
                },
                {
                    text: 'COMMUNITY',
                    icon: 'people',
                    route: '/Community',
                },
                {
                    text: 'MORE',
                    icon: 'people',
                    route: '/indieNewsCrawlerPage',
                }
            ],
            loggedInlinks: [
                {
                    text: 'LOG OUT',
                    icon: ''           
                },
                {
                    text: 'ABOUT US',
                    icon: 'people',
                    route: '/aboutUsPage',
                },
                {
                    text: 'SUPPORT',
                    icon: 'people',
                    route: '/preferenceFillInPage',
                },
                {
                    text: 'COMMUNITY',
                    icon: 'people',
                    route: '/Community',
                },
                {
                    text: 'MORE',
                    icon: 'people',
                    route: '/indieNewsCrawlerPage',
                }
            ],
            managerLinks: [
                {
                    text: 'LOG OUT',
                    icon: '',
                },
                {
                    text: 'ABOUT US',
                    icon: 'people',
                    route: '/aboutUsPage',
                },
                {
                    text: 'REQUEST STORE', 
                    icon: 'people',
                    route: '/requestStorePage', 
                },
                {
                    text: 'COMMUNITY',
                    icon: 'people',
                    route: '/Community',
                },
                {
                    text: 'ADMIN',
                    icon: 'people',
                    route: '/memberListPage',
                }
            ],
            artistLinks: [
                {
                    text: 'LOG OUT',
                    icon: '',
                },
                {
                    text: 'ABOUT US',
                    icon: 'people',
                    route: '/aboutUsPage',
                },
                {
                    text: 'SUPPORT',
                    icon: 'people',
                    route: '/preferenceFillInPage',
                },
                {
                    text: 'COMMUNITY',
                    icon: 'people',
                    route: '/Community',
                },
                {
                    text: 'ConcertReg',
                    icon: 'people',
                    route: '/registerRequestPage',
                }
            ],
            navLinks: [
                { text: 'Home', icon: 'home'},
                { text: 'Profile', icon: 'person_outline'},
                { text: 'Liked', icon: 'star'},
                { text: 'Booked', icon: 'done'}
            ],
            navLinksForArtist: [
                { text: 'Home', icon: 'home'},
                { text: 'Profile', icon: 'person_outline'},
                { text: 'Liked', icon: 'star'},
                { text: 'Booked', icon: 'done'},
                { text: 'Request', icon: 'email'}
            ],
        }
    },
    methods: {
        blankText() {
            this.searchTest = ''
        },
        logOut($event) {
            if($event.target.innerHTML == 'LOG OUT') {
                
                this.$cookies.remove("currentUser")
                
                this.$store.state.isLoggedIn = false
                this.$store.state.userProfile = null
                this.$store.state.userIdentity = null

                alert('로그아웃되었습니다.')

                this.$router.push ({
                    name: 'MainPage'
                })
            }
        },
        btn_needSession(index) {
            if(index == 0) {
                this.$router.push ({
                    name: 'MainPage'
                })
            } else if(this.$store.state.isLoggedIn == true) {
              
                    axios.post('http://localhost:8888/member/needSession')
                    .then(res => {
                        if(res.data == true && index == 1) {
                            this.$router.push ({
                                name: 'MyProfilePage'
                            })
                        } else if(res.data == true && index == 2) {
                            this.$router.push ({
                                name: 'LikedListPage'
                            })
                        } else if(res.data == true && index == 3) {
                            this.$router.push ({
                                name: 'BookedListPage'
                            })
                        } else if(res.data == true && index == 4) {
                            this.$router.push ({
                                name: 'MyRequestListPage'
                            })
                        } else if(res.data == false) {
                            alert('세션 정보가 만료되었습니다. 다시 로그인해주세요!')
                            this.$store.state.isLoggedIn = false

                            this.$cookies.remove("currentUser")
                            this.$store.state.userProfile = null
                            this.$store.state.userIdentity = null
                        }
                    })
                
            } else if(index != 0) {
                alert('로그인이 필요한 서비스입니다!')
            }
        }
    }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@1,900&display=swap');

.topBarText {
    font-style: italic;
    margin-right: 25px;
    color: white;
}
</style>
        

