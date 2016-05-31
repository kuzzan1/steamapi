var autoprefixer = require('autoprefixer');
var ExtractTextPlugin = require("extract-text-webpack-plugin");

module.exports = {
    entry: {
        app: './src/client/app.js'
    },
    output: {
        filename: './src/site/bundle.js'
    },
    module: {
        loaders: [
            {
              test: /\.js/,
              loader: 'babel',
              exclude: /node_modules/,
              query: {
                  presets: ['es2015', 'react', 'stage-0']
              }
            },
            {
              test: /\.scss$/,
              loaders: ["style", "css?sourceMap", "sass?sourceMap", "postcss-loader"]
            },
            {
              test:   /\.css$/,
              loaders: [
                ExtractTextPlugin.extract("style-loader", "css-loader"),
                "style-loader!css-loader!postcss-loader"
              ]
            }
        ]
    },
    sassLoader: {
      includePaths: ["./src/client/mixins"]
    },
    postcss: [ autoprefixer({ browsers: ['last 20 versions'] }) ],
    devtool: 'source-map',
    plugins: [
      new ExtractTextPlugin("[name].css")
    ]
}
