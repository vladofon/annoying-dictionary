const { defineConfig } = require('@vue/cli-service')
const Dotenv = require('dotenv-webpack');

module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    compress: true,
    port: 8081,
    allowedHosts: [
      process.env.VUE_APP_BACKEND_URL
    ],
    proxy: process.env.VUE_APP_BACKEND_URL,
  },
  configureWebpack: {
    plugins: [
      new Dotenv()
    ]
  },
  pluginOptions: {
    vuetify: {
			// https://github.com/vuetifyjs/vuetify-loader/tree/next/packages/vuetify-loader
		}
  }
})
