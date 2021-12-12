module.exports = {
  devServer: {
    proxy: 'http://openapi.data.go.kr'
  },
  transpileDependencies: [
    'vuetify'
  ]
}
