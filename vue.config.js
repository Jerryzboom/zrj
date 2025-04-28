const { defineConfig } = require('@vue/cli-service')
const AutoImport = require('unplugin-auto-import/webpack')
const Components = require('unplugin-vue-components/webpack')
const { ElementPlusResolver } = require('unplugin-vue-components/resolvers')
module.exports = defineConfig({
  publicPath : "/thf/",
  transpileDependencies: true,
  configureWebpack: {
    plugins: [
      AutoImport( {
        resolvers : [ElementPlusResolver()]
      }),
      Components( {
        resolvers : [ElementPlusResolver()]
      })
    ]
  },
  devServer: {
    proxy: {
      '/tzb' : {
        target : 'http://localhost:9421',
        changeOrigin : true
      }
    }
  }
})
