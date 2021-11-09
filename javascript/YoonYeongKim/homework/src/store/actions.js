import {
    FETCH_PRODUCT_LIST,
    FETCH_PRODUCT
} from './mutation-types'

import axios from 'axios'

export default {
    // 상품
    fetchProductList ({ commit }) {
        return axios.get('http://localhost:7777/vueproduct/lists')
                .then((res) => {
                    commit(FETCH_PRODUCT_LIST, res.data)
                })
    },
    fetchProduct ({ commit }, productNo) {
        return axios.get(`http://localhost:7777/vueproduct/${productNo}`)
                .then((res) => {
                    commit(FETCH_PRODUCT, res.data)
                })
    }        
}