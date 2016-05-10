module.exports = {
    entry: './src/client/index.js',
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
              loaders: ["style", "css?sourceMap", "sass?sourceMap"]
            }
        ]
    },
    devtool: 'source-map'
}
