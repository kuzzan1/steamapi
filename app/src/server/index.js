const FalcorServer = require('falcor-express');
const bodyParser = require('body-parser');
const express = require('express');
const app = express();
const BaseRouter = require('./base-router');

app.use(bodyParser.urlencoded({extended: false}));

app.use('/model.json', FalcorServer.dataSourceRoute(() => new BaseRouter()));

app.use(express.static(__dirname + '/../site/'));

app.listen(9090, err => {
    if (err) {
        console.error(err)
        return
    }
    console.log('navigate to http://localhost:9090')
});

app.use(function(req, res){

  res.sendfile('index.html', {root: './src/site/'});
});
