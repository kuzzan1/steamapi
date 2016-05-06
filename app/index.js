import express from 'express';
import falcor from 'falcor';
import falcorExpress from 'falcor-express';
import Router from 'falcor-router';
import * as services from './src/services';
import BaseRouter from './src/routers/base-router';
const app = express();

app.use(express.static( __dirname + '/'));

app.use('/model.json', falcorExpress.dataSourceRoute(function (req, res) {
    return new BaseRouter();
}));

app.listen(3000, () => {
    console.log('Listening on port 3000');
});
