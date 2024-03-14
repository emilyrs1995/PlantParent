const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CopyPlugin = require("copy-webpack-plugin");
const { CleanWebpackPlugin } = require('clean-webpack-plugin');

module.exports = {
  optimization: {
    usedExports: true
  },
  entry: {
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    plantParent: path.resolve(__dirname, 'src', 'pages', 'plantParent.js'),
=======
    plantParent: path.resolve(__dirname, 'src', 'pages', 'plantParent.js'), //main entry point
>>>>>>> Stashed changes
=======
    plantParent: path.resolve(__dirname, 'src', 'pages', 'plantParent.js'), //main entry point
>>>>>>> Stashed changes
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
        target: 'http://localhost:5001' //API server address

      }
    ]
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: './src/dontLeafMeAlone.html',
      filename: 'dontLeafMeAlone.html',
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
