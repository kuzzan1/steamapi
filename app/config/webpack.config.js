module.exports = {
    entry: './src/client/index.jsx',
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
            }
        ]
    },
    devtool: 'source-map'
}