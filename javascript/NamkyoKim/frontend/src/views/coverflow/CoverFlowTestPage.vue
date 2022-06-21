<template>
      <coverflow :coverList="coverList" :coverWidth="200" :index="2"></coverflow>
</template>

<script>

import  coverflow  from 'vue-coverflow'

export default {
    name: 'CoverFlowTestPage',
    data () {
        return {
                coverList: [
                    {
                        cover: 'https://ww.namu.la/s/d03311703f8dc40b9e2934541ee7f66495842bba87fe767525bab6417983c7bcf20021064498b7a7ba41223bd4b284316616f88c77371ab6caeb319eec8f8b10aaaa497e001f26184d3eb332023312f79387db896ae7e111a9e91e5886e2e8d1df4bcb6315f6ac8330a8bb0a552e1c37',
                        title: '랭글러'
                     },
                    {
                        cover: 'https://pds.joins.com/news/component/htmlphoto_mmdata/202004/28/d74b0fc0-2026-4794-8cea-8ceda33f21ac.jpg',
                        title: 'X'
                    },
                    {
                        cover: 'http://www.autoview.co.kr/picture/review/201712052202300_1.jpg', 
                        title: '우르스'
                    },
                    {
                        cover: 'http://www.autoherald.co.kr/news/photo/202003/37363_63110_5350.png', 
                        title: 'GV80'
                     },
                     {
                        cover: 'https://cdn.top-rider.com/news/photo/202102/60679_125907_1153.jpg',
                        title: '박스터 GTS'
                     },
                    {
                        cover: 'https://pds.joins.com/news/component/htmlphoto_mmdata/202004/28/d74b0fc0-2026-4794-8cea-8ceda33f21ac.jpg',
                        title: 'X'
                    },
                    {
                        cover: 'http://www.autoview.co.kr/picture/review/201712052202300_1.jpg', 
                        title: '우르스'
                    },
                    {
                        cover: 'http://www.autoherald.co.kr/news/photo/202003/37363_63110_5350.png', 
                        title: 'GV80'
                     },
                     {
                         cover: require('@/assets/imgs/spyder.png'),
                         title: 'spyder'
                     },
                     {
                        cover: 'https://ww.namu.la/s/d03311703f8dc40b9e2934541ee7f66495842bba87fe767525bab6417983c7bcf20021064498b7a7ba41223bd4b284316616f88c77371ab6caeb319eec8f8b10aaaa497e001f26184d3eb332023312f79387db896ae7e111a9e91e5886e2e8d1df4bcb6315f6ac8330a8bb0a552e1c37',
                        title: '랭글러'
                     },
                    {
                        cover: 'https://pds.joins.com/news/component/htmlphoto_mmdata/202004/28/d74b0fc0-2026-4794-8cea-8ceda33f21ac.jpg',
                        title: 'X'
                    },
                    {
                        cover: 'http://www.autoview.co.kr/picture/review/201712052202300_1.jpg', 
                        title: '우르스'
                    },
                    {
                        cover: 'http://www.autoherald.co.kr/news/photo/202003/37363_63110_5350.png', 
                        title: 'GV80'
                     },
                     {
                        cover: 'https://cdn.top-rider.com/news/photo/202102/60679_125907_1153.jpg',
                        title: '박스터 GTS'
                     },
                    {
                        cover: 'https://pds.joins.com/news/component/htmlphoto_mmdata/202004/28/d74b0fc0-2026-4794-8cea-8ceda33f21ac.jpg',
                        title: 'X'
                    },
                    {
                        cover: 'http://www.autoview.co.kr/picture/review/201712052202300_1.jpg', 
                        title: '우르스'
                    },
                ],
        }
    },
    components: {
        coverflow
    }
}
</script>