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
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        target: 'https://perenual.com/docs/api' //http://localhost:5001
=======
        target: 'http://localhost:5001' //API server address
>>>>>>> Stashed changes
=======
        target: 'http://localhost:5001' //API server address
>>>>>>> Stashed changes
      }
    ]
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: './src/dontLeafMeAlone.html',
      filename: 'index.html',
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
