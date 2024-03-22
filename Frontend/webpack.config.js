const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CopyPlugin = require("copy-webpack-plugin");
const { CleanWebpackPlugin } = require('clean-webpack-plugin');

module.exports = {
  optimization: {
    usedExports: true
  },
  entry: {

    plantParent: path.resolve(__dirname, 'src', 'pages', 'plantParent.js'), //main entry point
  },
  output: {
    path: path.resolve(__dirname, 'dist'),
    filename: '[name].js',
  },
  devServer: {
    https: false,
    port: 8080,
    open: true,
    proxy: [
      {
        context: [
          '/plant',
        ],
        target: 'http://localhost:5001'

      }
    ]
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: './src/dontLeafMeAlone.html',
      filename: 'dontLeafMeAlone.html',
      inject: false
    }),
    new HtmlWebpackPlugin({
          template: './src/findPlants.html',
          filename: 'findPlants.html',
          inject: false
    }),
    new HtmlWebpackPlugin({
          template: './src/myPlants.html',
          filename: 'myPlants.html',
          inject: false
    }),

    new CopyPlugin({
      patterns: [
        {
          from: path.resolve('src/css'),
          to: path.resolve("dist/css")
        }
      ]
    }),
    new CleanWebpackPlugin()
  ]
}
